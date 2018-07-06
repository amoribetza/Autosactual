/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.controllers;

import inacap.webcomponent.rentaautos2.Repository.VehiculoRepository;
import inacap.webcomponent.rentaautos2.models.Modelo;
import inacap.webcomponent.rentaautos2.models.Vehiculo;
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
public class VehiculoController {
    
@Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping()
    public Iterable<Vehiculo> list() {

        return vehiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> get(@PathVariable String id) {
        Optional<Vehiculo> aOptional = vehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> put(@PathVariable String id, @RequestBody Vehiculo editarVehiculo) {

        Optional<Vehiculo> aOptional = vehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();

            editarVehiculo.setIdVehiculo(aEncontrado.getIdVehiculo());
            vehiculoRepository.save(editarVehiculo);
            return new ResponseEntity<>(editarVehiculo, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Vehiculo nuevoVehiculo) {
        nuevoVehiculo = vehiculoRepository.save(nuevoVehiculo);

        Optional<Vehiculo> aOptional = vehiculoRepository.findById(nuevoVehiculo.getIdVehiculo());

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Vehiculo> aOptional = vehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            Vehiculo aEncontrado = aOptional.get();

            vehiculoRepository.deleteById(aEncontrado.getIdVehiculo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
         }
     }