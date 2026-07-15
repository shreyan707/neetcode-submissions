class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> substring = new HashSet<>();
        int l=0;
        int res=0;

        for(int r=0; r<s.length();r++){
            while(substring.contains(s.charAt(r))){
                substring.remove(s.charAt(l));
                l++;
            }
            substring.add(s.charAt(r));
            res = Math.max(res, r-l+1);
        }

        return res;

    }
}
