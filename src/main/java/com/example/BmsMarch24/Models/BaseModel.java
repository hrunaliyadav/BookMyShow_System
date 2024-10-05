package com.example.BmsMarch24.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseModel {
    @Id   //Primary class
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Id will auto increment
    private int id;
    private Date createdAt;
    private Date updatedAt;
}
