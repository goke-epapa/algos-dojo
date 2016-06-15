/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Problem_345_reverse_vowels_of_a_string;

/**
 *
 * @author epapa
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("A"));
    }   

    public String reverseVowels(String s) {

        int pointer = s.length() - 1;
        String vowels = "aeiouAEIOU";
        
        if(s.length() == 1)
            return s;

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i) + "")) {
                for (int j = pointer; j > i; j--) {
                    if (vowels.contains(s.charAt(j) + "")) {
                        s = swap(s, i, j);
                        pointer = j - 1;
                        break;
                    }
                }
            }
        }
        return s;
    }

    private String swap(String s, int firstIndex, int secondIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == firstIndex) {
                sb.append(s.charAt(secondIndex));
                continue;
            }
            if (i == secondIndex) {
                sb.append(s.charAt(firstIndex));
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

