package org.exercise.library.controller;

import org.exercise.library.model.Book;
import org.exercise.library.model.InvalidBookDataException;

import java.io.*;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        //Initializing scanner obj
        Scanner scanner = new Scanner(System.in);
        //Utility variables
        int nBooks = 0;
        boolean validInput = false;
        // Validation number of books to be inserted
        while (!validInput) {
            try {
                System.out.print("Quanti libri vuoi inserire? ");
                String input = scanner.nextLine();
                nBooks = Integer.parseInt(input);
                if (nBooks <= 0) {
                    throw new IllegalArgumentException("Il numero di libri deve essere maggiore di zero.");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: Devi inserire un valore che sia un numero, intero e positivo.");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        //Initializing book obj
        Book[] books = new Book[nBooks];
        // Inserting data for each book
        for (int i = 0; i < nBooks; i++) {
            try {
                System.out.println("Inserisci i dati per il libro " + (i + 1));

                System.out.print("Titolo: ");
                String title = scanner.nextLine();

                System.out.print("Numero di pagine: ");
                String pagesInput = scanner.nextLine();
                int pages = Integer.parseInt(pagesInput);

                System.out.print("Autore: ");
                String author = scanner.nextLine();

                System.out.print("Editore: ");
                String publisher = scanner.nextLine();

                books[i] = new Book(title, pages, author, publisher);
                //Exception management
            } catch (NumberFormatException e) {
                System.out.println("Errore: Il numero di pagine deve essere un numero intero positivo.");
                i--;
                //Custom exception management
            } catch (InvalidBookDataException e) {
                System.out.println("Errore: " + e.getMessage());
                i--; }
        }
        scanner.close();
        // Writing data to text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                writer.write("Titolo: " + book.getTitle() + "\n");
                writer.write("Pagine: " + book.getPages() + "\n");
                writer.write("Autore: " + book.getAuthor() + "\n");
                writer.write("Editore: " + book.getPublisher() + "\n\n");
            }
            System.out.println("Dati scritti su file 'books.txt'");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura dei dati su file: " + e.getMessage());
        }
        //Reading data from file
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            System.out.println("\nDati dei libri letti dal file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Errore durante la lettura dei dati dal file: " + e.getMessage());
        }
    }
}
