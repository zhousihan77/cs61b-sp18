public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque que = new ArrayDeque();
        for(Character chr : word.toCharArray()) {
            que.addLast(chr);
        }
        return que;
    }

    public boolean isPalindrome(String word) {
        int length = word.length();
        if(1 == length) {
            return true;
        }
        if(word.charAt(0) == word.charAt(length - 1)) {
            if(2 < length) {
                return isPalindrome(word.substring(1, length - 1));
            }else {
                return true;
            }
        }else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int length = word.length();
        if(1 == length) {
            return true;
        }
        if(cc.equalChars(word.charAt(0), word.charAt(length - 1))) {
            if(2 < length) {
                return isPalindrome(word.substring(1, length - 1), cc);
            }else {
                return true;
            }
        }else {
            return false;
        }
    }


    /**
    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();
        boolean res = palindrome.isPalindrome("cat");
    }*/

}
