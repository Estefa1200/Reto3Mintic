/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entidades.Admin;
import com.example.demo.Repository.adminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ecast
 */
@Service
public class adminService {
    @Autowired
    private adminRepository adminRepository;
    
    public List<Admin> getAll() {
        return(List<Admin>) adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin p){
        if(p.getIdAdmin()==null){
            return adminRepository.save(p);
        }else {
            Optional<Admin> e=adminRepository.getAdmin(p.getIdAdmin());
            if(e.isPresent()){
                return p;
            }else{
                return adminRepository.save(p);
            }
        }
    }
    
    public Admin update(Admin p){
        if(p.getIdAdmin()!=null){
            Optional<Admin> q =adminRepository.getAdmin(p.getIdAdmin());
            if(!q.isEmpty()){
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                
                return adminRepository.save(q.get()) ;
            }
        }
        return p;
    }
    
    public boolean delete(int id){
        boolean flag=getAdmin(id).map(e ->{
          adminRepository.delete(e);
          return true;
        }).orElse(false);
        return flag;
    }
}
