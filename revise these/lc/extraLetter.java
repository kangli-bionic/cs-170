Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added


public class Solution {
    public char findTheDifference(String s, String t) {
       char[] ascii = new char[128];
       for (char ch: s.toCharArray())
        ascii[ch]++;
       for (char ch: t.toCharArray())
        ascii[ch]--;
       int i = 0;
       while (i < ascii.length){
        if (ascii[i] != 0)
            break;
        else
            i++;
       }
       return (char)i;
       
       /*
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            res ^= s.charAt(i);
            
        for (int i = 0; i < t.length(); i++)
            res ^= t.charAt(i);
        return (char)res;
        */
    }
}