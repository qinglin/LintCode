#Definition
####Problem:
####[Subsets](http://www.lintcode.com/en/problem/subsets/)
####
Given a set of distinct integers, return all possible subsets.

Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


Note: 
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.
####Challenge
Solve it in iterative method. 

####Solution
1. Iterative
2. Recursive (DFS + Backtracking)

* Iterative
  
  Use a byte array (binary array) to save the current index that are not 0.
    
  For example: 
    [1,2,3]
  * 1: 001
  * 2: 010
  * 3: 100
  * So the result would be {[],[001],[010],[100],[011],[101],[110],[111]}
   
          class Solution {
            /**
             * @param S: A set of numbers.
             * @return: A list of lists. All valid subsets.
             */
            public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
                byte[] bytes = new byte[S.size()];
                ArrayList<Integer> temp = new ArrayList<Integer>();
                ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
                Collections.sort(S);
                while (true){
                    // add all the subset into the result
                    for (int i = 0; i< bytes.length; i++) {
                        if (bytes[i] != 0) temp.add(S.get(i));
                    }
                    subsets.add(new ArrayList<Integer>(temp));
                    temp = new ArrayList<Integer>();
                    int i = 0;
                    while ( i < bytes.length && bytes[i] == 1){
                        bytes[i] = 0;
                        i++;
                    }
                    if ( i == bytes.length) break;
                    bytes[i]=1; 
                }
                
                return subsets;
            }
        }
  

 * Recursive
 

            class Solution {
                /**
                 * @param S: A set of numbers.
                 * @return: A list of lists. All valid subsets.
                 */
                public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
                    Collections.sort(S);
                    subsets.add(temp);
                    helper(subsets,S,temp,0);
                    return subsets;
                    
                }
                public void helper(ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> S, ArrayList<Integer> temp, int index) {
                    
                    for (int i = index; i< S.size(); i++) {
                        temp.add(S.get(i));
                        subsets.add(new ArrayList<Integer>(temp));
                        helper(subsets,S,temp,i+1);
                        temp.remove(temp.size()-1);
                    }
                    
                }
            }


