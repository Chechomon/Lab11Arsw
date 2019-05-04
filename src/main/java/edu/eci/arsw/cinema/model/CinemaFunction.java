/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import edu.eci.arsw.cinema.persistence.CinemaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author cristian
 */
public class CinemaFunction {
	
    private Movie movie;
    private List<List<AtomicBoolean>> seats=new ArrayList<>();
    private String date;
    
    public CinemaFunction(){}
    
    public CinemaFunction(Movie movie, String date){
        this.movie=movie;
        this.date=date;
        for (int i=0;i<7;i++){
            List<AtomicBoolean> row= new ArrayList<>(Arrays.asList(new AtomicBoolean[12]));
            Collections.fill(row, new AtomicBoolean(true));
            this.seats.add(row);
        }
    }
    
    public void buyTicket(int row,int col) throws CinemaException{
        if (seats.get(row).get(col).equals(true)){
            seats.get(row).set(col,new AtomicBoolean(false));
        }
        else{
            throw new CinemaException("Seat booked");
        }
    }
    
    public List<List<AtomicBoolean>> getSeats() {
        return this.seats;
    }
    
    public int getAvailability() {
    	int availability=0;
    	for (int i=0;i<seats.size();i++){
    		for(int j= 0; j<seats.get(i).size();j++)
	            if(seats.get(i).get(j).equals(true)) {
	            	availability++;
	            }
        }
    	return availability;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void setSeats(List<List<AtomicBoolean>> s) {
    	this.seats=s;
    }
        
    /*public String toString() {
    	return "[Movie: "+movie+",Fecha: "+date+"]";
    }*/
    
    
}
