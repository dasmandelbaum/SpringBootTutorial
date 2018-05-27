package javabrains.springboot.tutorial.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javabrains.springboot.tutorial.topic.Topic;

@RestController
public class CourseController 
{
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * Get
	 * @return
	 */
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) 
	{
		return courseService.getAllCourses(id);
	}
	
	/**
	 * Get
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id)
	{
		return courseService.getCourse(id);
	}
	
	/**
	 * Post
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	/**
	 * Put
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{course}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	/**
	 * Delete
	 * @return
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
}
