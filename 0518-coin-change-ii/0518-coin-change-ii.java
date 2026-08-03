class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;

        int[][] a=new int[n + 1][amount + 1];

        for (int i= 0;i<= n;i++) {
            a[i][0]= 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                a[i][j] = a[i - 1][j];
                if (j >= coins[i - 1]) {
                    a[i][j] += a[i][j - coins[i - 1]];
                }
            }
        }
        return a[n][amount];
    }
}