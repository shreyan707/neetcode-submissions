class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>());
        return ans;
    }

    void backtrack(int[] arr, boolean[] used, List<Integer> current) {
        if (current.size() == arr.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            current.add(arr[i]);

            backtrack(arr, used, current);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}