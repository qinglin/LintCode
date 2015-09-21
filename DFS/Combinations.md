#Description
#### Problem Statement
[Combinations] (http://www.lintcode.com/en/problem/combinations/)

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example

        For example,
        If n = 4 and k = 2, a solution is:
        [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
        
####Analysis
DFS+Backtracing
        For example: 
        
        n = 4, k = 2. 
        [1,2,3,4]
        (1,2) -> (1)-> (1,3) -> (1) -> (1,4) -> (1) -> () -> (2) -> (2,3) -> (2) -> (2,4) -> (2) -> () -> (3) -> (3,4) -> (3) 
        
        -> () -> (4)
        
        So the result is: 
        (1,2),(1,3),(1,4),(2,3),(2,4),(3,4)

####Solution
        public class Solution {
            /**
             * @param n: Given the range of numbers
             * @param k: Given the numbers of combinations
             * @return: All the combinations of k numbers out of 1..n
             */
            public List<List<Integer>> combine(int n, int k) {
        		// write your code here
        		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        		ArrayList<Integer> temp = new ArrayList<Integer>();
        		if (n == 0 || k == 0) return results;
        		helper(results,temp,n,k,1);
        		return results;
            }
            public void helper(ArrayList<List<Integer>> results, ArrayList<Integer> temp,int n, int k, int start){
                if (temp.size() == k) {
                    results.add(new ArrayList<Integer>(temp));
                    return;
                }
                for (int i = start; i<= n; i++) {
                    temp.add(i);
                    helper(results,temp,n,k,i+1);
                    temp.remove(temp.size()-1);
                }
            }
        }
#### Test Cases
1. n = 0 return {}
2. k = 0 return {}
3. n < k return {}
4. Regular
