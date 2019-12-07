package View;

import Controller.BooksController;
import Model.Books;

import java.util.List;
import java.util.Scanner;

public class BooksView {
    private BooksController booksController = new BooksController();

    public void showMenu(){

        System.out.println("Добро пожаловать в меню редактирования книги: ");
        System.out.println("\n");

    }
    public void addBook(){

        System.out.println("Введите ID книги: ");
        Scanner scanner = new Scanner(System.in);
        int newBookId = scanner.nextInt();

        System.out.println("Введите название книги: ");
        Scanner scanner1 = new Scanner(System.in);
        String newBookName = scanner1.next();

        System.out.println("Введите ID автора книги: ");
        Scanner scanner2 = new Scanner(System.in);
        int newAuthorId = scanner.nextInt();

        System.out.println("Введите категорию книги: ");
        Scanner scanner3 = new Scanner(System.in);
        String newCategory = scanner2.next();


        booksController.addBook(newBookId,newBookName,newAuthorId,newCategory);

    }

    public void deleteBook(){
        System.out.println("Введите Id книги которую желаете удалить: ");

        Scanner scanner = new Scanner(System.in);
        int bookId = scanner.nextInt();

        booksController.deleteBook(bookId);
    }

    public void updateBook(){
        System.out.println("Введите Id книги которую желаете изменить: ");
        Scanner scanner = new Scanner(System.in);
        int bookId = scanner.nextInt();

        System.out.println("Введите новое название книги: ");
        Scanner scanner1 = new Scanner(System.in);
        String updateBookName = scanner1.next();

        System.out.println("Введите новое ID автора книги: ");
        Scanner scanner2 = new Scanner(System.in);
        int updateAuthorId = scanner2.nextInt();

        System.out.println("Введите новую категорию книги: ");
        Scanner scanner4 = new Scanner(System.in);
        String updateCathegory = scanner1.next();


        booksController.updateBook(bookId, updateBookName, updateAuthorId, updateCathegory);
    }

    public void returnAllBooks(){
        List<Books> bookList = booksController.returnAllBooks();
        bookList.stream().map((x)->x+"\n").forEach(System.out::println);
    }
    public void searchTheBooksById() {
        System.out.println("Введите ID книги: ");
        Scanner scanner = new Scanner(System.in);
        int booksId = scanner.nextInt();
        System.out.println(booksController.searchBookById(booksId));
    }
    public void searchTheBooksByAuthor() {
        System.out.println("Введите автора книги: ");
        Scanner scanner = new Scanner(System.in);
        String authorLastName = scanner.next();
        System.out.println(booksController.searchBookByAuthor(authorLastName));
    }
    public void searchTheBooksByName() {
        System.out.println("Введите название книги: ");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.next();
        System.out.println(booksController.searchBookByName(bookName));
    }

}
