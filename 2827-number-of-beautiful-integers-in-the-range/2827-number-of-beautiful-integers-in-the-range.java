class Solution {

    String num;
    int k;
    Long[][][][][] dp;

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        return (int) (solve(high) - solve(low - 1));
    }

    private long solve(int x) {
        if (x <= 0) return 0;

        num = String.valueOf(x);
        int n = num.length();
        dp = new Long[n][k][21][2][2];

        return dfs(0, 0, 10, 1, 0);
    }

    private long dfs(int pos, int mod, int balance, int tight, int started) {

        if (pos == num.length()) {
            if (started == 1 && mod == 0 && balance == 10)
                return 1L;
            return 0L;
        }

        if (dp[pos][mod][balance][tight][started] != null)
            return dp[pos][mod][balance][tight][started];

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;

        long ans = 0;

        for (int d = 0; d <= limit; d++) {

            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            int newStarted = (started == 1 || d != 0) ? 1 : 0;

            int newMod = mod;
            int newBalance = balance;

            if (newStarted == 1) {
                newMod = (mod * 10 + d) % k;

                if ((d & 1) == 0)
                    newBalance++;
                else
                    newBalance--;
            }

            if (newBalance >= 0 && newBalance <= 20)
                ans += dfs(pos + 1, newMod, newBalance, newTight, newStarted);
        }

        return dp[pos][mod][balance][tight][started] = ans;
    }
}