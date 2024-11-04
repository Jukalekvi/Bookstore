package hh.backend.jukka.com.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    private String title;
    private String author;
    private Integer publicationYear;

    @Column(unique = true)
    private Long isbn; // Muutettu Long-tyypiksi

    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id") // määritellään viiteavain Category-tauluun
    private Category category;

    public Book() {}

    //Konstruktorit
    public Book(String title, String author, Integer publicationYear, Long isbn, Double price) { // Muutettu Long-tyypiksi
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    //Getterit
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public Long getIsbn() { // Muutettu Long-tyypiksi
        return isbn;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    //Setterit
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(Long isbn) { // Muutettu Long-tyypiksi
        this.isbn = isbn;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + 
               ", publicationYear=" + publicationYear + ", isbn=" + isbn + ", price=" + price + "]";
    }
}
