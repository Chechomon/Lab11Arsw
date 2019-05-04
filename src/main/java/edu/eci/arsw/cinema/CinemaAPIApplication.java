/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import edu.eci.arsw.cinema.util.RedisMethods;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;


/**
 *
 * @author cristian
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.cinema"})
public class CinemaAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaAPIApplication.class, args);
        RedisMethods.saveToREDIS("1","Hola");
        System.out.println(RedisMethods.getFromREDIS("1"));

	String functionDate = "2018-12-18 15:30";
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
/*	try{
	   System.out.println(RedisMethods.getSeatsREDIS("cinemaX",funct1));
	}catch(CinemaException e){e.printStackTrace();}*/
        
    }
}
