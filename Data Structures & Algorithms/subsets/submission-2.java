class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    void backtrack(int[] arr, int index, List<Integer> current) {
        
        ans.add(new ArrayList<>(current));

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            backtrack(arr,i+1,current);
            current.remove(current.size()-1);


        }
    }
}
