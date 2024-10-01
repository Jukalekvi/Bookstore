package hh.backend.jukka.com.bookstore.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import hh.backend.jukka.com.bookstore.domain.Book;
import hh.backend.jukka.com.bookstore.repository.BookRepository;

@Component
@Configuration
public class BookstoreInitializer {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("Book Title 1", "Author 1", 2021, 123456789, 19.99));
            repository.save(new Book("Book Title 2", "Author 2", 2022, 987654321, 29.99));
            repository.save(new Book("Book Title 3", "Author 3", 2023, 112233445, 39.99));
        };
    }
}
