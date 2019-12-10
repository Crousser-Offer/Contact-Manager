import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Input input = new Input();
    static Scanner scan = new Scanner(System.in);
    final static String directory = "src";
    final static String fileName = "contacts.txt";


    public static void main(String[] args) {

        System.out.println("Welcome to the Contacts Manager!");
        boolean menu = true;
        do {
            showMenu();

            int selection = input.getInt(1, 5);

            switch (selection) {
//                show contacts
                case 1:
                    showContacts();
                    System.out.println("\n");
                    break;
                case 2:
//                    add contact
                    System.out.println("Please enter first name and  last name of your contact");
                    String userInput = scan.nextLine();
                    System.out.println("What is your contacts phone number?");
                    String userInput1 = scan.nextLine();
                    String finalContact = userInput + " | " + userInput1;
                    try {
                        Path filepath = Paths.get("src", "contacts.txt");
                        Files.write(
                                filepath,
                                Arrays.asList(finalContact),
                                StandardOpenOption.APPEND
                        );
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    System.out.printf("%s was successfully added!", finalContact);

                    break;
                case 3:
//                    search contact
                    System.out.println("Please enter the contact you would like to search for");
                    String search = scan.nextLine();
                    try {
                        Path filepath = Paths.get("src", "contacts.txt");
                        List<String> newContactList = Files.readAllLines(filepath);
                        for (String contact : newContactList) {
                            if (contact.toLowerCase().contains(search.toLowerCase())) {
                                System.out.println(contact);
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 4:
//                    delete contact
                    System.out.println("Please Enter the contact's name that you would like to delete.");
                    String delete = scan.nextLine();
                    try {
                        Path filepath = Paths.get("src", "contacts.txt");
                        List<String> tempList = new ArrayList<>();
                        List<String> newContactList = Files.readAllLines(filepath);
                        for (String contact : newContactList) {
                            if (contact.toLowerCase().contains(delete.toLowerCase())) {
                                System.out.printf("Are you sure you would like to delete %s, \n Please type yes or no.\n", contact);
                                Boolean confirm = input.yesNo();
                                if (confirm) {
                                    System.out.printf("Your contact %s was deleted", contact);
                                    continue;
                                }
                            } else {
                                tempList.add(contact);
                            }
                            Files.write(filepath, tempList);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 5:
//                    exit
                    System.out.println("Goodbye! Thank you for using Contacts Manager");
                    menu = false;
                    break;
            }
        } while (menu);
    }

    public static void showMenu(){
        System.out.println("Main Menu\n" +
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

    }
    public static void showContacts() {
        try {
            Path filepath = Paths.get("src", "contacts.txt");

            List<String> getNamePhoneNumber = Files.readAllLines(filepath);
            System.out.println("Here are your contacts:\n");
            System.out.println("Full Name | Phone number\n" +
                    "--------------------------");
            for (int i = 0; i < getNamePhoneNumber.size(); i += 1) {
                System.out.println(getNamePhoneNumber.get(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
