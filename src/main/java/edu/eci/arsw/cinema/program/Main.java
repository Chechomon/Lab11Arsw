package edu.eci.arsw.cinema.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.FilerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.FilterException;
import edu.eci.arsw.cinema.services.CinemaServices;

public class Main {
	/*
	public static void main(String args[]) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("Probando getAllCinemas");
		CinemaServices cs= ac.getBean(CinemaServices.class);
		Set<Cinema> setCinemas= cs.getAllCinemas();
		System.out.println("Los cinemas que hay son: ");
		for(Cinema c: setCinemas) {
			System.out.println(c.getName());
		}
		System.out.println();
		System.out.println("Ahora se agregará un nuevo cine, llamado Movies Bogtá");
		String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("Movies Bogotá",functions);
        try {
			cs.addNewCinema(c);
			setCinemas = cs.getAllCinemas();
		} catch (CinemaPersistenceException e) {
			e.printStackTrace();
		}
        System.out.println("La lista de cines cambia a la siguiente: ");
        for(Cinema ci: setCinemas) {
			System.out.println(ci.getName());
		}
        System.out.println();
        System.out.println("Qeremos obtener las funciones de determinado cine (Movies Bogotá)");
        try {
			c= cs.getCinemaByName("Movies Bogotá");
			List<CinemaFunction> cf= c.getFunctions();
			System.out.println("La lista de peliculas de dicho cine son:");
			for(CinemaFunction f: cf) {
				System.out.println(f.getMovie().getName());
			}
			System.out.println();
			System.out.println("Ahora se quiere saber cuales peliculas estan en cierta fecha, en un nuevo cine");
			System.out.println("llamado cine colombia (2018-10-18 15:30)");
			functionDate = "2018-10-18 15:30";
	        functions= new ArrayList<>();
	        funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
	        funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),"2018-11-18 15:30");
	        functions.add(funct1);
	        functions.add(funct2);
	        c=new Cinema("cine colombia",functions);
	        cs.addNewCinema(c);
	        List<CinemaFunction> mo= cs.getFunctionsbyCinemaAndDate("cine colombia", "2018-10-18 15:30");
	        for(CinemaFunction f: mo) {
	        	System.out.println(f.getMovie().getName());
	        }
	        System.out.println("Se quiere saber las del dia siguiente al anterior:");
	        mo= cs.getFunctionsbyCinemaAndDate("cine colombia", "2018-11-18 15:30");
	        for(CinemaFunction f: mo) {
	        	System.out.println(f.getMovie().getName());
	        }
	        
		} catch (CinemaException e) {
			e.printStackTrace();
		} catch (CinemaPersistenceException e) {
			e.printStackTrace();
		}
        System.out.println();
        System.out.println("Ahora se quieren comprar tickets para en cine colombia para la pelicula SuperHeroes Movie 2 ");
        try {
			cs.buyTicket(1, 1, "cine colombia",functionDate , "SuperHeroes Movie 2");
		} catch (CinemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Una vez comprado el ticket se intentará comprar de nuevo");
        try {
			cs.buyTicket(1, 1, "cine colombia",functionDate , "SuperHeroes Movie 2");
		} catch (CinemaException e) {
			System.err.println("Para lo que ocurre una excepción debido a que ya se compro o reservo antes");
		}
        System.out.println();
        System.out.println("Ahora se filtrara por genero, ya que es el tipo de filtro que se tiene en el momento");
        System.out.println("El filtro que se hará sera por Horror");
        List<Movie> m;
		try {
			m = cs.filteredByGender("cine colombia","2018-11-18 15:30" , "Horror");
			System.out.println("La lista de peliculas de horror para el cine cine colombia el dia 2018-11-18 15:30 es:");
	        for(Movie p: m) {
	        	System.out.println(p.getName());
	        }
		} catch (CinemaPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FilterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println();
        System.out.println("Ahora se intentará filtrar por sillas, para lo que nos saldrá una excepción debido a que no se puede realizar ese filtro"
        		+ " con el que se tiene actualmente");
        
    	try {
			m= cs.filteredByAvailablity("cine colombia","2018-11-18 15:30" , 3);
		} catch (CinemaPersistenceException e) {
			
		} catch (FilterException e) {
			System.err.println(e.getMessage());
		}
        
        
        
        
        
	}*/
	
	

}
