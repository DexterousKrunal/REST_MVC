package io.krunal.springRest.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.krunal.springRest.Exception.NotFoundException;
import io.krunal.springRest.entity.Users;
import io.krunal.springRest.repository.UserRepository;
import io.krunal.springRest.service.UserService;


@Service
public class UserServiceImpl implements UserService{

UserRepository repository;	
	public UserServiceImpl(UserRepository repository)
	{
		this.repository=repository;
	}
	@Override
	public List<Users> searchAll() {
     // TO Auto-generated method stub
		
		return repository.searchAll();
	}

	@Override
	public Users searchSpecific(String id) {
		// TODO Auto-generated
		Users existing = repository.searchSpecific(id);
		if (existing == null)
		{
			throw new NotFoundException("user with id " + id + "Not available" );
		}
		return repository.searchSpecific(id);
	}

	@Override
	public Users create(Users user) {
		// TODO Auto-generated method stub
		return repository.create(user);
	}

	@Override
	public Users update(String id, Users user) {
		// TODO Auto-generated method stub
		Users existing = repository.searchSpecific(id);
		if (existing == null)
		{
			throw new NotFoundException("user with id " + id + "Not available" );
		}
		return repository.update(id, user);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Users existing = repository.searchSpecific(id);
		if (existing == null)
		{
			throw new NotFoundException("user with id " + id + "Not available" );
		}
		repository.delete(existing);
		
	}

}
