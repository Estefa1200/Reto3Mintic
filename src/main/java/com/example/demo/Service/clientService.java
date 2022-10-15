/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entidades.Client;
import com.example.demo.Repository.clientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecast
 */
@Service
public class clientService {
    @Autowired
    private clientRepository clientRepository;
    
    public List<Client> getAll() {
        return(List<Client>) clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
        }else {
            Optional<Client> e=clientRepository.getClient(p.getIdClient());
            if(e.isPresent()){
                return p;
            }else{
                return clientRepository.save(p);
            }
        }
    }
    
    public Client update(Client p){
        if(p.getIdClient()!=null){
            Optional<Client> q =clientRepository.getClient(p.getIdClient());
            if(!q.isEmpty()){
                
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getAge()!=null){
                    q.get().setAge(p.getAge());
                }
                return clientRepository.save(q.get()) ;
            }
        }
        return p;
    }
    
    public boolean delete(int id){
        boolean flag=getClient(id).map(e ->{
          clientRepository.delete(e);
          return true;
        }).orElse(false);
        return flag;
    }
}
