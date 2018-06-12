package com.rest.mastermicro.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.mastermicro.Exception.UserNotFoundException;
import com.rest.mastermicro.model.User;
import com.rest.mastermicro.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice; 
	
	//GET /users
	@GetMapping("/users")
	public List<User> retriveallusers(){
		return userservice.findAll();
	}
	
	//GET /users/1
	@GetMapping("/users/{id}")
	public Resource<User> Retriveoneuser(@PathVariable int id) {
		User user = userservice.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id:"+id);
		 
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).retriveallusers());
		resource.add(linkto.withRel("all-users"));
		
		return resource;
	}
	
	//POST /user
	@PostMapping("/users")
	public ResponseEntity<Object> createnewuser(@Valid @RequestBody User user) {
		User createdUser = userservice.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//DELETE /users/1
    @DeleteMapping("/users/{id}")
	public void deletegivenuser(@PathVariable int id) {
		User user = userservice.deletebyid(id);
		
		if(user == null)
			throw new UserNotFoundException("id:"+id);
		}
}
