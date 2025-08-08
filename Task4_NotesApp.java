import java.util.*;
import java.io.*;
public class Task4_NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";
        boolean running = true;

        while (running) {
            System.out.println("\n1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Write note
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    try (FileWriter fw = new FileWriter(fileName, true)) { // true → append
                        fw.write(note + "\n");
                        System.out.println("Note saved.");
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                    break;

                case 2: // Read notes
                    System.out.println("\nYour Notes:");
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println("- " + line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("No notes found.");
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                    break;

                case 3: // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
