package View;

import Controller.ClientController;
import Model.Client;

import java.util.Scanner;

public class ClientView {

    private ClientController clientController = new ClientController();
    public void showMenu(){

        System.out.println("Добро пожаловать в меню редактирования клиента: ");
        System.out.println("\n");

    }
     public void addClient(){

         System.out.println("Введите ID клиента: ");
         Scanner scanner = new Scanner(System.in);
         int newId = scanner.nextInt();
         //System.out.println("\n");

         System.out.println("Введите имя клиента: ");
         Scanner scanner1 = new Scanner(System.in);
         String newFirstName = scanner1.next();
         //System.out.println("\n");

         System.out.println("Введите фамилию клиента: ");
         Scanner scanner2 = new Scanner(System.in);
         String newLastName = scanner2.next();
         //System.out.println("\n");

         clientController.registration(newId,newFirstName,newLastName);

    //return new Client(newId,newFirstName,newLastName);
    }

}
