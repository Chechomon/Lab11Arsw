/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cristian
 */
public class Cinema {
    private String name;
    private List<CinemaFunction> functions=Collections.synchronizedList(new ArrayList<CinemaFunction>()); 
    
    
    public Cinema(){}
    
    public Cinema(String name,List<CinemaFunction> functions){
        this.name=name;
        this.functions=functions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CinemaFunction> getFunctions() {
        return this.functions;
    }

    public void setSchedule(List<CinemaFunction> functions) {
        this.functions = functions;
    }
    
    public void addFunction(CinemaFunction cf) {
    	functions.add(cf);
    }
    
    public void updateFunction(CinemaFunction c) {
    	boolean exists= false;
    	for(CinemaFunction cf: functions) {
    		if(cf.getMovie().getName().equals(c.getMovie().getName()) &&
    				cf.getDate().equals(c.getDate()) &&
    				cf.getMovie().getGenre().equals(c.getMovie().getGenre())) {
    			cf.setDate(c.getDate());
    			cf.setSeats(c.getSeats());
    			cf.getMovie().setGenre(c.getMovie().getGenre());
    			exists=true;
    			break;
    		}
    	}
    	if(!exists) addFunction(c);
    }
    
    /*public String toString() {
    	String cinema= "[Name: "+name+", Funciones: ";
    	for(CinemaFunction cf: functions) {
    		cinema+= cf.toString();
    	}
    	return cinema+" ]";
    }*/
}
