package com.example.demo.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
public class DotThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDot;

    @NotNull
    @Size(max = 50)
    private String tenDot;

    @NotNull
    private String phieuTT;

    private LocalDate ngay;

    private Double giaTri;

    @ManyToOne
    private HopDong hopDong;
}
