package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.DBFileDTO;
import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.DBFile;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.exception.FileStorageException;
import com.example.internshipmanagement.exception.MyFileNotFoundException;
import com.example.internshipmanagement.mappers.FileMapper;
import com.example.internshipmanagement.properties.FileStorageProperties;

import com.example.internshipmanagement.repositories.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    @Autowired
    private final DBFileRepository dbFileRepository;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties, DBFileRepository dbFileRepository) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        this.dbFileRepository = dbFileRepository;

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public void deleteFileById(Long id) {
        dbFileRepository.deleteById(id);
    }
    public String storeFile(MultipartFile file, Long id) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            DBFile dbFile = new DBFile();
            dbFile.setFileName(fileName);
            dbFile.setFileType(file.getContentType());
            dbFile.setData(file.getBytes());
            dbFile.setStudent(id);
            dbFileRepository.save(dbFile);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    public List<DBFileDTO> findAll() {
        return fileMapper.listToDtos(dbFileRepository.findAll());
    }

    public Optional<DBFileDTO> updateFile(Long fileId, DBFileDTO fileDTO) {
        Optional<DBFile> etudiantOptional = dbFileRepository.findById(fileId);
        if (etudiantOptional.isPresent()) {
            DBFile file = fileMapper.fromDto(fileDTO);
            file.setId(fileId);
            DBFile updatedFile = dbFileRepository.save(file);
            return Optional.of(fileMapper.toDto(updatedFile));
        }
        return Optional.empty();
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
