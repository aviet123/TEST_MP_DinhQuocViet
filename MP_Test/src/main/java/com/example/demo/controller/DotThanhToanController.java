package com.example.demo.controller;

import com.example.demo.model.CongTac;
import com.example.demo.model.DotThanhToan;
import com.example.demo.service.dotthanhtoan.DotThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/dtt")
public class DotThanhToanController {

    @Autowired
    DotThanhToanService dotThanhToanService;

    @GetMapping("/details/{id}")
    public DotThanhToan getDotThanhToanById(@PathVariable("id") Integer id){
        return dotThanhToanService.findById(id).get();
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<DotThanhToan>> getAll(){
        Iterable<DotThanhToan> dotThanhToans = dotThanhToanService.findAll();
        return new ResponseEntity<>(dotThanhToans, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDotThanhToan(@Valid @RequestBody DotThanhToan dotThanhToan){
        dotThanhToanService.save(dotThanhToan);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public DotThanhToan editDotThanhToan(@PathVariable("id") Integer id, @RequestBody DotThanhToan dotThanhToanEdit){
        Optional<DotThanhToan> dotThanhToan = dotThanhToanService.findById(id);
        if (dotThanhToan.isPresent()){
            dotThanhToan.get().setTenDot(dotThanhToanEdit.getTenDot());
            dotThanhToan.get().setPhieuTT(dotThanhToanEdit.getPhieuTT());
            dotThanhToan.get().setGiaTri(dotThanhToanEdit.getGiaTri());
            return dotThanhToanService.save(dotThanhToan.get());
        }else {
            return null;
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteDotThanhToan(@PathVariable("id") Integer id){
        Optional<DotThanhToan> dotThanhToan = dotThanhToanService.findById(id);
        if (dotThanhToan.isPresent()){
            dotThanhToanService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
