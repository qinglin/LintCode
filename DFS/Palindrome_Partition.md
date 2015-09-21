#Descrition
#### Problem Statement
[Palindrome Partition](http://www.lintcode.com/en/problem/palindrome-partitioning/#)

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example
given s = "aab",
Return

          [
            ["aa","b"],
            ["a","a","b"]
          ]
#### Analysis
1. Need a function to determine if a string is a palindrome
2. Know the usage of StringBuffer
3. Know when to add a temp arraylist to the results

####Solution
        public class Solution {
            /**
             * @param s: A string
             * @return: A list of lists of string
             */
            public List<List<String>> partition(String s) {
                // write your code here
                ArrayList<List<String>> results = new ArrayList<List<String>>();
                ArrayList<String> temp = new ArrayList<String>();
                if (s.length() == 0) return results;
                String sub = new String();
                helper(results,temp,s,sub);
                return results;
            }
            public void helper(ArrayList<List<String>> results, ArrayList<String> temp, String s, String sub) {
                
                if (s.length() == 0) {
                    results.add(new ArrayList<String>(temp));
                    return;
                }
                
                for (int i = 0; i< s.length(); i++) {
                    sub = s.substring(0,i+1);
                    if (isPalindrome(sub)){
                        temp.add(sub);
                    }
                    else continue;
                    helper(results,temp,s.substring(i+1),sub);
                    temp.remove(temp.size()-1);
                }
            }
            public boolean isPalindrome(String str){
                StringBuffer sb = new StringBuffer(str);
                String str2 = sb.reverse().toString();
                if (str.equals(str2)) return true;
                return false;
            }
        }

#### Time Complexity
?
