package javabrains.springboot.tutorial.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController 
{
	
	@Autowired
	private TopicService topicService;
	
	/**
	 * Get
	 * @return
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopic() 
	{
		return topicService.getAllTopics();
	}
	
	/**
	 * Get
	 * @return
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	/**
	 * Post
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
}
