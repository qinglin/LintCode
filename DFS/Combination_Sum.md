#Description
#### Problem Statement
[Combination Sum] (http://www.lintcode.com/en/problem/combination-sum/)

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

        For example, given candidate set 2,3,6,7 and target 7, 
        A solution set is: 
        [7] 
        [2, 2, 3] 

Note
- All numbers (including target) will be positive integers.
- Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
- The solution set must not contain duplicate combinations.

#### Analysis
DFS + Backtracking
Notice: 
- For each recursion, the for loop should start from the current index
- Sort the array before DFS

#### My Code
        public class Solution {
            /**
             * @param candidates: A list of integers
             * @param target:An integer
             * @return: A list of lists of integers
             */
            public List<List<Integer>> combinationSum(int[] candidates, int target) {
                // write your code here
                ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
                ArrayList<Integer> temp = new ArrayList<Integer>();
                Arrays.sort(candidates);
                if (candidates.length == 0 || target == 0) return results;
                helper(results,temp,target,candidates,0);
                return results;
            }
            public void helper(ArrayList<List<Integer>> results, ArrayList<Integer> temp, int target,int[] candidates, int index) {
                if (target == 0) {
                    results.add(new ArrayList<Integer>(temp));
                    return;
                }
                if (target < 0) return;
                for (int i = index; i< candidates.length; i++) {
                    int current = candidates[i];
                    temp.add(current);
                    helper(results,temp,target-current,candidates,i);
                    temp.remove(temp.size()-1);
                }
            }
        }
