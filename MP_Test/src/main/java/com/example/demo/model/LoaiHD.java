package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class LoaiHD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLoai;

    @NotNull
    private String tenLoai;

}
