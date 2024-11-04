package hh.backend.jukka.com.bookstore;

import hh.backend.jukka.com.bookstore.domain.Book;
import hh.backend.jukka.com.bookstore.domain.Category;
import hh.backend.jukka.com.bookstore.repository.BookRepository;
import hh.backend.jukka.com.bookstore.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(CategoryRepository categoryRepository, BookRepository bookRepository) {
        return args -> {
            // Luodaan kategorioita
            Category sciFi = new Category("Sci-fi");
            Category comic = new Category("Comic");
            Category fantasy = new Category("Fantasy");

            // Tallennetaan kategoriat
            categoryRepository.saveAll(Arrays.asList(sciFi, comic, fantasy));
            System.out.println("Categories saved to database.");

			Book book1 = new Book("Dune", "Frank Herbert", 1965, 9780441013593L, 19.99);
			Book book2 = new Book("Watchmen", "Alan Moore", 1986, 9780930289232L, 14.99);
			Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, 9780261103344L, 12.99);
			

            // Tallennetaan kirjat
            bookRepository.saveAll(Arrays.asList(book1, book2, book3));
            System.out.println("Books saved to database.");
        };
    }
}
