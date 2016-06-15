/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Problem_345_reverse_vowels_of_a_string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author epapa
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input"));
        String line = bufferedReader.readLine();
        System.out.println(new Solution().reverseVowels(line));
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
        char[] sChars = s.toCharArray();
        sChars[firstIndex] = s.charAt(secondIndex);
        sChars[secondIndex] = s.charAt(firstIndex);
        return new String(sChars);
    }
}

