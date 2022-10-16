/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Entidades.dto;

/**
 *
 * @author ecast
 */
public class statusAccount {

    private Integer completed;
    private Integer cancelled;

    public statusAccount(int completed, int cancelled){
        this.completed=completed;
        this.cancelled=cancelled;
    }

    public statusAccount(Object completed, Object cancelled){
        this.completed=Integer.parseInt(completed.toString());
        this.cancelled=Integer.parseInt(cancelled.toString());

    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
    
    
}
