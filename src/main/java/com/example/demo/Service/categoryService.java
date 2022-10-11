/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;


import com.example.demo.Entidades.Category;
import com.example.demo.Repository.categoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecast
 */
@Service
public class categoryService {
    @Autowired
    private categoryRepository categoryRepository;
    
    public List<Category> getAll() {
        return(List<Category>) categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else {
            Optional<Category> e=categoryRepository.getCategory(p.getId());
            if(e.isPresent()){  
                return p;
            }else{
                return categoryRepository.save(p);
            }
        }
    }
    
    public Category update(Category p){
        if(p.getId()!=null){
            Optional<Category> q =categoryRepository.getCategory(p.getId());
            if(!q.isEmpty()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                
                return categoryRepository.save(q.get()) ;
            }
        }
        return p;
    }
    
    public boolean delete(int id){
        boolean flag=getCategory(id).map(e ->{
          categoryRepository.delete(e);
          return true;
        }).orElse(false);
        return flag;
    }
}
