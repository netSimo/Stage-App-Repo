package com.example.internshipmanagement.repositories;

import com.example.internshipmanagement.entities.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBFileRepository extends JpaRepository<DBFile, Long>{
}
