/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Message;
import com.example.demo.Repository.CRUDRepository.messageCRUDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecast
 */
@Repository
public class messageRepository {
    @Autowired
    private messageCRUDRepository messageCRUDRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageCRUDRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCRUDRepository.findById(id);
    }

    public Message save(Message c){
        return messageCRUDRepository.save(c);
    }

    public void delete(Message c){
        messageCRUDRepository.delete(c);
    }
}
