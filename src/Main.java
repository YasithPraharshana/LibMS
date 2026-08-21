import java.util.Scanner;
import java.io.Console;

public class Main {
    public static void main(String[] args) {

        String passwordIN = "";
        String PASSCheck = "";
        String PASSWORD = "Pass";
        String MenuIN;

        Scanner scan = new Scanner(System.in);
        Console console = System.console();

        do {
        if (console != null) {
            char[] passwordChars = console.readPassword("Enter Your Password: ");
            passwordIN = new String(passwordChars);
        } else {
            System.out.print("Enter Your Password: ");
            passwordIN = scan.nextLine();
        }

        if (!passwordIN.equals(PASSWORD)) {
            System.out.println("Your password is incorrect ");
            PASSCheck = "INCORRECT";
        } else {
            System.out.println("Login is Successful");
            PASSCheck = "CORRECT";
        }

        } while (!PASSCheck.equals("CORRECT"));


        System.out.println("\n---------------------------");
        System.out.println("----WELCOME TO LibMS-------");
        System.out.println("---------------------------\n");

        System.out.println("Help - h, Menu - m, Exit - quit");



        Menu menu = new Menu();
        boolean running = true;
        menu.displayMenu();

        while (running) {
            System.out.print("\nSelect Option >> ");
            MenuIN = scan.nextLine();
            running = menu.handleChoice(MenuIN);
        }
    }
}