package programmers;

public class 카카오블라인드_자물쇠와열쇠 {

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/60059
     *
     * 문제 설명
     * 고고학자인 "튜브"는 고대 유적지에서 보물과 유적이 가득할 것으로 추정되는 비밀의 문을 발견하였습니다. 그런데 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨 있었고 문 앞에는 특이한 형태의 열쇠와 함께 자물쇠를 푸는 방법에 대해 다음과 같이 설명해 주는 종이가 발견되었습니다.
     * 잠겨있는 자물쇠는 격자 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태이고 특이한 모양의 열쇠는 M x M 크기인 정사각 격자 형태로 되어 있습니다.
     * 자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다. 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조입니다. 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만, 자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다. 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.
     * 열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이 매개변수로 주어질 때, 열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * key는 M x M(3 ≤ M ≤ 20, M은 자연수)크기 2차원 배열입니다.
     * lock은 N x N(3 ≤ N ≤ 20, N은 자연수)크기 2차원 배열입니다.
     * M은 항상 N 이하입니다.
     * key와 lock의 원소는 0 또는 1로 이루어져 있습니다.
     * 0은 홈 부분, 1은 돌기 부분을 나타냅니다.
     *
     * 입출력 예
     * key	                                lock                                result
     * [[0, 0, 0], [1, 0, 0], [0, 1, 1]]	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]   true
     *
     * 입출력 예에 대한 설명
     * key를 시계 방향으로 90도 회전하고, 오른쪽으로 한 칸, 아래로 한 칸 이동하면 lock의 홈 부분을 정확히 모두 채울 수 있습니다.
     *
     * [key]        [lock]
     * □□□          ■■■
     * ■□□          ■■□
     * □■■          ■□■
     *
     * 테스트 1 〉	통과 (0.34ms, 53.3MB)
     * 테스트 2 〉	통과 (0.10ms, 54MB)
     * 테스트 3 〉	통과 (7.33ms, 54.5MB)
     * 테스트 4 〉	통과 (0.07ms, 53.1MB)
     * 테스트 5 〉	통과 (23.84ms, 57.9MB)
     * 테스트 6 〉	통과 (11.68ms, 55.6MB)
     * 테스트 7 〉	통과 (14.93ms, 56.7MB)
     * 테스트 8 〉	통과 (28.63ms, 68.4MB)
     * 테스트 9 〉	통과 (41.31ms, 71.1MB)
     * 테스트 10 〉	통과 (63.65ms, 74.8MB)
     * 테스트 11 〉	통과 (70.83ms, 75.7MB)
     * 테스트 12 〉	통과 (0.06ms, 53.1MB)
     * 테스트 13 〉	통과 (4.93ms, 53.6MB)
     * 테스트 14 〉	통과 (1.11ms, 52.1MB)
     * 테스트 15 〉	통과 (3.09ms, 53.9MB)
     * 테스트 16 〉	통과 (16.11ms, 57.6MB)
     * 테스트 17 〉	통과 (0.93ms, 53.2MB)
     * 테스트 18 〉	통과 (17.70ms, 58.4MB)
     * 테스트 19 〉	통과 (0.81ms, 53.5MB)
     * 테스트 20 〉	통과 (48.46ms, 71.3MB)
     * 테스트 21 〉	통과 (6.37ms, 55MB)
     * 테스트 22 〉	통과 (11.00ms, 57.1MB)
     * 테스트 23 〉	통과 (1.69ms, 53.6MB)
     * 테스트 24 〉	통과 (3.72ms, 52.5MB)
     * 테스트 25 〉	통과 (54.30ms, 71.2MB)
     * 테스트 26 〉	통과 (58.05ms, 70.9MB)
     * 테스트 27 〉	통과 (74.67ms, 75.8MB)
     * 테스트 28 〉	통과 (10.20ms, 56MB)
     * 테스트 29 〉	통과 (3.73ms, 52.9MB)
     * 테스트 30 〉	통과 (16.57ms, 59.6MB)
     * 테스트 31 〉	통과 (31.48ms, 64.8MB)
     * 테스트 32 〉	통과 (65.43ms, 70.9MB)
     * 테스트 33 〉	통과 (13.80ms, 58.1MB)
     * 테스트 34 〉	통과 (0.19ms, 52.6MB)
     * 테스트 35 〉	통과 (1.48ms, 52.8MB)
     * 테스트 36 〉	통과 (2.78ms, 52.9MB)
     * 테스트 37 〉	통과 (2.18ms, 52.4MB)
     * 테스트 38 〉	통과 (0.65ms, 52.7MB)
     *
     * @param key
     * @param lock
     * @return
     */
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = isUnlock(key, lock);
        return answer;
    }


    /**
     * key + lock(4way) 를 xor 로 합산
     *
     * @param key  초기 key
     * @param lock 초기 lock
     * @return result
     */
    public boolean isUnlock(int[][] key, int[][] lock) {
        boolean result = false;
        int[][][] keyArr = rotateKey(key);

        // key 의 기준으로 반복을 진행한다.
        for (int keyDir = 0; keyDir < 1; keyDir++) {

            int[][] exLock = extendLock(lock, key.length);
            int max = exLock.length - key.length;

            for (int rowLock = 0; rowLock <= max; rowLock++) {
                for (int colLock = 0; colLock <= max; colLock++) {
                    int rowKey = 0;

                    // 각 포인트의 xy 출발점에서 확장lock 초기화
                    exLock = extendLock(lock, key.length);

                    for (int rowLockPlusKey = rowLock; rowLockPlusKey < rowLock + key.length; rowLockPlusKey++) {
                        int colKey = 0;
                        for (int colLockPlusKey = colLock; colLockPlusKey < colLock + key.length; colLockPlusKey++) {

                            // 확장 lock ^ key (xor) 
                            exLock[rowLockPlusKey][colLockPlusKey] = exLock[rowLockPlusKey][colLockPlusKey] ^ keyArr[keyDir][rowKey][colKey];
                            colKey++;
                        }

                        rowKey++;
                    }

                    // 체크
                    result = isCheck(exLock, key.length);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * 키를 4가지로 변경 반환    0:[0º]   1:[90º]   2:[180º]   3:[270º]
     *
     * @param key 초기 key
     * @return 4가지 방향
     */
    public int[][][] rotateKey(int[][] key) {
        int[][][] result = new int[4][key.length][key.length];
        for (int row = 0; row < key.length; row++) {
            for (int col = key.length - 1; col >= 0; col--) {
                result[0][row][col] = key[row][col];
                result[1][row][col] = key[key.length - 1 - col][row];
                result[2][row][col] = key[key.length - 1 - row][key.length - 1 - col];
                result[3][row][col] = key[col][key.length - 1 - row];
            }
        }
        return result;
    }


    /**
     * key + lock 키가 열리는지 반환 전체 1로 되어있어야 하므로 체크
     * 실제 중앙 부분의 Lock 부분만 체크
     *
     * @param extendLock key + extendLock 데이터
     * @return 열림 판단 여부
     */
    public boolean isCheck(int[][] extendLock, int keyLength) {
        for (int i = keyLength - 1; i < extendLock.length - (keyLength - 1); i++) {
            for (int j = keyLength - 1; j < extendLock.length - (keyLength - 1); j++) {
                if (extendLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 확장 Lock 키 값 사이즈에 +@
     *
     * @param lock      기존 lock
     * @param keyLength 기존 lock 에 추가될 가로 세로 (상하좌우) 추가 길이
     * @return 확장된 lock 을 반환
     */
    public int[][] extendLock(int[][] lock, int keyLength) {
        int[][] exLock = new int[lock.length + (keyLength * 2 - 2)][lock.length + (keyLength * 2 - 2)];
        for (int i = keyLength - 1; i < keyLength - 1 + lock.length; i++) {
            for (int j = keyLength - 1; j < keyLength - 1 + lock.length; j++) {
                exLock[i][j] = lock[i - (keyLength - 1)][j - (keyLength - 1)];
            }
        }
        return exLock;
    }

}
