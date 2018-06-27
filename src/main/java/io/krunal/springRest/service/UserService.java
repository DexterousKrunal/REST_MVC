package io.krunal.springRest.service;

import java.util.List;

import io.krunal.springRest.entity.Users;

public interface UserService {
	public List<Users> searchAll();
	public Users searchSpecific(String id);
	public Users create(Users user);
	public Users update(String id, Users user);
	public void delete(String id);
}
