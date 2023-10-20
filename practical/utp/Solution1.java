package practical.utp;

public class Solution1 {
    public static <T> boolean isPalindrome(T data) {
        String str = data.toString();
        String invertedStr = new StringBuilder(str).reverse().toString();

        return str.equals(invertedStr);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
    }
}
