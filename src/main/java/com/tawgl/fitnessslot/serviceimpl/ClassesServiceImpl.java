package com.tawgl.fitnessslot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tawgl.fitnessslot.entity.ClassesEntity;
import com.tawgl.fitnessslot.exception.IdNotFoundException;
import com.tawgl.fitnessslot.exception.NewRecordCreationException;
import com.tawgl.fitnessslot.repository.ClassesRepository;
import com.tawgl.fitnessslot.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {
	ClassesRepository classesRepository;

	public ClassesServiceImpl(ClassesRepository classesRepository) {
		super();
		this.classesRepository = classesRepository;
	}

	@Override
	public ClassesEntity newClassCreate(ClassesEntity classesEntity) throws NewRecordCreationException {
		if (classesEntity != null) {
			return classesRepository.save(classesEntity);
		}
		throw new NewRecordCreationException("The Classes provided is null and cannot be created.");
	}

	@Override
	public ClassesEntity getClassById(Long id) throws IdNotFoundException {
		Optional<ClassesEntity> findById = classesRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		throw new IdNotFoundException("No Classes found with :" + id);
	}

	@Override
	public List<ClassesEntity> getAllClasses() {

		return classesRepository.findAll();
	}

	@Override
	public ClassesEntity updateClassById(Long id, ClassesEntity classesEntity) throws IdNotFoundException

	{
		if (classesRepository.existsById(id)) {
			ClassesEntity existingClasses = classesRepository.findById(id)
					.orElseThrow(() -> new IdNotFoundException("No Classes found with ID:" + id));

			existingClasses.setClassType(classesEntity.getClassType());
			existingClasses.setCapacity(classesEntity.getCapacity());
			existingClasses.setEnrolledCount(classesEntity.getEnrolledCount());
			existingClasses.setStartTime(classesEntity.getStartTime());
			existingClasses.setBookings(classesEntity.getBookings());
			return classesRepository.save(existingClasses);
		} else {
			throw new IdNotFoundException("Id Not Found :" + id);
		}
	}

	@Override
	public boolean deleteClassesById(Long id) throws IdNotFoundException {
		Optional<ClassesEntity> findById = classesRepository.findById(id);
		if (findById.isPresent()) {
			classesRepository.deleteById(id);
			return true;
		}
		throw new IdNotFoundException("Id Not Found :" + id);
	}

}
