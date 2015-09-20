# Description
#### Problem Statement
[Combination Sum II](http://www.lintcode.com/en/problem/combination-sum-ii/#)

        Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
        
        Each number in C may only be used once in the combination.
        Example
        For example, given candidate set 10,1,6,7,2,1,5 and target 8,
        
        A solution set is: 
        
        [1,7]
        
        [1,2,5]
        
        [2,6]
        
        [1,1,6]
        
Note:
- All numbers (including target) will be positive integers.
- Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
- The solution set must not contain duplicate combinations.

#### Analysis
- Sort the array first
- Because there are duplicates in the array, so should be aware of the duplicates answers
- The same method as Combination Sum I
- But differ from Combination Sum I as 
  1. The same number in the array cannot be used twice
  2. Allow duplicates in the array
  
#### Solution
- Use the code 'while (i+1 < num.length && num[i] == num[i+1]) i++ ' to avoid duplicates

        public class Solution {
            /**
             * @param num: Given the candidate numbers
             * @param target: Given the target number
             * @return: All the combinations that sum to target
             */
            public List<List<Integer>> combinationSum2(int[] num, int target) {
                // write your code here
                ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
                ArrayList<Integer> temp = new ArrayList<Integer>();
                if (num.length == 0 || target == 0) return results;
                Arrays.sort(num);
                helper(num,target,results,temp,0);
                return results;
            }
            public void helper(int[] num, int target, ArrayList<List<Integer>> results, 
            ArrayList<Integer> temp, int index){
                if (target == 0) {
                    results.add(new ArrayList<Integer>(temp));
                    return;
                }
                if (target < 0) return;
                for (int i = index; i< num.length; i++) {
                    int current = num[i];
                    temp.add(current);
                    helper(num,target-current,results,temp,i+1);
                    temp.remove(temp.size()-1);
                    while (i+1 < num.length && num[i] == num[i+1]) i++;
                }
            }
        }

  Test Cases:
  1. num = [], return {};
  2. target = 0; return {};
  3. Regular case
