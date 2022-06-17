package com.greedy;

import java.util.Arrays;

public class CoinChange {
    private static int minCoin(int n, int[] a, int[] dp) {
        if (n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int subAns;
        for (int i = 0; i < a.length; i++) {
            if (n - a[i] >= 0) {
                if (dp[n-a[i]] != -1) {
                    subAns = dp[n-a[i]];
                } else {
                    subAns = minCoin(n - a[i], a, dp);
                    if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                        ans = subAns + 1;
                    }
                }
            }
        }
        return dp[n] = ans;
    }

    public static void main(String[] args) {
        int n = 18;
        int A[] = {7, 5, 1};
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = minCoin(n, A, dp);
        System.out.println(ans);
    }
}
