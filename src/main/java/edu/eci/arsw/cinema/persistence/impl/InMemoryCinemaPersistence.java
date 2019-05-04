/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence.impl;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */
@Component("inMemoryCinemaPersistence")
public class InMemoryCinemaPersistence implements CinemaPersitence{
    
    private final Map<String,Cinema> cinemas=new HashMap<>();

    public InMemoryCinemaPersistence() {
        //load stub data
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        functionDate = "2018-11-18 15:30";
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("cinemaX",functions);
        cinemas.put("cinemaX", c);
        
        functionDate = "2018-02-18 15:30";
        functions= new ArrayList<>();
        funct1 = new CinemaFunction(new Movie("Bajo la misma estrella","Love"),functionDate);
        functionDate = "2018-03-18 15:30";
        funct2 = new CinemaFunction(new Movie("Marvel","Action"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        c=new Cinema("CineColombia",functions);
        cinemas.put("CineColombia", c);
        
    }    

    @Override
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {
        try{
            Cinema ci=getCinema(cinema);
            List<CinemaFunction> f=ci.getFunctions();
            for(CinemaFunction cf: f){
                if(cf.getMovie().getName().equals(movieName)){
                    if(cf.getDate().equals(date)){
                        cf.buyTicket(row, col);
                        break;
                    }
                }
            }
            
        }catch (CinemaPersistenceException ex) {
            Logger.getLogger(InMemoryCinemaPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    @Override
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) throws CinemaPersistenceException, CinemaException {
    	List<CinemaFunction> result= new ArrayList<>();
        Cinema cine=getCinema(cinema);
        List<CinemaFunction> f= cine.getFunctions();
        for(CinemaFunction cf: f){
            if(cf.getDate().equals(date)) result.add(cf);
        }
        if(result.isEmpty()) throw new CinemaException("Funciones de cinema vacias");
        return result;
    }

    @Override
    public void saveCinema(Cinema c) throws CinemaPersistenceException {
        if (cinemas.containsKey(c.getName())){
            throw new CinemaPersistenceException("The given cinema already exists: "+c.getName());
        }
        else{
            cinemas.put(c.getName(),c);
        }   
    }

    @Override
    public Cinema getCinema(String name) throws CinemaPersistenceException {
        return cinemas.get(name);
    }
    
   
    
    @Override
    public Set<Cinema> getAllCinemas(){
    	Set<Cinema> allCinemas= new HashSet<Cinema>();
    	for(String s: cinemas.keySet()) {
    		allCinemas.add(cinemas.get(s));
    	}
    	
    	return allCinemas;
    }

	@Override
	public Map<String, Cinema> getCinemas() {
		return cinemas;
	}

	@Override
	public CinemaFunction getFunctionbyCinemaAndDateAndMovie(String cinema, String date, String Movie)
			throws CinemaPersistenceException, CinemaException {
		CinemaFunction result;
        Cinema cine=getCinema(cinema);
        List<CinemaFunction> f= cine.getFunctions();
        for(CinemaFunction cf: f){
            if(cf.getDate().equals(date) && cf.getMovie().getName().equals(Movie)) return cf;
        }
        throw new CinemaException("No existe la pelicula con esos argumentos");
	}

	@Override
	public void addFunctionToCinema(CinemaFunction cf, String cinema) throws CinemaPersistenceException {
		Cinema c= getCinema(cinema);
		c.addFunction(cf);	
	}

	@Override
	public void updateCinemaFunction(CinemaFunction c, String name) throws CinemaPersistenceException {
		
		Cinema cine= getCinema(name);
		cine.updateFunction(c);
		
	}
    
    
   

}
