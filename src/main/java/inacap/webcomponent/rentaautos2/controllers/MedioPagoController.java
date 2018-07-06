/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.controllers;

import inacap.webcomponent.rentaautos2.Repository.MedioPagoRepository;
import inacap.webcomponent.rentaautos2.models.MedioPago;
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
public class MedioPagoController {
    
@Autowired
    private MedioPagoRepository medioPagoRepository;

    @GetMapping()
    public Iterable<MedioPago> list() {

        return medioPagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedioPago> get(@PathVariable String id) {
        Optional<MedioPago> aOptional = medioPagoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedioPago> put(@PathVariable String id, @RequestBody MedioPago editarMedioPago) {

        Optional<MedioPago> aOptional = medioPagoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();

            editarMedioPago.setIdMedioPago(aEncontrado.getIdMedioPago());
            medioPagoRepository.save(editarMedioPago);
            return new ResponseEntity<>(editarMedioPago, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPago nuevoMedioPago) {
        nuevoMedioPago = medioPagoRepository.save(nuevoMedioPago);

        Optional<MedioPago> aOptional = medioPagoRepository.findById(nuevoMedioPago.getIdMedioPago());

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<MedioPago> aOptional = medioPagoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            MedioPago aEncontrado = aOptional.get();

            medioPagoRepository.deleteById(aEncontrado.getIdMedioPago());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }

}    