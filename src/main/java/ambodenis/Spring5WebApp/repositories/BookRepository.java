package ambodenis.Spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import ambodenis.Spring5WebApp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
