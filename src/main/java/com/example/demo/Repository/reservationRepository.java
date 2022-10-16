/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Client;
import com.example.demo.Entidades.Reservation;
import com.example.demo.Entidades.dto.TotalAndClient;
import com.example.demo.Repository.CRUDRepository.reservationCRUDRepository;
import java.util.ArrayList;
import java.util.*;

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
    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationCRUDRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA,fechaB);
    }
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCRUDRepository.findAllByStatus(status);
    }

    public List<TotalAndClient> getTopClients(){
        List<TotalAndClient> respuesta =new ArrayList<>();
        List<Object[]> reporte= reservationCRUDRepository.getTotalReservationsByClient();
        for (int i=0;i< reporte.size();i++){
            respuesta.add(new TotalAndClient((Long)reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }
        return respuesta;
    }
}
