package Util;

import java.util.*;

public class Utility {

    // Generate a random email address
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        Random random = new Random();
        String username = generateRandomString(8); // You can adjust the length of the username
        String domain = domains[random.nextInt(domains.length)];
        return username + "@" + domain;
    }

    // Generate a random string of given length
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static int generateRandomNumberBasedOnMaxNumberList(int maxNumber) {
        int randomNumber;
        Random random = new Random();

        // generate a random number based on the last number in the category list
        randomNumber = random.nextInt(maxNumber - 1 + 1) + 1;
        if (randomNumber == maxNumber) {
            randomNumber--;
        }
        return randomNumber;
    }


    public static List<Integer> generateRandomNumbersFromAList(int maxNumber, int numberOfRandomNumbers) {

        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        // Use a Set to store unique random numbers
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Generate the specified number of unique random numbers
        for (int i = 0; i < numberOfRandomNumbers; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(maxNumber) + 1; // Generate a random number within the range [1, maxNumber]
            } while (!uniqueNumbers.add(randomNumber)); // Keep generating until a unique number is generated

            randomNumbers.add(randomNumber); // Add the unique random number to the list
        }

        return randomNumbers;
    }
}