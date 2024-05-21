package org.exercise.library.model;
import java.io.Serializable;

public class Book implements Serializable {
    //Attributes
    private String title;
    private int pages;
    private String author;
    private String publisher;

    //Builder
    public Book(String title, int pages, String author, String publisher) {
        setTitle(title);
        setPages(pages);
        setAuthor(author);
        setPublisher(publisher);
    }

    //Getter and Setter methods
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
    //**************************** SETTER ************************
    //Validation fot title, author and publisher fields
    private void validateText(String text, String fieldName) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " non può essere vuoto.");
        }
        if (!text.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException(fieldName + " deve contenere solo lettere e spazi.");
        }
    }


    public void setTitle(String title) {
        validateText(title, "Il titolo");
        this.title = title;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di zero.");
        }
        this.pages = pages;
    }

    public void setPublisher(String publisher) {
        validateText(publisher, "L'editore");
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        validateText(author, "L'autore");
        this.author = author;
    }

    //Override book info format
    @Override
    public String toString() {
        return "Title: '" + title + "' \n" +
         "Pages: '" + pages + "' \n" +
         "Author: '" + author + "' \n" +
         "Publisher: '" + publisher + "'" ;

    }
}
