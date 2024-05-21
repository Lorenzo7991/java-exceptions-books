package org.exercise.library.controller;
//Book class import
import org.exercise.library.model.Book;
//Import utility
import java.io.*;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        //Initializing scanner obj
        Scanner scanner = new Scanner(System.in);

        //First interaction with the user
        System.out.print("Quanti libri vuoi inserire? ");
        int nBooks = Integer.parseInt(scanner.nextLine());

        //Initializing Book obj
        Book[] books = new Book[nBooks];

        //Iteration fo fill book fields
        for (int i = 0; i < nBooks; i++){
            try {
                System.out.println("Titolo: ");
                String title = scanner.nextLine();

                System.out.print("Numero di pagine: ");
                int pages = Integer.parseInt(scanner.nextLine());

                System.out.print("Autore: ");
                String author = scanner.nextLine();

                System.out.print("Editore: ");
                String publisher = scanner.nextLine();

                books[i] = new Book(title, pages, author, publisher);
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
                i--;
            }
        }
        scanner.close();

        //Writing data to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura dei dati su file: " + e.getMessage());
        }

        //Reading data from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
            Book[] readBooks = (Book[]) ois.readObject();

            System.out.println("Dati dei libri letti dal file:");
            for (Book book : readBooks) {
                System.out.println(book);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante la lettura dei dati dal file: " + e.getMessage());
        }
    }
}
