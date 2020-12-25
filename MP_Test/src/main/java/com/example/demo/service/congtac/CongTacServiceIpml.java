package com.example.demo.service.congtac;

import com.example.demo.model.CongTac;
import com.example.demo.repository.CongTacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CongTacServiceIpml implements CongTacService {

    @Autowired
    CongTacRepository congTacRepository;

    @Override
    public Iterable<CongTac> findAll() {
        return congTacRepository.findAll();
    }

    @Override
    public Optional<CongTac> findById(Integer id) {
        return congTacRepository.findById(id);
    }

    @Override
    public CongTac save(CongTac congTac) {
        return congTacRepository.save(congTac);
    }

    @Override
    public void remove(Integer id) {
        congTacRepository.deleteById(id);
    }
}
