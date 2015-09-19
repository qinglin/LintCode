
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

>
