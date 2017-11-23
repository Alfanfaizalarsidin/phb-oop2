package com.example.demo.repo;

import com.example.demo.entity.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasienRepo 
        extends JpaRepository<Pasien,String>{
}
