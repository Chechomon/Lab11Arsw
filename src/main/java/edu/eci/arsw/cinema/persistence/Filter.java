package edu.eci.arsw.cinema.persistence;
import java.util.List;
import java.util.Map;

import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;

public interface Filter {
	
	public List<Movie> filteredByGender(CinemaPersitence cinemas,String cinema, String date, String gender) throws CinemaPersistenceException, FilterException;
	
	public List<Movie> filteredByAvailablity(CinemaPersitence cinemas,String cinema, String date, int seats) throws CinemaPersistenceException, FilterException;
	
	
}
