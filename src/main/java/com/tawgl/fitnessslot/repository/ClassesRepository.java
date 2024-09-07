package com.tawgl.fitnessslot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawgl.fitnessslot.entity.ClassesEntity;

public interface ClassesRepository extends JpaRepository<ClassesEntity, Long> {

	List<ClassesEntity> findByClassType(String classType);

	List<ClassesEntity> findByStartTimeAfter(LocalDate now);
}
