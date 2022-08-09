## LeetCode - 121. Best Time to Buy and Sell Stock
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