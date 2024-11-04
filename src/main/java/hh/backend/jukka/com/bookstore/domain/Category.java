package hh.backend.jukka.com.bookstore.domain;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private String name;

    
    // Uusi books-attribuutti, jolla on yksi-moneen-suhde Book-olioluokkaan
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL) // määrittää suhteen ja cascade-käytännön
    private List<Book> books = new ArrayList<>();

    public Category() {}
    
    public Category(String name) {
        this.name = name;
    }
    //Getterit
    public Long getCategoryid() {
        return categoryid;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    //Setterit
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", name=" + name + "]";
    }
}