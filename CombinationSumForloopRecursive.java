//Time complexity :O(m^n) where n is size of candidates in the given array
//Space Complexity:O(length of the longest combination
//for loop using Recursive call  approach:
//for loop inorder to do recursion .It going to start from the given array with  base case and once it hit the base case then increment to the next index value target -candidate[i],It is forward and index at back .we can do using recursion same method.
//If it goes at the end of empty listh then it goes out of bound and if target gors to negative value then it goes toinvalid and it target reaches to zero then it should added to the result by using recursive.Initial start with choose =0 and not choose =1 then subtract the starting index value from the candidates list to target.e.g:choose0 = 3,6,7-target 7 and choose1 = 2,3,6,7 and target 5.

//Starting with an empty list and ending with an empty list but at some point the list is filled at that time need to store the result into an ArrayList.Backtracking is an optimization to an recursion solution .Backtracking held only one list starting with index 1 case and adding to the path .
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates,int target,int index,List<Integer> path){
        //base
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //0 case or do not choose case
        for(int i = index;i<candidates.length;i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates,target-candidates[i],i,path);
            //backtrack
            //1 case or choose case
            path.remove(path.size()-1);
        }
        
        
        
    }
}