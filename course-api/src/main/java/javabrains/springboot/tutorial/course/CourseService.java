package javabrains.springboot.tutorial.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business service in spring.
 * @author davidmandelbaum
 *
 */
@Service
public class CourseService 
{
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String id)
	{
		List<Course> topics = new ArrayList<Course>();
		courseRepository.findByTopicId(id)
		.forEach(topics::add);
		return topics;
	}
	
	public Course getCourse(String id)
	{
		return courseRepository.findOne(id);
	}

	public void addCourse(Course topic) 
	{
		courseRepository.save(topic);
	}

	public void updateCourse(Course course) 
	{
		courseRepository.save(course);
	}

	public void deleteCourse(String id) 
	{
		courseRepository.delete(id);
	}
	
}
