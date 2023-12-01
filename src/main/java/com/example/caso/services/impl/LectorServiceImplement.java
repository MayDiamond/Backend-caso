package com.example.caso.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.caso.entity.Lectores;
import com.example.caso.repository.RepositoryLectores;
import com.example.caso.services.interfase.LectoresServices;

import jakarta.transaction.Transactional;

@Service ("lectorServiceImpl")
@Transactional
public class LectorServiceImplement  implements LectoresServices{

    @Autowired
    @Qualifier ("lectorRepository")
    private RepositoryLectores lectorRepository;

    @Override
    public List<Lectores> listAllLectores() {
        return (List<Lectores>) lectorRepository.findAll();
    }

    @Override
    public Optional<Lectores> findByIdLector(Long id) {

        return lectorRepository.findById(id);

    }

    @Override
    public Lectores updateLectores(Lectores lectores) {
    
        return lectorRepository.save(lectores);

    }

    @Override
    public void deleteLector(Long id) {
        lectorRepository.deleteById(id);
    }

    @Override
	public Lectores create(Lectores lectores) {

		return lectorRepository.save(lectores);
	}

    
}
