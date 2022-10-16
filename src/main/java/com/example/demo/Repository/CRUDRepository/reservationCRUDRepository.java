/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository.CRUDRepository;

import com.example.demo.Entidades.Reservation;
import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ecast
 */
public interface reservationCRUDRepository extends CrudRepository<Reservation, Integer>{
    //Reporte 1
    //SELECT * FROM Reservation WHERE startDate AFTER fechaA AND devolutionDate BEFORE fechaB;
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);

    //Reporte 2
    //SELECT * FROM Reservation WHERE status="valorQueNecesito";
    public List<Reservation> findAllByStatus(String status);

    //Reporte 3
    //SELECT COUNT(client), client FROM Reservation GROUP BY client ORDER BY COUNT(client) DESC;
    @Query("SELECT c.client,COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();

}
