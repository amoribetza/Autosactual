/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.controllers;

import inacap.webcomponent.rentaautos2.Repository.DevolucionRepository;
import inacap.webcomponent.rentaautos2.models.Devolucion;
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
public class DevolucionController {
    
        @Autowired
    private DevolucionRepository devolucionRepository;

    @GetMapping()
    public Iterable<Devolucion> list() {

        return devolucionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devolucion> get(@PathVariable String id) {
        Optional<Devolucion> aOptional = devolucionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devolucion> put(@PathVariable String id, @RequestBody Devolucion editarDevolucion) {

        Optional<Devolucion> aOptional = devolucionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();

            editarDevolucion.setIdDevolucion(aEncontrado.getIdDevolucion());
            devolucionRepository.save(editarDevolucion);
            return new ResponseEntity<>(editarDevolucion, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Devolucion nuevoDevolucion) {
        nuevoDevolucion = devolucionRepository.save(nuevoDevolucion);

        Optional<Devolucion> aOptional = devolucionRepository.findById(nuevoDevolucion.getIdDevolucion());

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Devolucion> aOptional = devolucionRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Devolucion aEncontrado = aOptional.get();

            devolucionRepository.deleteById(aEncontrado.getIdDevolucion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }

}    

