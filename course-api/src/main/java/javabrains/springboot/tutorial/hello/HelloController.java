package javabrains.springboot.tutorial.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple get request
 * @author davidmandelbaum
 *
 */
@RestController
public class HelloController 
{
	@RequestMapping("/hello")
	public String sayHi()
	{
		return "Hi";
	}
}
