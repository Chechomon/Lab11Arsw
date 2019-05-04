package edu.eci.arsw.cinema.test;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.impl.FilterByAvailability;
import edu.eci.arsw.cinema.persistence.impl.FilterByGender;
import edu.eci.arsw.cinema.persistence.impl.InMemoryCinemaPersistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristian
 */
public class InMemoryPersistenceTest {

    @Test
    public void saveNewAndLoadTest() throws CinemaPersistenceException{
        InMemoryCinemaPersistence ipct=new InMemoryCinemaPersistence();

        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("Movies Bogotá",functions);
        ipct.saveCinema(c);
        
        assertNotNull("Loading a previously stored cinema returned null.",ipct.getCinema(c.getName()));
        assertEquals("Loading a previously stored cinema returned a different cinema.",ipct.getCinema(c.getName()), c);
    }


    @Test
    public void saveExistingCinemaTest() {
        InMemoryCinemaPersistence ipct=new InMemoryCinemaPersistence();
        
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("Movies Bogotá",functions);
        
        try {
            ipct.saveCinema(c);
        } catch (CinemaPersistenceException ex) {
            fail("Cinema persistence failed inserting the first cinema.");
        }
        
        List<CinemaFunction> functions2= new ArrayList<>();
        CinemaFunction funct12 = new CinemaFunction(new Movie("SuperHeroes Movie 3","Action"),functionDate);
        CinemaFunction funct22 = new CinemaFunction(new Movie("The Night 3","Horror"),functionDate);
        functions.add(funct12);
        functions.add(funct22);
        Cinema c2=new Cinema("Movies Bogotá",functions2);
        try{
            ipct.saveCinema(c2);
            fail("An exception was expected after saving a second cinema with the same name");
        }
        catch (CinemaPersistenceException ex){
            
        }
                
        
    }
    
    @Test
    public void getCinemaByNameTest() throws CinemaPersistenceException{
        InMemoryCinemaPersistence ipct=new InMemoryCinemaPersistence();
        try {
            Assert.assertFalse(ipct.getCinema("cinemaX").equals(ipct.getCinema("Movies Bogotá")));
        } catch (CinemaPersistenceException ex) {
            fail("Cinema persistence failed inserting the first cinema.");
        }
        
    }
    
    @Test
    public void buyTicketTest() throws CinemaException{
     InMemoryCinemaPersistence ipct=new InMemoryCinemaPersistence();
     
      try {
           ipct.buyTicket(2, 2, "cinemaX", "2018-12-18 15:30","SuperHeroes Movie");
           ipct.buyTicket(2, 2, "cinemaX", "2018-12-18 15:30","SuperHeroes Movie");
           
        } catch (CinemaException ex) {
        	System.out.println("No se puede comprar 2 veces");
            Assert.assertTrue(true);
        }
     
    }
    
    @Test
    public void getFunctionsbyCinemaAndDateTest() throws CinemaPersistenceException, CinemaException{
    	InMemoryCinemaPersistence ipct= new InMemoryCinemaPersistence();
    	String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        functions.add(funct1);
        Cinema c=new Cinema("CINE",functions);
        try {
			ipct.saveCinema(c);
		} catch (CinemaPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	List<CinemaFunction> function= ipct.getFunctionsbyCinemaAndDate("CINE", "2018-12-18 15:30");
    	for(CinemaFunction ci: function) {
    		if(!ci.getMovie().getName().equals("SuperHeroes Movie")) {
    			assertTrue(false);
    		}
    	}
    	assertTrue(true);
    }
    
    @Test
    public void FilterByAvalability() {
		InMemoryCinemaPersistence ipct = new InMemoryCinemaPersistence();
		FilterByAvailability filter = new FilterByAvailability();
		String functionDate = "2018-12-18 15:30";
		List<CinemaFunction> functions = new ArrayList<>();
		CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2", "Action"), functionDate);
		CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2", "Horror"), functionDate);
		functions.add(funct1);
		functions.add(funct2);
		Cinema c = new Cinema("Movies Bogotá", functions);

		functions = new ArrayList<>();
		funct1 = new CinemaFunction(new Movie("La momia", "Terror"), functionDate);
		funct2 = new CinemaFunction(new Movie("Duro de matar", "Action"), functionDate);
		functions.add(funct1);
		functions.add(funct2);
		Cinema c2 = new Cinema("Procinal", functions);
		List<Movie> result= new ArrayList<>();
    	Cinema cine;
		try {
			ipct.saveCinema(c);
			ipct.saveCinema(c2);
			cine = ipct.getCinema("Procinal");
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					ipct.buyTicket(i, j, c2.getName(), functionDate, "La momia");
				}
			}
			List<CinemaFunction> f= cine.getFunctions();
			for(CinemaFunction cf: f){
			    if(cf.getDate().equals("2018-12-18 15:30") && cf.getAvailability()==40) result.add(cf.getMovie());
				}
			
			
			List<Movie> lcf = filter.filteredByAvailablity(ipct,"Procinal", "2018-12-18 15:30", 40);
			for (Movie cf : lcf) {
				assertFalse(cf.getName().equals("La momia"));
			}
			System.out.println();
		} catch (CinemaPersistenceException e) {
			e.printStackTrace();
		} catch (CinemaException e) {
			e.printStackTrace();
		}

	}
    
    @Test
    public void FilterByGender() {
    	InMemoryCinemaPersistence ipct=new InMemoryCinemaPersistence();
    	FilterByGender filter =  new FilterByGender();
    	String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("CineCo",functions);
        
        functions= new ArrayList<>();
        funct1 = new CinemaFunction(new Movie("Ted","Humor"),functionDate);
        funct2 = new CinemaFunction(new Movie("Matanza 3","Action"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c2=new Cinema("Procinal",functions);
        
    	try {
			ipct.saveCinema(c);
			ipct.saveCinema(c2);
			List<Movie> lcf = filter.filteredByGender(ipct,"Procinal", "2018-12-18 15:30", "Humor");
			for(Movie cf : lcf) {
				assertFalse(cf.getName().equals("Matanza 3"));
			}
			System.out.println();
			lcf = filter.filteredByGender(ipct,"CineCo", "2018-12-18 15:30", "Horror");
			for(Movie cf : lcf) {
				assertTrue(cf.getName().equals("The Night 2"));
			}
		} catch (CinemaPersistenceException e) {
			e.printStackTrace();
		}

    }

    
    
    
   
}
