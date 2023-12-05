package homework.fileanalizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileAnalyzer {

    // Pseudocode:
    // Read the file, create map of word-count, read the line, split to (regex: "\\s+"), add into the map and return.
    public Map<String, Integer> wordMap(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            Map<String, Integer> stringIntegerMap = new TreeMap<>();
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // \\s+ in the split method means to split the string wherever there is one or more whitespace characters.
                for (int i = 0; i < words.length; i++) {
                    stringIntegerMap.put(words[i], i + 1);
                }
            }
            return stringIntegerMap;
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    // Pseudocode:
    // Open the file, store the words in LinkedList and return the list size.
    public int totalWordCount(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            List<String> listOfWords = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                listOfWords.addAll(Arrays.asList(words));
            }
            return listOfWords.size();
        } catch (IOException e) {
            e.getMessage();
        }
        return 0;
    }

    // Return count of unique words in file
    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> wordMap = wordMap(path);  // Call wordMap method to get the map of word counts
        int count = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : wordMap.entrySet()) {
            if (stringIntegerEntry.getValue() == 1) {
                count ++;
            }
        }
        return count;
    }

    // Return the top most repeated words
    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {

        Map<String, Integer> frequentWordsMap = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                for (String word : words) {
                    frequentWordsMap.put(word, frequentWordsMap.getOrDefault(word, 0) + 1);
                }
            }
            return frequentWordsMap;
        } catch (IOException e) {
            System.out.println("\u001B[35m" + "Something went wrong while reading the file" + "\u001B[0m");
            e.getMessage();
        }
        return null;
    }

    // Return the count of searchable word in file
    public int countWordOccurrences(String path, String word) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String w : words) {
                    if (w.equals(word.toLowerCase())) {   // Use equals() to check for whole word match
                        count++;
                    }
                }
            }
            return count;
        } catch (IOException e) {
            System.out.println("\u001B[35m" + "Something went wrong while reading the file" + "\u001B[0m");
            e.getMessage();
        }
        return 0;
    }
}
