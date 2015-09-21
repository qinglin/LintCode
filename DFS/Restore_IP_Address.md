#Description
This is a Leetcode Problem
#### Problem Statement

[Restore IP Address] (https://leetcode.com/problems/restore-ip-addresses/)

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:

        Given "25525511135",
        
        return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

# Analysis
- First, this is a typical recursive (dsf + backtracking) problem
- Second, be clarify that if a num is in the range of [0,255], it can be added to the ip arraylist
- Third, use an ArrayList to save the nums for the ip address, and parse it to a string when found a correct answer
- Fourth, be aware of the existence of ‘00’，‘010’，‘000’       

        if (i>1 && sub.charAt(0) == '0') continue;
Use the code to solve the problem

# My Code
        public class Solution {
        public List<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<String>();
        if (s.length() == 0) return results;
        
        ArrayList<String> temp = new ArrayList<String>();
        helper(0,results,temp,s);
        return results;
        }
        
        public void helper(int index, ArrayList<String> results, ArrayList<String> temp, String s){
        if (index == s.length() && temp.size() == 4){
            StringBuffer sb = new StringBuffer("");
            sb.append(temp.get(0)+".");
            sb.append(temp.get(1)+".");
            sb.append(temp.get(2)+".");
            sb.append(temp.get(3));
            results.add(sb.toString());
            return;
        }
        if (index == s.length() || temp.size() == 4) return;
        
        for (int i = 1; i<= 3 && index + i <= s.length();i++){
            String sub = s.substring(index,index+i);
            if (i>1 && sub.charAt(0) == '0') continue;
            int num = Integer.parseInt(sub);
            if (num >= 0 && num <= 255){
                temp.add(sub);
                helper(index+i,results,temp,s);
                temp.remove(temp.size()-1);
            }
        }
        }
        }

#### Time Complexity
If the average length of a string in the ip address (xxx.xx.xxx.x) is m, and the length of the given string is n. 
The time complexity is (m^n)

#### Test Case
1. ""
2. "0000"
3. "255255255255"
