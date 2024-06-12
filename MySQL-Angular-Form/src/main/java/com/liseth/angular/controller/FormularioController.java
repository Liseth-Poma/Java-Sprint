package com.liseth.angular.controller;

import com.liseth.angular.model.Formulario;
import com.liseth.angular.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/formularios")
public class FormularioController {

    @Autowired
    private FormularioService formularioService;

    @GetMapping
    public List<Formulario> getAllFormularios() {
        return formularioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formulario> getFormularioById(@PathVariable Long id) {
        Optional<Formulario> formulario = formularioService.findById(id);
        return formulario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Formulario createFormulario(@Validated @RequestBody Formulario formulario) {
        return formularioService.save(formulario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formulario> updateFormulario(@PathVariable Long id, @Validated @RequestBody Formulario formularioDetails) {
        Optional<Formulario> formulario = formularioService.findById(id);

        if (!formulario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Formulario updatedFormulario = formulario.get();
        updatedFormulario.setName(formularioDetails.getName());
        updatedFormulario.setDate(formularioDetails.getDate());
        updatedFormulario.setText(formularioDetails.getText());
        updatedFormulario.setCategory(formularioDetails.getCategory());
        updatedFormulario.setGender(formularioDetails.getGender());
        updatedFormulario.setEmail(formularioDetails.getEmail());

        Formulario savedFormulario = formularioService.save(updatedFormulario);
        return ResponseEntity.ok(savedFormulario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormulario(@PathVariable Long id) {
        Optional<Formulario> formulario = formularioService.findById(id);

        if (!formulario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        formularioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
