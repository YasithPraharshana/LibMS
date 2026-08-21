import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private final String FILE_NAME = "books.txt"; // File path for persistent storage

    // Constructor: Automatically loads existing data from file upon initialization
    public LibraryManager() {
        loadBooksFromFile();
    }

    // --- FILE HANDLING METHODS ---

    // Saves all book records to the text file
    private void saveBooksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                // Format: ID,Title,Author,isAvailable
                writer.println(b.getId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.isAvailable());
            }
        } catch (IOException e) {
            System.out.println("[-] Error saving data to file: " + e.getMessage());
        }
    }

    // Reads and populates book records from the text file
    private void loadBooksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; // Skip loading if file does not exist yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Parse line by comma delimiter
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    boolean isAvailable = Boolean.parseBoolean(parts[3]);

                    books.add(new Book(id, title, author, isAvailable));
                }
            }
        } catch (IOException e) {
            System.out.println("[-] Error loading data from file: " + e.getMessage());
        }
    }

    // --- HELPER METHOD ---

    // Checks whether a book ID already exists in the collection
    private boolean isIdExists(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // --- LIBRARY OPERATIONS ---

    public void addBook() {
        System.out.print("Enter Book id >> ");
        int id = Integer.parseInt(scan.nextLine());

        if (isIdExists(id)) {
            System.out.println("[-] Error: Book ID " + id + " already exists!");
            return;
        }

        System.out.print("Enter Book Title >> ");
        String title = scan.nextLine();

        System.out.print("Enter Book Author >> ");
        String author = scan.nextLine();

        boolean isAvailable = true;

        books.add(new Book(id, title, author, isAvailable));
        saveBooksToFile(); // Save changes to file
        System.out.println("[+] Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("[-] No books available");
        } else {
            System.out.println("\n--- Library Book List ---");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    public void searchBook() {
        boolean found = false;
        System.out.print("Enter Book id >> ");
        int searchId = Integer.parseInt(scan.nextLine());

        for (Book b : books) {
            if (b.getId() == searchId) {
                System.out.println("\n[+] Book Found:");
                System.out.println(b);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("[-] Book with ID " + searchId + " not found!");
        }
    }

    public void issueBook() {
        System.out.print("Enter Book ID to issue >> ");
        int issueId = Integer.parseInt(scan.nextLine());
        boolean found = false;

        for (Book b : books) {
            if (b.getId() == issueId) {
                found = true;
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    saveBooksToFile(); // Auto-save status update
                    System.out.println("[+] Book '" + b.getTitle() + "' issued successfully!");
                } else {
                    System.out.println("[-] Sorry, this book is already issued!");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("[-] Book with ID " + issueId + " not found!");
        }
    }

    public void returnBook() {
        System.out.print("Enter Book ID to return >> ");
        int returnId = Integer.parseInt(scan.nextLine());
        boolean found = false;

        for (Book b : books) {
            if (b.getId() == returnId) {
                found = true;
                if (!b.isAvailable()) {
                    b.setAvailable(true);
                    saveBooksToFile(); // Auto-save status update
                    System.out.println("[+] Book '" + b.getTitle() + "' returned successfully!");
                } else {
                    System.out.println("[-] This book was not issued! It is already in the library.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("[-] Book with ID " + returnId + " not found!");
        }
    }
}