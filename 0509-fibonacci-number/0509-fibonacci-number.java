class Solution {
    int[] memo;
    public int fib(int n) {
        memo= new int[n+1];
        return dfs(n);
    }
    private int dfs(int n) {
        if (n<=1)
            return n;

        if (memo[n]!= 0)
            return memo[n];

        memo[n]= dfs(n-1)+dfs(n-2);
        return memo[n];
    }
}