package hh.backend.jukka.com.bookstore.init;

import hh.backend.jukka.com.bookstore.domain.Category;
import hh.backend.jukka.com.bookstore.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public CategoryInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Lisää kategoriat tietokantaan
        categoryRepository.save(new Category("Sci-fi"));
        categoryRepository.save(new Category("Comic"));
        categoryRepository.save(new Category("Fantasy"));
        System.out.println("Categories saved to database.");
    }
}