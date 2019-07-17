package com.crudtest.TestCrudBoot.service;

import com.crudtest.TestCrudBoot.repository.User;

public interface SavedValueService {

public User getById(long id);

void insertUser(String name,String email);

void deleteUser(long id);
}
