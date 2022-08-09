## LeetCode - 70. Climbing Stairs(DP)
### 문제 및 풀이 주소
[LeetCode](https://leetcode.com/problems/climbing-stairs/)  
[Git Solution](https://github.com/mertyn88/algorithm/blob/feature/longestincreasing/src/com/algorithm/leetcode/longestincreasing/Solution.java)

### 문제 설명 - 영문
>You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

### 문제 설명 - 번역
>당신은 계단을 오르고 있습니다. n정상에 도달하려면 단계가 필요 합니다.
매번 1~2 오르거나 걸을 수 있습니다. 얼마나 많은 독특한 방법으로 정상에 오를 수 있습니까?


예 1:
>입력: n = 2
출력: 2
설명: 정상에 오르는 방법에는 두 가지가 있습니다.
>1. 1단계 + 1단계
>2. 2단계

예 2:
>입력: n = 3
출력: 3
설명: 정상에 오르는 방법에는 세 가지가 있습니다.
>1. 1단계 + 1단계 + 1단계
>2. 1단계 + 2단계
>3. 2단계 + 1단계

제약조건
* 1 <= n <= 45

<details>
 <summary>풀이 보기</summary>
 <div markdown="16">

### 문제 해결
정답을 찾는데 좀 헤매게 되었다. 결과 값으로만 값을 도출하고 패턴이 피보나치란 판단이 들어 피보나치로 풀게 되었음.
보통 피보나치를 푸는데 있어 `recursion` 으로 많이 푸는데 앞선 배열값을 가지고 다음 값을 연산하는 방식을 `memoization` 을 통해 계산 이미 저장된 값을 이용하므로 재사용 최적화 기법사용

>i 는 인덱스 값이며 해당 위치마다 값을 찾는다.
```java
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
        dp[i] = dp[i - 2] + dp[i - 1];
        }
```
DP를 접근하는데는 두가지 방식있는데, `Top-Down` 과 `Bottom-Up` 이 있다.
>1. Top-Down 같은 경우는 큰문제 → 작은문제
>2. Bottom-Up 같은 경우는 작은문제 → 큰문제
>3. 해당 문제는 `Bottom-Up` 해결

#### 전체코드
```java
    public static int climbStairs(int n) {
        if (n< 2){
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[dp.length - 1];
    }
```

### 테스트 결과
Success
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
Memory Usage: 41.6 MB, less than 7.63% of Java online submissions for Climbing Stairs.


### 후기
피보나치를 대입하는게 맞나? 싶은 문제였음.

</div>
</details>

---

## LeetCode - 121. Best Time to Buy and Sell Stock(DP)
### 문제 및 풀이 주소
[LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)  
[Git Solution](https://github.com/mertyn88/algorithm/blob/feature/longestincreasing/src/com/algorithm/leetcode/longestincreasing/Solution.java)

### 문제 설명 - 영문
>You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

### 문제 설명 - 번역
>그날 주어진 주식의 가격이 인 배열이 제공 prices됩니다 .prices[i] i
한 주식을 사는 날 을 선택 하고 그 주식을 팔기 위해 미래의 다른 날을 선택하여 이익을 최대화하려고 합니다 .
이 거래에서 얻을 수 있는 최대 이익을 반환 합니다. 이익을 얻을 수 없으면 를 반환 0하십시오.


예 1:
>입력: 가격 = [7,1,5,3,6,4]
출력: 5
설명: 2일차에 매수(가격 = 1)하고 5일차에 매도(가격 = 6), 이익 = 6-1 = 5.
2일차에 매수하고 1일차에 매도하는 것은 매도 전에 매수해야 하므로 허용되지 않습니다.

예 2:
>입력: 가격 = [7,6,4,3,1]
출력: 0
설명: 이 경우 트랜잭션이 수행되지 않고 최대 이익 = 0입니다.

예 3:
>입력: 숫자 = [7,7,7,7,7,7,7]
출력: 1


제약조건
* 1 <= prices.length <= 105
* 0 <= prices[i] <= 104

<details>
 <summary>풀이 보기</summary>
 <div markdown="16">

### 문제 해결
전체를 순회하며 해당 인덱스 위치에서 min, max 값을 도출한다.

>i 는 인덱스 값이며 해당 위치마다 값을 찾는다.
```java
        // 최소값을 계속 찾음.
        min = Math.min(min,prices[i]);

        // 현재 최대값 vs 현재 인덱스값 - 현재 최소값
        max = Math.max(max, prices[i] - min);
```
최소값의 초기값은 0번 `prices[0]` 이므로 반복해서 i 가 증가 할때마다 최소 값을 찾는다.
최대값의 초기값은 0이므로 `max | curr-min` 으로 비교한다면 최대값을 찾을 수 있다. 

#### 전체코드
```java
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {

        // 최소값을 계속 찾음.
        min = Math.min(min,prices[i]);

        // 현재 최대값 vs 현재 인덱스값 - 현재 최소값
        max = Math.max(max, prices[i] - min);
        }
        return max;
    }
```

### 테스트 결과
Success
Details
Runtime: 3 ms, faster than 69.64% of Java online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 83.7 MB, less than 53.60% of Java online submissions for Best Time to Buy and Sell Stock.


### 후기
DP의 이해보다 해당 자리에서 최대 값의 연산 이후의 값을 찾는 시도했다..

</div>
</details>

---