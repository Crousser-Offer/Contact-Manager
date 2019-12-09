import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

final static String dir = "contacts";
final static String fileName = "contacts.txt";

public static void main(String[] args) {

        Path path =  Paths.get(dir, fileName);

        if(!Files.exists(path)){
        try {
        Files.createDirectories(path);
//                Files.createFile(path);
        } catch (IOException e) {
        e.printStackTrace();
        }
        }

        List<String> contacts = new ArrayList<>();
        contacts.add("Fer");
        contacts.add("Sophie");
        contacts.add("Vivian");

        try {
        Files.write(path, contacts);
        } catch (IOException e) {
        e.printStackTrace();
        }


        try {
        List<String> lines = Files.readAllLines(path);

        for(String line : lines){
        line = 1+line;
        System.out.println("line.toUpperCase() = " + line.toUpperCase());
        }

        } catch (IOException e) {
        e.printStackTrace();
        }


        }

        }
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
