package Leetcode.challenge.Algorithms;

import java.util.HashMap;
import java.util.Map;

/*
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
*/
public class Fibonacci {
    public int fib(int N) {
// Method 1
/*
        if (N == 0)
            return 0;
        else if (N == 1)
            return 1;
        else
            return fib(N - 1) + fib(N - 2);
*/
// Method 2
        Map<Integer, Integer> save = new HashMap<>();
        return saveFib(N, save);
    }


    public int saveFib(int N, Map<Integer, Integer> save) {
        if (N <= 0) return 0;
        else if (N == 1) return 1;
        else if (save.containsKey(N)) return save.get(N);
        save.put(N, saveFib(N - 1, save) + saveFib(N - 2, save));
        return save.get(N);

    }
}
