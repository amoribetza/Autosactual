/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.controllers;

import inacap.webcomponent.rentaautos2.Repository.TipoVehiculoRepository;
import inacap.webcomponent.rentaautos2.models.TipoVehiculo;
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
public class TipoVehiculoController {
    
@Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @GetMapping()
    public Iterable<TipoVehiculo> list() {

        return tipoVehiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculo> get(@PathVariable String id) {
        Optional<TipoVehiculo> aOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculo> put(@PathVariable String id, @RequestBody TipoVehiculo editarTipoVehiculo) {

        Optional<TipoVehiculo> aOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();

            editarTipoVehiculo.setIdTipoVehiculo(aEncontrado.getIdTipoVehiculo());
            tipoVehiculoRepository.save(editarTipoVehiculo);
            return new ResponseEntity<>(editarTipoVehiculo, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculo nuevoTipoVehiculo) {
        nuevoTipoVehiculo = tipoVehiculoRepository.save(nuevoTipoVehiculo);

        Optional<TipoVehiculo> aOptional = tipoVehiculoRepository.findById(nuevoTipoVehiculo.getIdTipoVehiculo());

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<TipoVehiculo> aOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));

        if (aOptional.isPresent()) {
            TipoVehiculo aEncontrado = aOptional.get();

            tipoVehiculoRepository.deleteById(aEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
         }
     }