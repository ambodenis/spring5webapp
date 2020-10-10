package ambodenis.Spring5WebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ambodenis.Spring5WebApp.domain.Author;
import ambodenis.Spring5WebApp.domain.Book;
import ambodenis.Spring5WebApp.domain.Publisher;
import ambodenis.Spring5WebApp.repositories.AuthorRepository;
import ambodenis.Spring5WebApp.repositories.BookRepository;
import ambodenis.Spring5WebApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Publisher marko = new Publisher("Marko Markovic", "Pancevacka bb", "Zrenjanin", "Srbija", "23000");
		
		publisherRepository.save(marko);
		
		System.out.println("Publisher count: "+ publisherRepository.count());
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(marko);
		marko.getBooks().add(ddd);
		
		publisherRepository.save(marko);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "123456789");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(marko);
		
		marko.getBooks().add(noEJB);
				
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(marko);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: "+ bookRepository.count());
		System.out.println("Publisher no. of Books: " + marko.getBooks().size());
	}

}
