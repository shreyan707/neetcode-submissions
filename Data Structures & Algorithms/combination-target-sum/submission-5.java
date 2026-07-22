class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayList<>());
        return ans;
    }

    void backtrack(int[] arr, int target, int index, List<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            backtrack(arr, target - arr[i], i, current);
            current.remove(current.size() - 1);
        }
    }
}
