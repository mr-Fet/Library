package View;

import Controller.AuthorController;

import java.util.Scanner;

public class AuthorView {
    private AuthorController authorController = new AuthorController();

    public void showMenu(){

        System.out.println("Добро пожаловать в меню редактирования авторов: ");
        System.out.println("\n");

    }
    public void addAuthor() {

        System.out.println("Введите ID автора: ");
        Scanner scanner = new Scanner(System.in);
        int newAuthorId = scanner.nextInt();

        System.out.println("Введите имя автора: ");
        Scanner scanner1 = new Scanner(System.in);
        String newAuthorFirstName = scanner1.next();

        System.out.println("Введите фамилию автора: ");
        Scanner scanner2 = new Scanner(System.in);
        String newAuthorLastName = scanner2.next();

        authorController.addAuthor(newAuthorId, newAuthorFirstName, newAuthorLastName);

    }

    public void deleteAuthor(){
        System.out.println("Введите Id автора которого желаете удалить: ");
        Scanner scanner = new Scanner(System.in);
        int authorId = scanner.nextInt();

        authorController.deleteAuthor(authorId);
    }

    public void updateAuthor(){
        System.out.println("Введите Id автора, которого желаете изменить: ");
        Scanner scanner = new Scanner(System.in);
        int authorId = scanner.nextInt();

        System.out.println("Введите новое имя клиента: ");
        Scanner scanner1 = new Scanner(System.in);
        String updateAuthorFirstName = scanner1.next();

        System.out.println("Введите новую фамилию клиента: ");
        Scanner scanner2 = new Scanner(System.in);
        String updateAuthorLastName = scanner2.next();

        authorController.updateAuthor(authorId, updateAuthorFirstName, updateAuthorLastName);
    }

}
