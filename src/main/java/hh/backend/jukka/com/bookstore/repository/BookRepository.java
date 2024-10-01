package hh.backend.jukka.com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hh.backend.jukka.com.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Voit määrittää omia kyselyjäsi, jos tarvitset
}
