import java.util.Scanner;

public class Menu {
    private LibraryManager libraryManager = new LibraryManager();
    // Main Menu එක Screen එකේ පෙන්වීමට
    public void displayMenu() {
        System.out.println("\n==================================");
        System.out.println("          LIBRARY MENU            ");
        System.out.println("==================================");
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("m. Go To Menu");
        System.out.println("h. Help");
        System.out.println("quit. Exit");
        System.out.println("----------------------------------");
        System.out.print("");
    }

    // User ගේ Input එක අනුව ක්‍රියාත්මක වන Switch Case එක
    public boolean handleChoice(String choice) {
        switch (choice.toLowerCase().trim()) {
            case "1":
                System.out.println("[+] Add New Book Section Selected.");
                // මෙතැනට Add Book function එක දාන්න
                libraryManager.addBook();
                break;

            case "2":
                System.out.println("[+] View All Books Section Selected.");
                // මෙතැනට Display Books function එක දාන්න
                libraryManager.viewBooks();
                break;

            case "3":
                System.out.println("[+] Search Book Section Selected.");
                libraryManager.searchBook();
                break;

            case "4":
                System.out.println("[+] Issue Book Section Selected.");
                libraryManager.issueBook();
                break;

            case "5":
                System.out.println("[+] Return Book Section Selected.");
                libraryManager.returnBook();
                break;

            case "m":
                displayMenu();
                break;

            case "h":
                showHelp();
                break;

            case "quit":
                System.out.println("Exiting Library Management System. Goodbye!");
                return false; // loop එක නතර කිරීමට false return කරයි

            default:
                System.out.println("Invalid choice! Please try again.");
                break;
        }
        return true; // දිගටම Menu එක පෙන්වීමට true return කරයි
    }

    // Help option එක සඳහා කුඩා method එකක්
    private void showHelp() {
        System.out.println("\n--- HELP GUIDE ---");
        System.out.println("- Enter numbers (1-5) to select options.");
        System.out.println("- Type 'h' anytime to view this help.");
        System.out.println("- Type 'quit' to exit the application.");
    }
}