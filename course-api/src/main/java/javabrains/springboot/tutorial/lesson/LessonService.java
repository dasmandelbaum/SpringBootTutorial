package javabrains.springboot.tutorial.lesson;

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
public class LessonService 
{
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String id)
	{
		List<Lesson> lessons = new ArrayList<Lesson>();
		lessonRepository.findByCourseId(id)
		.forEach(lessons::add);
		return lessons;
	}
	
	public Lesson getLesson(String id)
	{
		return lessonRepository.findOne(id);
	}

	public void addLesson(Lesson lesson) 
	{
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) 
	{
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String id) 
	{
		lessonRepository.delete(id);
	}
	
}
