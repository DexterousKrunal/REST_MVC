package io.krunal.springRest.controller;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.krunal.springRest.entity.Users;
import io.krunal.springRest.service.UserService;
@Controller
@ResponseBody         // we can use @RestController instead of controller + @Responsebody
public class UserController {
UserService service;	
	//Constructor level dependency injection
	public UserController(UserService service)
	{
		this.service=service;
	}
	//@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/USERS", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Users> searchAll(){
	return service.searchAll();
	}
	
	//@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/USERS/{ID}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users searchSpecific(@PathVariable("userID") String id){
		return service.searchSpecific(id);
	}
	//@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/USERS", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users create(@RequestBody Users user){
		return service.create(user);
	}
	
	//@ResponseBody
	@RequestMapping(method=RequestMethod.PUT, value="/USERS/{ID}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users update(@PathVariable("userId")String id, @RequestBody Users user){
		return service.update(id, user);
	}
	
	//@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value="/USERS/ID",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("userId") String id)
	{
		service.delete(id);
	}

}
