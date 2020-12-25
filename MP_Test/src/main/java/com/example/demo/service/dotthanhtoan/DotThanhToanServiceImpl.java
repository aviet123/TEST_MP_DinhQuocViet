package com.example.demo.service.dotthanhtoan;

import com.example.demo.model.DotThanhToan;
import com.example.demo.repository.DotThanhToanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DotThanhToanServiceImpl implements DotThanhToanService {

    @Autowired
    DotThanhToanRepository dotThanhToanRepository;

    @Override
    public Iterable<DotThanhToan> findAll() {
        return dotThanhToanRepository.findAll();
    }

    @Override
    public Optional<DotThanhToan> findById(Integer id) {
        return dotThanhToanRepository.findById(id);
    }

    @Override
    public DotThanhToan save(DotThanhToan dotThanhToan) {
        return dotThanhToanRepository.save(dotThanhToan);
    }

    @Override
    public void remove(Integer id) {
        dotThanhToanRepository.deleteById(id);
    }
}
