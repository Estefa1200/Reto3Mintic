/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository.CRUDRepository;

import com.example.demo.Entidades.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ecast
 */
public interface messageCRUDRepository extends CrudRepository<Message, Integer>{
    
}
