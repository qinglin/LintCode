# Description
#### Problem Statement
[Fibonacci](http://www.lintcode.com/en/problem/fibonacci/)

Find the Nth number in Fibonacci sequence.

A Fibonacci sequence is defined as follow:

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

        Example
        Given 1, return 0
        
        Given 2, return 1
        
        Given 10, return 34

Note
The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.

#### Analysis
Use dp, otherwise it will exceeds the maximum runtime. 

#### My Code
        class Solution {
            /**
             * @param n: an integer
             * @return an integer f(n)
             */
            public int fibonacci(int n) {
                // write your code here
                int dp[] = new int[n+1];
                dp[0] = 0;
                dp[1] = 1;
                for (int i = 2; i<= n ;i++) {
                    dp[i] = dp[i-1] + dp[i-2];
                }
                return dp[n-1];
            }
           
        }

##### Time Complexity
O(n)


