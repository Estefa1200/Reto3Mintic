/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entidades.Lib;
import com.example.demo.Repository.libRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecast
 */
@Service
public class libService {
    @Autowired
    private libRepository libRepository;
    
    public List<Lib> getAll() {
        return(List<Lib>) libRepository.getAll();
    }

    public Optional<Lib> getLib(int id){
        return libRepository.getLib(id);
    }
    
    public Lib save(Lib p){
        if(p.getId()==null){
            return libRepository.save(p);
        }else {
            Optional<Lib> e=libRepository.getLib(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return libRepository.save(p);
            }
        }
    }
    
    public Lib update(Lib p){
        if(p.getId()!=null){
            Optional<Lib> q =libRepository.getLib(p.getId());
            if(!q.isEmpty()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getTarget()!=null){
                    q.get().setTarget(p.getTarget());
                }
                if(p.getCapacity()!=null){
                    q.get().setCapacity(p.getCapacity());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                return libRepository.save(q.get()) ;
            }else{
                return p;
            }
        }
        return p;
    }
    public boolean delete(int id){
        boolean flag = getLib(id).map(e ->{
          libRepository.delete(e);
          return true;
        }).orElse(false);
        return flag;
    }
  
}
