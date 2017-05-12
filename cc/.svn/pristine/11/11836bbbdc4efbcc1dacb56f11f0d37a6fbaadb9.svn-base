package com.service;

import com.dao.PersonDao;
import com.entity.Person;

public class PersonService {
	private PersonDao personDao;
	
	public PersonService(){
		personDao = new PersonDao();
	}
	
	public Person login(Person person){
		return personDao.login(person);
	}
	public boolean isExist(String id){
		return personDao.exist(id);
	}
		
}
