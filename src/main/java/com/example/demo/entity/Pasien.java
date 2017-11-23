package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "mahasiswa")
public class Pasien {
    
    @Id
    @Getter @Setter
    private String id;
    
    @Getter @Setter
    private String nama;
    
    @Getter @Setter
    private String dokter;
    
}
