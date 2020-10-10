package ambodenis.Spring5WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ambodenis.Spring5WebApp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private final AuthorRepository authorReporitory;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorReporitory=authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorReporitory.findAll());
		
		return "authors/list";
	}
	
}
