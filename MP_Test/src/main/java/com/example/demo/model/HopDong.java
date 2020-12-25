package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHD;

    @NotNull
    private String soHD;

    @NotNull
    private String goiThau;

    @ManyToOne
    private LoaiHD maLoai;

    private Double giaTri;

}
