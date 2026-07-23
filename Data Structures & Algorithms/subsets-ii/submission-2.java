class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] arr, int index, List<Integer> current)
    {
       // System.out.println("\n\nINDEX: "+index);
        //System.out.println("Current: "+current);
        //System.out.println("BASE CASE: "+current);

        ans.add(new ArrayList(current));


        for(int i=index;i<arr.length; i++)
        {
            //System.out.println("i : "+i);
            if(i>index && arr[i]==arr[i-1]) continue;
            current.add(arr[i]);
            backtrack(arr,i+1, current);
            current.remove(current.size()-1);
            //System.out.println("BACKTRACK : "+current);
        }

    }
}
