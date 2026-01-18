import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("---- Java File Management System ----");
            System.out.println("1. Create File");
            System.out.println("2. Write to File");
            System.out.println("3. Read File");
            System.out.println("4. Delete File");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            File file = new File("sample.txt");

            switch (choice) {
                case 1:
                    if (file.createNewFile()) {
                        System.out.println("File created successfully.");
                    } else {
                        System.out.println("File already exists.");
                    }
                    break;

                case 2:
                    FileWriter writer = new FileWriter(file);
                    System.out.print("Enter content: ");
                    String content = sc.nextLine();
                    writer.write(content);
                    writer.close();
                    System.out.println("Data written to file.");
                    break;

                case 3:
                    Scanner reader = new Scanner(file);
                    System.out.println("File Content:");
                    while (reader.hasNextLine()) {
                        System.out.println(reader.nextLine());
                    }
                    reader.close();
                    break;

                case 4:
                    if (file.delete()) {
                        System.out.println("File deleted successfully.");
                    } else {
                        System.out.println("File not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
