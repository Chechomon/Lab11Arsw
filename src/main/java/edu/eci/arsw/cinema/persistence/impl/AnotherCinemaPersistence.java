package edu.eci.arsw.cinema.persistence.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;

@Component("AnotherCinemaPersistence")
public class AnotherCinemaPersistence implements CinemaPersitence{

	@Override
	public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCinema(Cinema cinema) throws CinemaPersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cinema getCinema(String name) throws CinemaPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Cinema> getAllCinemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Cinema> getCinemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CinemaFunction getFunctionbyCinemaAndDateAndMovie(String cinema, String date, String Movie)
			throws CinemaPersistenceException, CinemaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFunctionToCinema(CinemaFunction cf, String cinema) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCinemaFunction(CinemaFunction c, String name) {
		// TODO Auto-generated method stub
		
	}

}
