package io.krunal.springRest.repository;

import java.util.List;

import io.krunal.springRest.entity.Users;

public interface UserRepository {
	public List<Users> searchAll();
	public Users searchSpecific(String id);
	public Users create(Users user);
	public Users update(String id, Users user);
	public void delete(Users user);

}
