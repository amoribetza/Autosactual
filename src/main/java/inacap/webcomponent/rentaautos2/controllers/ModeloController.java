/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.controllers;

import inacap.webcomponent.rentaautos2.Repository.ModeloRepository;
import inacap.webcomponent.rentaautos2.models.Modelo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Amori
 */
@RestController
@RequestMapping("/url")
public class ModeloController {
    
  @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping()
    public Iterable<Modelo> list() {

        return modeloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> get(@PathVariable String id) {
        Optional<Modelo> aOptional = modeloRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Modelo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> put(@PathVariable String id, @RequestBody Modelo editarModelo) {

        Optional<Modelo> aOptional = modeloRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Modelo aEncontrado = aOptional.get();

            editarModelo.setIdModelo(aEncontrado.getIdModelo());
            modeloRepository.save(editarModelo);
            return new ResponseEntity<>(editarModelo, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Modelo nuevoModelo) {
        nuevoModelo = modeloRepository.save(nuevoModelo);

        Optional<Modelo> aOptional = modeloRepository.findById(nuevoModelo.getIdModelo());

        if (aOptional.isPresent()) {
            Modelo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Modelo> aOptional = modeloRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Modelo aEncontrado = aOptional.get();

            modeloRepository.deleteById(aEncontrado.getIdModelo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
         }
     }