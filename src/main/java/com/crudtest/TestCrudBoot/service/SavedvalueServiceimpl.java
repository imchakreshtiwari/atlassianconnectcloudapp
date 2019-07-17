package com.crudtest.TestCrudBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudtest.TestCrudBoot.repository.User;
import com.crudtest.TestCrudBoot.repository.UserRepository;

@Service
public class SavedvalueServiceimpl implements SavedValueService {
@Autowired
	UserRepository userRepository;
	
	public SavedvalueServiceimpl() {
		super();
	}

	
	
	@Override
	public User getById(long id) {
		System.out.println("inside findone method");
		return userRepository.findOne(id);
	}

	@Override
	public void insertUser(String name, String email) {
		System.out.println("inside insert method");
		User user=new User(name,email);
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(long id) {
	System.out.println("inside delete method");
	
		userRepository.delete(id);
		
	}

	
}
