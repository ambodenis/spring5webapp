package ambodenis.Spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import ambodenis.Spring5WebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
