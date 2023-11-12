package homework.fileSystem;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    fileSearch();
                    break;
                case "2":
                    contentSearch();
                    break;
                case "3":
                    findLines();
                    break;
                case "4":
                    printSizeOfPackage();
                    break;
                case "5":
                    createFileWithContent();
                    break;
                case "0":
                    run = false;
                    break;
                default:
                    System.out.println("invalid command!");
            }
        }
    }

    private static void printCommands() {
        System.out.println("Press 1 to search the file");
        System.out.println("Press 2 to search file with keyword");
        System.out.println("Press 3 to search keyword line in a file");
        System.out.println("Press 4 to print size of package");
        System.out.println("Press 5 to create a file with context");
        System.out.println("Press 0 to exit");
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("\nPlease enter folder/package path");
        String folderPath = scanner.nextLine();
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            System.out.println("Please enter file name with extension (for example, \t .txt \t .java \t .docx)");
            String fileName = scanner.nextLine();
            File file = new File(folderPath, fileName);
            if (file.exists() && !fileName.isEmpty()) {
                System.out.println("The file exists!");
            } else {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Provided text is a wrong path");
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։

    static void contentSearch() {
        System.out.println("\nPlease enter folder/package path");
        String folderPath = scanner.nextLine();

        File folder = new File(folderPath);
        if (!folder.exists() || folder.isFile()) {
            System.out.println("Invalid folder path");
            return;
        }

        System.out.println("Please enter the keyword");
        String keyword = scanner.nextLine();

        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Keyword shouldn't be empty!");
            return;
        }

        File[] files = folder.listFiles();
        for (File fileFromList : files) {
            if (fileFromList.isFile() && fileFromList.getName().endsWith(".txt")) {
                try (BufferedReader br = new BufferedReader(new FileReader(fileFromList))) {
                    String line;
                    int count = 0; // count of files that contains provided keyword
                    while ((line = br.readLine()) != null) {
                        if (line.toLowerCase().contains(keyword.toLowerCase())) {
                            count++;
                            System.out.println(fileFromList.getName());
                            break;
                        }
                    }
                    if (count <= 0) {
                        System.out.println("No matches!");
                        break;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found" + e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        System.out.println("\nPlease enter searchable txt file path");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Invalid file path");
            return;
        }

        System.out.println("Please enter the keyword");
        String keyword = scanner.nextLine();

        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Keyword shouldn't be empty!");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println("Match found in line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.println("\nPlease enter folder/package path");
        String folderPath = scanner.nextLine();

        File folder = new File(folderPath);
        if (!folder.exists() || folder.isFile()) {
            System.out.println("Invalid folder path");
            return;
        }

        long size = calculateFolderSize(folder);
        System.out.println("Size of the folder: " + size / 1024 + " KB");
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("\nPlease enter folder/package path");
        String folderPath = scanner.nextLine();

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path");
            return;
        }

        System.out.println("Please enter the file name. The file you want to create will be in '.txt' format.");
        String fileName = scanner.nextLine() + ".txt";

        if (!fileName.matches("^[a-zA-Z0-9_\\-\\.]+$")) {
            System.out.println("Invalid file name. Use only letters, numbers, underscores, hyphens, and dots.");
            return;
        }

        System.out.println("Enter file content:");
        String content = scanner.nextLine();

        File newFile = new File(folder, fileName);

        if (newFile.exists()) {
            System.out.println("File already exists. Choose a different name.");
            return;
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter(newFile))) {
            br.write(content);
            System.out.println("File created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    private static long calculateFolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else if (file.isDirectory()) {
                    size += calculateFolderSize(file);
                }
            }
        }
        return size;
    }
}
