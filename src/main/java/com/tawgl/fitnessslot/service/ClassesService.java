package com.tawgl.fitnessslot.service;

import java.util.List;

import com.tawgl.fitnessslot.entity.ClassesEntity;
import com.tawgl.fitnessslot.exception.IdNotFoundException;
import com.tawgl.fitnessslot.exception.NewRecordCreationException;

public interface ClassesService {

	public ClassesEntity newClassCreate(ClassesEntity classesEntity) throws NewRecordCreationException;

	public ClassesEntity getClassById(Long id) throws IdNotFoundException;

	public List<ClassesEntity> getAllClasses();

	public ClassesEntity updateClassById(Long id, ClassesEntity classesEntity) throws IdNotFoundException;

	public boolean deleteClassesById(Long id) throws IdNotFoundException;
}
