/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.controllers;

import inacap.webcomponent.rentaautos2.Repository.TraccionRepository;
import inacap.webcomponent.rentaautos2.models.Traccion;
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
public class TraccionController {
    
@Autowired
    private TraccionRepository traccionRepository;

    @GetMapping()
    public Iterable<Traccion> list() {

        return traccionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traccion> get(@PathVariable String id) {
        Optional<Traccion> aOptional = traccionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traccion> put(@PathVariable String id, @RequestBody Traccion editarTraccion) {

        Optional<Traccion> aOptional = traccionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();

            editarTraccion.setIdTraccion(aEncontrado.getIdTraccion());
            traccionRepository.save(editarTraccion);
            return new ResponseEntity<>(editarTraccion, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Traccion nuevoTraccion) {
        nuevoTraccion = traccionRepository.save(nuevoTraccion);

        Optional<Traccion> aOptional = traccionRepository.findById(nuevoTraccion.getIdTraccion());

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Traccion> aOptional = traccionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Traccion aEncontrado = aOptional.get();

            traccionRepository.deleteById(aEncontrado.getIdTraccion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
         }
     }
