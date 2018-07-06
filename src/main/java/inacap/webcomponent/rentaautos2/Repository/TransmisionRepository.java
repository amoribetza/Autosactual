/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.Repository;

import org.springframework.data.repository.CrudRepository;
import inacap.webcomponent.rentaautos2.models.Transmision;

/**
 *
 * @author Amori
 */
public interface TransmisionRepository extends CrudRepository<Transmision, Integer> {
    
}
