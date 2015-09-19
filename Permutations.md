# Definition
#### Problem : 

[Permutations] (http://www.lintcode.com/en/problem/permutations/)

Given a list of numbers, return all possible permutations.

Example

        For nums = [1,2,3], the permutations are:
        
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
#### Challenge
Do it without recursion.

#### Solution
####Recursive Solution

        class Solution {
            /**
             * @param nums: A list of integers.
             * @return: A list of permutations.
             */
            public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
                // write your code here
                ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> temp = new ArrayList<Integer>();
                if (nums == null || nums.size() == 0) return results;
                boolean[] visited = new boolean[nums.size()];
                for (int i = 0; i< nums.size();i++){
                    visited[i] = false;
                }
                Collections.sort(nums);
                helper(results,temp,nums,visited);
                return results;
            }
            
            public void helper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp, ArrayList<Integer> nums, boolean[] visited) {
                
                for (int i = 0; i < nums.size(); i++){
                    if (!visited[i]){
                        temp.add(nums.get(i));
                        visited[i] = true;
                        helper(results,temp,nums,visited);
                        if (temp.size() == nums.size()) results.add(new ArrayList<Integer>(temp));
                        temp.remove(temp.size()-1);
                        visited[i] = false;
                    }
                    
                }
            }
        }

#### Iterative

Loop through the array, in each iteration, a new number is added to different locations of results of previous iteration. Start from an empty List.

class Solution{
        

}
