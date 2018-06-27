package io.krunal.springRest.repositoryImple;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.krunal.springRest.entity.Users;
import io.krunal.springRest.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Users> searchAll() {
		TypedQuery<Users> query = em.createNamedQuery("searchAll", Users.class);
		List<Users> users = query.getResultList();
		return users;
		/*List<Users> list = new ArrayList<Users>();
		Users user1= new Users();
		user1.setFirstName("Krunal");
		Users user2= new Users();
		user1.setFirstName("Ankita");
		Users user3= new Users();
		user1.setFirstName("Palak");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;*/
	}

	@Override
	public Users searchSpecific(String id) {
		// TODO Auto-generated method stub
		return em.find(Users.class, id);
	}

	@Override
	public Users create(Users user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user;
	}

	@Override
	public Users update(String id, Users user) {
		// TODO Auto-generated method stub
		return em.merge(user);
	}

	@Override
	public void delete(Users user) {
		// TODO Auto-generated method stub
		em.remove(user);
		
	}

}
