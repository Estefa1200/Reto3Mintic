/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Lib;
import com.example.demo.Repository.CRUDRepository.libCRUDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecast
 */
@Repository
public class libRepository {
    @Autowired
    private libCRUDRepository libCRUDRepository;
    
    public List<Lib> getAll(){
        return (List<Lib>) libCRUDRepository.findAll();
    }

    public Optional<Lib> getLib(int id){
        return libCRUDRepository.findById(id);
    }

    public Lib save(Lib c){
        return libCRUDRepository.save(c);
    }

    public void delete(Lib c){
        libCRUDRepository.delete(c);
    }
}
