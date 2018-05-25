package javabrains.springboot.tutorial.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Business service in spring.
 * @author davidmandelbaum
 *
 */
@Service
public class TopicService 
{
	private List<Topic> topics = Arrays.asList
	(
		new Topic("spring", "Spring Framework", "Spring Framework Description"),
		new Topic("java", "core java", "core java Description"),
		new Topic("javascript", "Javascript", "Javascript Description")
	);
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
}
