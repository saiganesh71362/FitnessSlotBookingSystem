package com.tawgl.fitnessslot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tawgl.fitnessslot.entity.ClassesEntity;
import com.tawgl.fitnessslot.serviceimpl.ClassesServiceImpl;

@RestController
public class ClassesController {
	ClassesServiceImpl classesServiceImpl;

	public ClassesController(ClassesServiceImpl classesServiceImpl) {
		super();
		this.classesServiceImpl = classesServiceImpl;
	}

	@PostMapping("/newClasses")
	public ResponseEntity<ClassesEntity> newClassCreate(@RequestBody ClassesEntity classesEntity) throws Exception {
		ClassesEntity newClassCreate = classesServiceImpl.newClassCreate(classesEntity);
		return new ResponseEntity<>(newClassCreate, HttpStatus.CREATED);
	}

	@GetMapping("/classesById/{id}")
	public ResponseEntity<ClassesEntity> getClassById(@PathVariable Long id) throws Exception {
		ClassesEntity classById = classesServiceImpl.getClassById(id);
		return new ResponseEntity<>(classById, HttpStatus.FOUND);

	}

	@GetMapping("/allClasses")
	public ResponseEntity<List<ClassesEntity>> getAllClasses() {
		List<ClassesEntity> allClasses = classesServiceImpl.getAllClasses();
		return new ResponseEntity<>(allClasses, HttpStatus.FOUND);
	}

	@PutMapping("/updateClassesById/{id}")
	public ResponseEntity<ClassesEntity> updateClassById(@PathVariable Long id,
			@RequestBody ClassesEntity classesEntity) throws Exception {
		ClassesEntity updateClassById = classesServiceImpl.updateClassById(id, classesEntity);

		return new ResponseEntity<>(updateClassById, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteClassesById/{id}")
	public ResponseEntity<Boolean> deleteClassesById(@PathVariable Long id) throws Exception {
		boolean deleteClassesById = classesServiceImpl.deleteClassesById(id);
		return new ResponseEntity<>(deleteClassesById, HttpStatus.OK);
	}
}
