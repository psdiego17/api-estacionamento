package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
	
	@GetMapping("/index")
	public String index() {
		
		return "Hello World com Sprin Boot";
	}

}
