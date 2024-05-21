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
    //****************************************************
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }
        this.title = title;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di zero.");
        }
        this.pages = pages;
    }

    public void setPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("L'editore non può essere vuoto.");
        }
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("L'autore non può essere vuoto.");
        }
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
