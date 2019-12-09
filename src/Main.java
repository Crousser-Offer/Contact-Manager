import util.Input;
import util.Contact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {
static Input input = new Input();
        final static String folder = "data";
        final static String fileName = "groceries.txt";
        public static HashMap<String, Contact> contactList;

        // CRUD app
        public static void main(String[] args) {

                Path dataDirectory = Paths.get(folder);
                Path dataFile = Paths.get(folder, fileName);
                List<String> groceryList = Arrays.asList("coffee", "milk", "sugar");

                try{

                        if (Files.notExists(dataDirectory)) {
                                Files.createDirectories(dataDirectory);
                        }

                        if (!Files.exists(dataFile)) {
                                Files.createFile(dataFile);
                        }

                        Path filepath = Paths.get("data", "groceries.txt");

                        //
                        Files.write(filepath, groceryList);

                        Files.write(
                                filepath,
                                Arrays.asList("eggs"), // list with one item
                                StandardOpenOption.APPEND
                        );

                        List<String> newGroceryList = Files.readAllLines(filepath);

                        for (int i = 0; i < newGroceryList.size(); i += 1) {
                                System.out.println((i + 1) + ": " + newGroceryList.get(i));
                        }

                        List<String> tempList = new ArrayList<>();
                        for (String grocery : newGroceryList) {

                                // Update cream instead of milk
                                if (grocery.equals("milk")) {
                                        tempList.add("cream");
                                        continue;
                                }

                                // Delete eggs
                                if(grocery.equals("eggs")){
                                        continue;
                                }

                                // An item is being added
                                tempList.add(grocery);
                        }

                        // Writes the file with the final tempList
                        Files.write(filepath, tempList);

                }catch (IOException ex){
                        ex.printStackTrace();
                }


        }

}

//
//final static String dir = "contacts";
//final static String fileName = "contacts.txt";
//
//public static void main(String[] args) {
//
//        Path path =  Paths.get(dir, fileName);
//
//        if(!Files.exists(path)){
//        try {
//        Files.createDirectories(path);
////                Files.createFile(path);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        }
//
//        List<String> contacts = new ArrayList<>();
//        contacts.add("Fer");
//        contacts.add("Sophie");
//        contacts.add("Vivian");
//
//        try {
//        Files.write(path, contacts);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//
//
//        try {
//        List<String> lines = Files.readAllLines(path);
//
//        for(String line : lines){
//        line = 1+line;
//        System.out.println("line.toUpperCase() = " + line.toUpperCase());
//        }
//
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//
//
//        }
//
//        }
//
//        final static String dir = "contacts";
//        final static String fileName = "contacts.txt";
//
//        public static void main(String[] args) {
//            // write your code here
//            Path path = Paths.get(dir, fileName);
//
//            if(!Files.exists(path)){
//                try {
//                    Files.createDirectories(path);
//                Files.createFile(path);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                List<String> contacts = new ArrayList<>();
//               contacts.add("John");
//
//
//                try {
//                    Files.write(path, contacts);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
