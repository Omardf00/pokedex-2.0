package com.pokemon.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pokemon.pokedex.dao.UserDao;
import com.pokemon.pokedex.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public User save(User user) {
		return dao.save(user);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

}
