/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository.CRUDRepository;

import com.example.demo.Entidades.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ecast
 */
public interface reservationCRUDRepository extends CrudRepository<Reservation, Integer>{
    
}
