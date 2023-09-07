import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");

        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {

        assertFalse(palindrome.isPalindrome("car"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("cindy"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("magic"));

        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("alake", obo));
        assertTrue(palindrome.isPalindrome("benda", obo));
        assertTrue(palindrome.isPalindrome("detrude", obo));
        assertTrue(palindrome.isPalindrome("smelt", obo));

        OffByN nbo = new OffByN(5);
        assertTrue(palindrome.isPalindrome("bidding", nbo));
        assertTrue(palindrome.isPalindrome("linking", nbo));
        assertTrue(palindrome.isPalindrome("spun", nbo));


    }

}


