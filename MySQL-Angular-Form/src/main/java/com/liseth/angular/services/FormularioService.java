package com.liseth.angular.service;

import com.liseth.angular.model.Formulario;
import com.liseth.angular.repository.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    public List<Formulario> findAll() {
        return formularioRepository.findAll();
    }

    public Optional<Formulario> findById(Long id) {
        return formularioRepository.findById(id);
    }

    public Formulario save(Formulario formulario) {
        return formularioRepository.save(formulario);
    }

    public void deleteById(Long id) {
        formularioRepository.deleteById(id);
    }
}
