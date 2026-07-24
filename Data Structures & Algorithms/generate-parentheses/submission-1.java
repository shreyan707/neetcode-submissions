class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return ans;
    }

    void backtrack(int n, int open, int close, StringBuilder curr) {

        if (curr.length() == 2 * n) {
            ans.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            backtrack(n, open + 1, close, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(')');
            backtrack(n, open, close + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}