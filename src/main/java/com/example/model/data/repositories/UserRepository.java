package com.example.model.data.repositories;

import com.example.model.data.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 5 - Building CRUD APIs
 * Model - CrudRepository
 */
public interface UserRepository extends CrudRepository<User, Long> {


}