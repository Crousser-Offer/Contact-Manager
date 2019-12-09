 package util;

        import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String getString(String msg){
        System.out.println(msg);
        return scanner.nextLine().trim().toLowerCase();
    }

    public String getString(){
        return getString("Write something: ");
    }

    public boolean yesNo(){
        String input = getString("Type yes/no: ");
        return input.equals("yes") || input.equals("y");
    }

    public int getInt(int min, int max){
        int num = getInt();

        if(num < min || num > max){
            System.out.println("Error: outside of the boundaries.");
            return getInt(min, max);
        }

        return num;
    }

    public int getInt(){
        int number;
        try{
            number = Integer.valueOf(getString("Give me a number: "));
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Make sure it's a number");
            e.printStackTrace();
            return getInt();
        }
        return number;
    }

    public double getDouble(){
        double number;
        try {
            number = Double.valueOf(getString("Give me a number: "));
        } catch (NumberFormatException e){
            System.out.println("That's not a number. ಠ_ಠ");
            e.printStackTrace();
            return getDouble();
        }
        return number;
    }

    public double getDouble(double min, double max){
        double num = getDouble();

        if(num < min || num > max){
            System.out.println("Error: outside of the boundaries.");
            return getDouble(min, max);
        }

        return num;
    }



}
