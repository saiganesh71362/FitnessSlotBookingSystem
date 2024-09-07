package com.tawgl.fitnessslot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.tawgl.fitnessslot.entity.ClassesEntity;
import com.tawgl.fitnessslot.repository.ClassesRepository;
import com.tawgl.fitnessslot.serviceimpl.ClassesServiceImpl;

@SpringBootTest
class ClassesServiceImplTest {

	@Mock
	ClassesRepository classesRepository;

	@InjectMocks
	ClassesServiceImpl classesServiceImpl;

	@Test
	@Order(2)
	void test_getClassesById() {

		ClassesEntity yogaClass = new ClassesEntity();
		Long id = 2l;
		yogaClass.setId(id);
		yogaClass.setClassType("Yoga");
		yogaClass.setCapacity(20);
		yogaClass.setEnrolledCount(5);
		yogaClass.setStartTime(LocalDate.of(2024, 9, 10));

		when(classesRepository.findById(id)).thenReturn(Optional.of(yogaClass));

		assertEquals(yogaClass, classesServiceImpl.getClassById(id));

	}

	@Test
	@Order(3)
	void test_getAllClasses() {
		ArrayList<ClassesEntity> list = new ArrayList<>();

		ClassesEntity yogaClass = new ClassesEntity();
		yogaClass.setClassType("Yoga");
		yogaClass.setCapacity(20);
		yogaClass.setEnrolledCount(5);
		yogaClass.setStartTime(LocalDate.of(2024, 9, 10));

		ClassesEntity gymClass = new ClassesEntity();
		gymClass.setClassType("Gym");
		gymClass.setCapacity(30);
		gymClass.setEnrolledCount(10);
		gymClass.setStartTime(LocalDate.of(2024, 9, 12));

		list.add(yogaClass);
		list.add(gymClass);

		when(classesRepository.findAll()).thenReturn(list);

		assertEquals(2, classesServiceImpl.getAllClasses().size());

	}

}
