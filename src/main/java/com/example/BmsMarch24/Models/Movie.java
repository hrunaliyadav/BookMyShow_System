package com.example.BmsMarch24.Models;

import com.example.BmsMarch24.enums.Genre;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "movies")
public class Movie extends BaseModel{
    private String name;
    private Genre genre;
//    @OneToMany
//    private Show show;
}
