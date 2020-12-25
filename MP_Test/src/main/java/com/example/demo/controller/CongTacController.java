package com.example.demo.controller;

import com.example.demo.model.CongTac;
import com.example.demo.service.congtac.CongTacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/congtacs")
public class CongTacController {

    @Autowired
    CongTacService congTacService;

    @GetMapping("/details/{id}")
    public CongTac getCongTacById(@PathVariable("id") Integer id){
        return congTacService.findById(id).get();
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<CongTac>> getAll(){
        Iterable<CongTac> congTacs = congTacService.findAll();
        return new ResponseEntity<>(congTacs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCongTac(@Valid @RequestBody CongTac congTac){
        congTacService.save(congTac);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public CongTac editCongTac(@PathVariable("id") Integer id, @RequestBody CongTac congTacEdit){
        Optional<CongTac> congTac = congTacService.findById(id);
        if (congTac.isPresent()){
            congTac.get().setTenCT(congTacEdit.getTenCT());
            congTac.get().setDTV(congTacEdit.getDTV());
            congTac.get().setSoLuong(congTacEdit.getSoLuong());
            congTac.get().setDonGia(congTacEdit.getDonGia());
            congTac.get().setThanhTien(congTacEdit.getThanhTien());
             return congTacService.save(congTac.get());
        }else {
            return null;
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCongTac(@PathVariable("id") Integer id){
        Optional<CongTac> congTac = congTacService.findById(id);
        if (congTac.isPresent()){
            congTacService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
