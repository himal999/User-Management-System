package com.asia.usermanagementsystem.repository;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
