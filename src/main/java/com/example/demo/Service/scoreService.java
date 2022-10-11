/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entidades.Score;
import com.example.demo.Repository.scoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecast
 */
@Service
public class scoreService {
    @Autowired
    private scoreRepository scoreRepository;
    
    public List<Score> getAll() {
        return(List<Score>) scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score p){
        if(p.getIdScore()==null){
            return scoreRepository.save(p);
        }else {
            Optional<Score> e=scoreRepository.getScore(p.getIdScore());
            if(e.isPresent()){
                return p;
            }else{
                return scoreRepository.save(p);
            }
        }
    }
    
    public Score update(Score p){
        if(p.getIdScore()!=null){
            Optional<Score> q =scoreRepository.getScore(p.getIdScore());
            if(!q.isEmpty()){
                if(p.getMessageText()!=null){
                    q.get().setMessageText(p.getMessageText());
                }
                if(p.getScore()!=null){
                    q.get().setScore(p.getScore());
                }
                
                return scoreRepository.save(q.get()) ;
            }
        }
        return p;
    }
    
    public boolean delete(int id){
        boolean flag=getScore(id).map(e ->{
          scoreRepository.delete(e);
          return true;
        }).orElse(false);
        return flag;
    }
}
