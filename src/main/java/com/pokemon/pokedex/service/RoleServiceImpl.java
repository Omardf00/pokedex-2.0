package com.pokemon.pokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.dao.RoleDao;
import com.pokemon.pokedex.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao dao;

	@Override
	public Role findById(int id) {
		return dao.findById(id).orElse(null);
	}

}
