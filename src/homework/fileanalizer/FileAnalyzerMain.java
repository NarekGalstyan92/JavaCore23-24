package homework.fileanalizer;

import java.io.IOException;
import java.util.*;

public class FileAnalyzerMain {

    private static Scanner scanner = new Scanner(System.in);
    private static FileAnalyzer analyzer = new FileAnalyzer();
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    private final static String pathStr = "/Users/narekgalstyan/Documents/IdeaProjects/JavaCore/src/homework/fileanalizer/note1.txt";

    public static void main(String[] args) throws IOException {
        boolean run = true;
        while (run) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    wordMap();
                    break;
                case "2":
                    totalWordCount();
                    break;
                case "3":
                    uniqueWordCount();
                    break;
                case "4":
                    topFrequentWords();
                    break;
                case "5":
                    countWordOccurrences();
                    break;
                case "0":
                    run = false;
                    break;
                default:
                    System.out.println("invalid command!");
            }
        }
    }

    private static void topFrequentWords() {
        try {
            System.out.println("Please enter the number of top frequent words");
            String topNumberStr = scanner.nextLine();
            if (topNumberStr == null || topNumberStr.isEmpty()) {
                System.out.println("The number of top frequent words shouldn't be empty!");
                return;
            }
            int topNumber = Integer.parseInt(topNumberStr);

            Map<String, Integer> stringIntegerMap = analyzer.topFrequentWords(pathStr, topNumber);

            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(stringIntegerMap.entrySet()); // Convert the entry set to a list for easier sorting

            entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // Sorting in descending order based on values

            Map<String, Integer> sortedMap = new LinkedHashMap<>(); // Create a new LinkedHashMap to maintain the order

            // Adding the top n entries to the sortedMap
            // this code seems to be part of a larger task where you are iterating over a list of map entries (entryList),
            // copying them into a new map (sortedMap), and stopping the process after a certain number of entries (topNumber) have been processed.
            int count = 0;
            for (Map.Entry<String, Integer> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
                count++;
                if (count == topNumber) {
                    break;
                }
            }
            System.out.println(sortedMap);
        } catch (IOException e) {
            e.getMessage();
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse number!");
            e.getMessage();
        }
    }

    private static void uniqueWordCount() {
        try {
            int countOfUniqueWords = analyzer.uniqueWordCount(pathStr);
            if (countOfUniqueWords > 0) {
                System.out.println("Count of unique words is " + countOfUniqueWords);
            } else {
                System.out.println("There is no unique word in the file");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    // This method is not checking if the word contains any punctuations
    // or if the word is a "return to new line" itself.
    private static void totalWordCount() {
        try {
            int countOfWords = analyzer.totalWordCount(pathStr);
            if (countOfWords > 0) {
                System.out.println("Count of the words in the file is " + ANSI_YELLOW + countOfWords + ANSI_RESET);
            } else {
                System.out.println("It seems the file is empty!");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    // This method is not checking if the word contains any punctuations
    // or if the word is a "return to new line" itself.
    private static void wordMap() {
        try {
            Map<String, Integer> stringIntegerMap = analyzer.wordMap(pathStr);
            if (stringIntegerMap != null) {
                System.out.println("Below is the list of words in the file with count for each word\n");
                for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerMap.entrySet()) {
                    System.out.println(stringIntegerEntry.getKey() + ": " + ANSI_YELLOW + stringIntegerEntry.getValue() + ANSI_RESET);
                }
            } else {
                System.out.println("Failed to read from file");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void printCommands() {
        System.out.println("Press 1 to see count of each word in file");
        System.out.println("Press 2 to see total word count in file");
        System.out.println("Press 3 to see unique word count in file");
        System.out.println("Press 4 to see the most repeated word in file");
        System.out.println("Press 5 to see the count of searchable word in file");
        System.out.println("Press 0 to exit");
    }

    public static void countWordOccurrences() {
        System.out.println("Please enter the keyword");
        String keyword = scanner.nextLine().toLowerCase();

        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Keyword shouldn't be empty!");
            return;
        }
        int count;
        try {
            count = analyzer.countWordOccurrences(pathStr, keyword);
            System.out.println("Count of the \'" + keyword + "\' is " + ANSI_GREEN + count + ANSI_RESET);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
