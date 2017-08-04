package edu.berliner.bookdatabasegroup.repositories;


import edu.berliner.bookdatabasegroup.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books,Long> {



}
