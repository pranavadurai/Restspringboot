package com.rest.mastermicro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.mastermicro.model.helloworldbean;

@RestController	
public class Helloworld {

	@GetMapping(path ="hello-world")
	public String showhelloworld(){
		return "hello-world";
	}
	
	@GetMapping(path="hello-world-bean")
	public helloworldbean showhelloworldbean(){
	    return new helloworldbean("hello world");	
	}
	
	@GetMapping(path="hello-world/{name}")
	public String Helloworldwithpath(@PathVariable String name) {
		return String.format("hello welcome, %s" , name);
	}	
}
