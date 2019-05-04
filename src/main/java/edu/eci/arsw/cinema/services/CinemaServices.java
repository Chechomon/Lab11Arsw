/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.services;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import edu.eci.arsw.cinema.persistence.Filter;
import edu.eci.arsw.cinema.persistence.FilterException;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */
@Service
public class CinemaServices {
    @Autowired
    @Qualifier("RedisCinemaPersistence")
    CinemaPersitence cps;
    
    public CinemaPersitence getCps() {
		return cps;
	}

	public void setCps(CinemaPersitence cps) {
		this.cps = cps;
	}

	public Filter getFil() {
		return fil;
	}

	public void setFil(Filter fil) {
		this.fil = fil;
	}

	@Autowired
    @Qualifier("FilterByGender")
    Filter fil;
    
    public void addNewCinema(Cinema c) throws CinemaPersistenceException{
        cps.saveCinema(c);
    }
    
    public Set<Cinema> getAllCinemas(){ 
        return cps.getAllCinemas();
    }
    
    /**
     * 
     * @param name cinema's name
     * @return the cinema of the given name created by the given author
     * @throws CinemaException
     * @throws CinemaPersistenceException 
     */
    public Cinema getCinemaByName(String name) throws CinemaException, CinemaPersistenceException{
        return cps.getCinema(name);
    }
    
    
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException{
        cps.buyTicket(row, col, cinema, date, movieName);
    }
    
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) throws CinemaPersistenceException, CinemaException {
        return cps.getFunctionsbyCinemaAndDate(cinema, date);
    }
    
    public CinemaFunction getFunctionsbyCinemaAndDateAndMovie(String cinema, String date, String movie) throws CinemaPersistenceException, CinemaException {
        return cps.getFunctionbyCinemaAndDateAndMovie(cinema, date, movie);
    }
    
    public List<Movie> filteredByGender(String cinema, String date,String gender) throws CinemaPersistenceException, FilterException{
    	return fil.filteredByGender(cps, cinema, date, gender);
    }
    
    public List<Movie> filteredByAvailablity(String cinema, String date, int seats) throws CinemaPersistenceException, FilterException{
    	return fil.filteredByAvailablity(cps, cinema, date, seats);
    }
    
    public void addFunctionToCinema(CinemaFunction cf, String cinema) throws CinemaPersistenceException {
    	cps.addFunctionToCinema(cf, cinema);
    }

	public void updateCinemaFunction(CinemaFunction c, String name) throws CinemaPersistenceException {
		cps.updateCinemaFunction(c,name);
		
	}

}
