/*
 * Author: Lucas Noritomi-Hartwig
 * Date created: February 20, 2020
 * Date last edited: February 21, 2020
 * Program title: Palindrome2.java
 * This program directs the user to enter a sentence then counts the
 * palindromes and prints the count and the palindromes to the user.
 */
package palindrome2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Palindrome2 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<String> palindromes = new ArrayList();

    public static void main(String[] args) {
        // Prompting user for input string
        String input = JOptionPane.showInputDialog("Words that are the same "
                + "forwards and backwards are called palindromes.\nThis program"
                + " determines if a words are palindrome.\n\nEnter a sentence(do"
                + " not include a punctuation mark):") + " ";
        // Extra + " " to allow checking of last word in sentence

        // Separating words
        String word = "";
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character != ' ') {
                word += character;
            } else {
                // Reversing input string
                String reversed = "";
                for (int j = word.length() - 1; j >= 0; j--) {
                    reversed += word.charAt(j);
                }

                // Ignoring lower and uppercase
                String wordLower = word.toLowerCase();
                String reversedLower = reversed.toLowerCase();

                // Adding any palindromes to ArrayList
                if (wordLower.equals(reversedLower)) {
                    palindromes.add(word);
                }

                // Resetting word String
                word = "";
            }
        }

        // Outputting number of palindromes in sentence
        JOptionPane.showMessageDialog(null, "There are " + palindromes.size()
                + " palindromes in the sentence");

        // Outputting palindromes if any
        if (palindromes.size() > 0) {
            // Creating output String to comply with given formatting
            String output = "";
            for (int i = 0; i < palindromes.size(); i++) {
                output += palindromes.get(i) + ", ";
            }
            output = output.substring(0, output.length() - 2);
            JOptionPane.showMessageDialog(null, "The palindromes are:\n"
                    + output);
        }
    }

}
