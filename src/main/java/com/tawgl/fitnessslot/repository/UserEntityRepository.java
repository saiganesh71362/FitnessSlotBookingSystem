package com.tawgl.fitnessslot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawgl.fitnessslot.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
