/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Client;
import com.example.demo.Repository.CRUDRepository.clientCRUDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecast
 */
@Repository
public class clientRepository {
    @Autowired
    private clientCRUDRepository clientCRUDRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientCRUDRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCRUDRepository.findById(id);
    }

    public Client save(Client c){
        return clientCRUDRepository.save(c);
    }

    public void delete(Client c){
        clientCRUDRepository.delete(c);
    }
}
