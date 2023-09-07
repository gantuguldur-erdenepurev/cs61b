import static org.junit.Assert.*;
import java.util.Arrays;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> L = new LinkedListDeque<>();
        int index = word.length() - 1;
        while (index >= 0) {
            L.addFirst(word.charAt(index));
            index--;
        }
        return L;
    }

    public boolean isPalindrome(String word) {
        String reversed = "";
        char letter;
        for (int i = 0; i < word.length(); i++){
            letter = word.charAt(i);
            reversed = letter + reversed;
        }
        Deque forward = wordToDeque(word);
        Deque backward = wordToDeque(reversed);

        while (forward.size() != 0) {
            if (forward.removeFirst() != backward.removeFirst()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque L = wordToDeque(word);

        while (L.size() != 0) {
            if (L.size() == 1) {
                return true;
            }
            if (cc.equalChars((char) L.removeFirst(), (char) L.removeLast()) == false) {
                return false;
            }
        }
        return true;
    }

}


