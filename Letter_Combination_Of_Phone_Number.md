# Description
#### Problem Statement
[Letter Combinations of a Phone Number] (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

        Input:Digit string "23"
        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        
#### Analysis
This is a typical recursive (dfs+backtracking) problem

- First, build up a map to match up the number with the string

          String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
- Second, should have two index, one to identify the current position in the digital string,
the other to identify the current position in the specific string 

          For example: "23", index 0 would returns 2, then another index 2 would find the 2rd position in map[2]
          "abc"-> c

- Third, increase the second index (position in the string) when a matched result is found and 
added to the results ArrayList

- Important: 
          How to convert a character to int (Get wrong here!)
          Character.getNumericValue(c);

#### My Code
          public class Solution {
              public List<String> letterCombinations(String digits) {
                  String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
                  int[] nums = new int[digits.length()];
                  for (int i = 0; i< nums.length; i++){
                      nums[i] = Character.getNumericValue(digits.charAt(i));
                  }
                  StringBuffer temp = new StringBuffer();
                  List<String> results = new ArrayList<String>();
                  if (digits.length() == 0) return results;
                  helper(results,nums,temp,0,0,map);
                  return results;
              }
              public void helper(List<String> results, int[] nums, StringBuffer temp, int index, int current, String[] map){
                  if (temp.length() == nums.length) {
                      results.add(temp.toString());
                      current++;
                      return;
                  }
                  int num = nums[index];
                  String str = map[num];
                  for (int i = current;i<str.length();i++){
                      temp.append(str.charAt(i));
                      helper(results,nums,temp,index+1,current,map);
                      temp.deleteCharAt(temp.length()-1);
                  }
              }
          }
          
 
#### Time Complexity 
  
  Assuming the average number of letters on every number is m, and the length of digits string is n,
  then the complexity is O(m^n).
  
#### Test Case
1. "" -> {}
2. "2" -> {"a","b","c"}

#### Chanllenge 
Solve it without recursion
[Help!](http://www.lifeincode.net/programming/leetcode-letter-combinations-of-a-phone-number-java/)
