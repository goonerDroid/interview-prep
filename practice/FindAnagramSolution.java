package practice;

import java.util.HashSet;

/**
 * LC - <a href="https://leetcode.com/problems/valid-anagram/description/">...</a>
 */
@SuppressWarnings("DuplicateExpressions")
public class FindAnagramSolution {

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] characterTable = new int[26];
    for (int i = 0; i < s.length(); i++) {
      characterTable[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < t.length(); i++) {
      characterTable[t.charAt(i) - 'a']--;
      if (characterTable[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "aacc";
    //Sort the first string which gives me  - {a,a,a,g,m,n,r};
    String t = "ccac";
    //Sort of second string will be  - {a,a,a,g,m,n,r};
    //Compare or check arrays.equal for both these strings

    boolean isAnagram = isAnagram(s, t);
    System.out.print("Result -  " + isAnagram);
  }

}
