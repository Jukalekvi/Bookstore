package hh.backend.jukka.com.bookstore.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.jukka.com.bookstore.domain.Book;
import hh.backend.jukka.com.bookstore.domain.Category;
import hh.backend.jukka.com.bookstore.repository.BookRepository;
import hh.backend.jukka.com.bookstore.repository.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Näyttää kirjat listassa
    @GetMapping("/booklist")
    public String showBookList(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }
    
    // Näyttää lomakkeen uuden kirjan lisäämiseen
    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());

        // Hae kategoriat ja lisää ne malliin
        List<Category> categories = new ArrayList<>((Collection<Category>) categoryRepository.findAll()); // Vaihtoehto 1
        // List<Category> categories = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
        //                                         .collect(Collectors.toList()); // Vaihtoehto 2
        model.addAttribute("categories", categories);
        
        return "addbook";
    }
    
    // Käsittelee lomakkeen ja tallentaa uuden kirjan
    @PostMapping("/savebook")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
    
    // Poistaa kirjan ID:n perusteella
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }
    
    // Kirjan muokkaamis-sivulle ID:n perusteella siirtyminen
    @GetMapping("/editbook/{id}")
    public String showEditBookForm(@PathVariable("id") Long bookId, Model model) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new IllegalArgumentException("Virheellinen kirjan ID: " + bookId));
        model.addAttribute("book", book);
        
        // Hae kategoriat ja lisää ne malliin
        List<Category> categories = new ArrayList<>((Collection<Category>) categoryRepository.findAll()); // Vaihtoehto 1
        // List<Category> categories = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
        //                                         .collect(Collectors.toList()); // Vaihtoehto 2
        model.addAttribute("categories", categories);
        
        return "editbook";
    }
}
