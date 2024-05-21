package org.exercise.library.model;
import java.io.Serializable;

public class Book implements Serializable {
    // Attributes
    private String title;
    private int pages;
    private String author;
    private String publisher;

    // Constructor with validated attributes
    public Book(String title, int pages, String author, String publisher) {
        // Set and validate title, pages, author and publisher
        setTitle(title);
        setPages(pages);
        setAuthor(author);
        setPublisher(publisher);
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    // Private method to validate text fields (title, author, publisher)
    private void validateText(String text, String fieldName) {
        if (text == null || text.trim().isEmpty()) {
            throw new InvalidBookDataException(fieldName + " non può essere vuoto.");
        }
        if (!text.matches("[a-zA-Z\\s]+")) {
            throw new InvalidBookDataException(fieldName + " deve contenere solo lettere e spazi.");
        }
    }
    // Setter methods with validation
    public void setTitle(String title) {
        validateText(title, "Il campo titolo");
        this.title = title;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new InvalidBookDataException("Il numero di pagine deve essere maggiore di zero.");
        }
        this.pages = pages;
    }

    public void setAuthor(String author) {
        validateText(author, "Il campo autore");
        this.author = author;
    }

    public void setPublisher(String publisher) {
        validateText(publisher, "Il campo editore");
        this.publisher = publisher;
    }
    //Override format of book info
    @Override
    public String toString() {
        return "Title: '" + title + "' \n" +
         "Pages: '" + pages + "' \n" +
         "Author: '" + author + "' \n" +
         "Publisher: '" + publisher + "'" ;

    }
}
