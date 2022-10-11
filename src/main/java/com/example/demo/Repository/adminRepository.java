/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entidades.Admin;
import com.example.demo.Repository.CRUDRepository.adminCRUDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ecast
 */
@Repository
public class adminRepository {
    @Autowired
    private adminCRUDRepository adminCRUDRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminCRUDRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminCRUDRepository.findById(id);
    }

    public Admin save(Admin c){
        return adminCRUDRepository.save(c);
    }

    public void delete(Admin c){
        adminCRUDRepository.delete(c);
    }
}
