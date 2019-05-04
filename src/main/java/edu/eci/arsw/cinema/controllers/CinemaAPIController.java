/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import edu.eci.arsw.cinema.services.CinemaServices;

@RestController
@RequestMapping(value = "/cinema")
@Service
public class CinemaAPIController {
	@Autowired
	CinemaServices cs;	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> manejadorGetRecursoCinema(){
	    try {
	    	
	        return new ResponseEntity<>(cs.getAllCinemas(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@RequestMapping(value="{name}",method = RequestMethod.GET)
	public ResponseEntity<?> obtenerFuncionesPorNombre(@PathVariable String name){
	    try {
	        return new ResponseEntity<>(cs.getCinemaByName(name).getFunctions(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error cinema no encontrado",HttpStatus.NOT_FOUND);
	    }
	}
	
	@RequestMapping(value="{name}/{date}",method = RequestMethod.GET)
	public ResponseEntity<?> obtenerFuncionesPorNombre(@PathVariable String name,@PathVariable String date){
	    try {
	        return new ResponseEntity<>(cs.getFunctionsbyCinemaAndDate(name, date),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error funciones no encontradas",HttpStatus.NOT_FOUND);
	    }
	}
	
	@RequestMapping(value="{name}/{date}/{moviename}",method = RequestMethod.GET)
	public ResponseEntity<?> obtenerFuncionesPorNombre(@PathVariable String name,@PathVariable String date, @PathVariable String moviename){
	    try {
	        return new ResponseEntity<>(cs.getFunctionsbyCinemaAndDateAndMovie(name, date, moviename),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	    }
	}
	
	@RequestMapping(value="{name}", method = RequestMethod.POST)	
	public ResponseEntity<?> manejadorPostRecursoCinemaFuncion(@RequestBody CinemaFunction c, @PathVariable String name){
	    try {
	    	cs.addFunctionToCinema(c, name);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception ex) {
	        Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }

	}
	
	@RequestMapping(value="{name}", method = RequestMethod.PUT)	
	public ResponseEntity<?> manejadorPutRecursoCinemaFuncion(@RequestBody CinemaFunction c, @PathVariable String name){
	    try {
	    	cs.updateCinemaFunction(c,name);
	        return new ResponseEntity<>(cs.getCinemaByName(name),HttpStatus.CREATED);
	    } catch (Exception ex) {
	        Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }

	}

	
}
