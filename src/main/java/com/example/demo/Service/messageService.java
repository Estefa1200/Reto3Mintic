/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entidades.Message;
import com.example.demo.Repository.messageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecast
 */
@Service
public class messageService {
    @Autowired
    private messageRepository messageRepository;
    
    public List<Message> getAll() {
        return(List<Message>) messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message p){
        if(p.getIdMessage()==null){
            return messageRepository.save(p);
        }else {
            Optional<Message> e=messageRepository.getMessage(p.getIdMessage());
            if(e.isPresent()){
                return p;
            }else{
                return messageRepository.save(p);
            }
        }
    }
    
    public Message update(Message p){
        if(p.getIdMessage()!=null){
            Optional<Message> q =messageRepository.getMessage(p.getIdMessage());
            if(!q.isEmpty()){
                if(p.getMessageText()!=null){
                    q.get().setMessageText(p.getMessageText());
                }
                
                return messageRepository.save(q.get()) ;
            }
        }
        return p;
    }
    
    public boolean delete(int id){
        boolean flag=getMessage(id).map(e ->{
          messageRepository.delete(e);
          return true;
        }).orElse(false);
        return flag;
    }
}
