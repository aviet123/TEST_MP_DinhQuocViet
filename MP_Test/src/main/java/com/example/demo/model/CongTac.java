package com.example.demo.model;


import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
public class CongTac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 6)
    @NotNull
    private String maCT;

    @Size(max = 50)
    @NotNull
    private String tenCT;

    @Size(max = 10)
    private String DTV;

    @NotNull
    private Double soLuong;

    @NotNull
    private Double donGia;

    @NotNull
    private Double thanhTien;

    @ManyToOne
    private DotThanhToan dotThanhToan;

    public Double getThanhTien() {
        return donGia*soLuong;
    }
}
