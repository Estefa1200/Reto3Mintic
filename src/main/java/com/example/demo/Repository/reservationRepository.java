/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Reservation;
import com.example.demo.Repository.CRUDRepository.reservationCRUDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecast
 */
@Repository
public class reservationRepository {
    @Autowired
    private reservationCRUDRepository reservationCRUDRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCRUDRepository.findById(id);
    }

    public Reservation save(Reservation c){
        return reservationCRUDRepository.save(c);
    }

    public void delete(Reservation c){
        reservationCRUDRepository.delete(c);
    }
}
