/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entidades.Reservation;
import com.example.demo.Repository.reservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecast
 */
@Service
public class reservationService {
    @Autowired
    private reservationRepository reservationRepository;
    
    public List<Reservation> getAll() {
        return(List<Reservation>) reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else {
            Optional<Reservation> e=reservationRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return p;
            }else{
                return reservationRepository.save(p);
            }
        }
    }
    
    public Reservation update(Reservation p){
        if(p.getIdReservation()!=null){
            Optional<Reservation> q =reservationRepository.getReservation(p.getIdReservation());
            if(!q.isEmpty()){
                if(p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                if(p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if(p.getScore()!=null){
                    q.get().setScore(p.getScore());
                }
                
                return reservationRepository.save(q.get()) ;
            }
        }
        return p;
    }
    
    public boolean delete(int id){
        boolean flag=getReservation(id).map(e ->{
          reservationRepository.delete(e);
          return true;
        }).orElse(false);
        return flag;
    }
    
   
}
