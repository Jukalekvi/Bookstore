package hh.backend.jukka.com.bookstore.repository;


import hh.backend.jukka.com.bookstore.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
