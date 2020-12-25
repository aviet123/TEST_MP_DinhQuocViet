package com.example.demo.service.hopdong;

import com.example.demo.model.HopDong;
import com.example.demo.repository.HopDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HopDongServiceImpl implements HopDongService {

    @Autowired
    HopDongRepository hopDongRepository;


    @Override
    public Iterable<HopDong> findAll() {
        return hopDongRepository.findAll();
    }

    @Override
    public Optional<HopDong> findById(Integer id) {
        return hopDongRepository.findById(id);
    }

    @Override
    public HopDong save(HopDong hopDong) {
        return hopDongRepository.save(hopDong);
    }

    @Override
    public void remove(Integer id) {
        hopDongRepository.deleteById(id);
    }
}
