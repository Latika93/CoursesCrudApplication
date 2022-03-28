package com.crowthweb.NoteTaker.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.crowthweb.NoteTaker.Entity.Courses;
import com.crowthweb.NoteTaker.dao.CourseDao;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
//	List <Courses> list;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Courses(14, "Java Core" ,"Learn core java here"));
//		list.add(new Courses(15, "Java advance" ,"Learn Advance java here"));
//		list.add(new Courses(16, "Java servelts" ,"Learn servlets java here"));
	}
	
	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c = null;
		
//		for(Courses course: list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		
		return courseDao.getById(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {

//		list.forEach(e -> {
//			if(e.getId()== course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e->e.getId()!= parseLong).collect(Collectors.toList());
		Courses entity = courseDao.getById(parseLong);
		courseDao.delete(entity);
	}

}
