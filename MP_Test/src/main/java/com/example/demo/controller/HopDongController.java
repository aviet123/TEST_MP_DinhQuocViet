package com.example.demo.controller;

import com.example.demo.model.DotThanhToan;
import com.example.demo.model.HopDong;
import com.example.demo.service.hopdong.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/hopdongs")
public class HopDongController {

    @Autowired
    HopDongService hopDongService;

    @GetMapping("/details/{id}")
    public HopDong getHopDongById(@PathVariable("id") Integer id){
        return hopDongService.findById(id).get();
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<HopDong>> getAll(){
        Iterable<HopDong> hopDongs = hopDongService.findAll();
        return new ResponseEntity<>(hopDongs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createHopDong(@Valid @RequestBody HopDong hopDong){
        hopDongService.save(hopDong);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public HopDong editHopDong(@PathVariable("id") Integer id, @RequestBody HopDong hopDongEdit){
        Optional<HopDong> hopDong = hopDongService.findById(id);
        if (hopDong.isPresent()){
            hopDong.get().setSoHD(hopDongEdit.getSoHD());
            hopDong.get().setGoiThau(hopDongEdit.getGoiThau());
            hopDong.get().setGiaTri(hopDongEdit.getGiaTri());
            return hopDongService.save(hopDong.get());
        }else {
            return null;
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteHopDong(@PathVariable("id") Integer id){
        Optional<HopDong> dotThanhToan = hopDongService.findById(id);
        if (dotThanhToan.isPresent()){
            hopDongService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
