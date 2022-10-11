/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Score;
import com.example.demo.Repository.CRUDRepository.scoreCRUDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecast
 */
@Repository
public class scoreRepository {
    @Autowired
    private scoreCRUDRepository scoreCRUDRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCRUDRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreCRUDRepository.findById(id);
    }

    public Score save(Score c){
        return scoreCRUDRepository.save(c);
    }

    public void delete(Score c){
        scoreCRUDRepository.delete(c);
    }
}
