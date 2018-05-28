package javabrains.springboot.tutorial.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javabrains.springboot.tutorial.course.Course;

@RestController
public class LessonController 
{
	
	@Autowired
	private LessonService lessonService;
	
	/**
	 * Get
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String courseId) 
	{
		return lessonService.getAllLessons(courseId);
	}
	
	/**
	 * Get
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id)
	{
		return lessonService.getLesson(id);
	}
	
	/**
	 * Post
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId)
	{
		lesson.setCourse(new Course(courseId, "", "", ""));
		lessonService.addLesson(lesson);
	}
	
	/**
	 * Put
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{lesson}")
	public void updateCourse(@RequestBody Lesson lesson, @PathVariable String courseId)
	{
		lesson.setCourse(new Course(courseId, "", "", ""));
		lessonService.updateLesson(lesson);
	}
	
	/**
	 * Delete
	 * @return
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		lessonService.deleteLesson(id);
	}
}
