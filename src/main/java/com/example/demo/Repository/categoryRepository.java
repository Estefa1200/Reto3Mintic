/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Category;
import com.example.demo.Repository.CRUDRepository.categoryCRUDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecast
 */
@Repository
public class categoryRepository {
    @Autowired
    private categoryCRUDRepository categoryCRUDRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryCRUDRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCRUDRepository.findById(id);
    }

    public Category save(Category c){
        return categoryCRUDRepository.save(c);
    }

    public void delete(Category c){
        categoryCRUDRepository.delete(c);
    }
}
