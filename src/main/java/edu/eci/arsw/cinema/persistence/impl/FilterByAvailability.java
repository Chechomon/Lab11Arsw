package edu.eci.arsw.cinema.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import edu.eci.arsw.cinema.persistence.Filter;
import edu.eci.arsw.cinema.persistence.FilterException;

@Component("FilterByAvailability")
public class FilterByAvailability implements Filter{

	@Override
	public List<Movie> filteredByGender(CinemaPersitence cinemas, String cinema, String date, String gender) throws FilterException {
		throw new FilterException("Not supported for this filter.");
	}

	@Override
	public List<Movie> filteredByAvailablity(CinemaPersitence cinemas, String cinema, String date, int seats) throws CinemaPersistenceException {
		List<Movie> result= new ArrayList<>();
    	Cinema cine;
	
		cine = cinemas.getCinema(cinema);
		List<CinemaFunction> f= cine.getFunctions();
		for(CinemaFunction cf: f){
		    if(cf.getDate().equals(date) && cf.getAvailability()==seats) result.add(cf.getMovie());
		}
	
		
    	return result;
	}

	
}
