package etc.etc;

import java.util.Stack;


/**
 * 호기심에 스택으로 큐 구현하기 시도해 보았음..
 */
public class study_StackToQueue {

    /**
     * public Element push(Element item); // 데이터 추가
     * public Element pop(); // 최근에 추가된(Top) 데이터 삭제
     * public Element peek(); // 최근에 추가된(Top) 데이터 조회
     * public boolean empty(); // stack의 값이 비었는지 확인, 비었으면 true, 아니면 false
     * public int seach(Object o); // 인자값으로 받은 데이터의 위치 반환, 그림으로 설명하겠음
     */
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    /**
     * 결국엔 큰 로직을 설명하자면
     * 1. a 스택은 데이터를 받기만한다.
     * 2. b 스택은 데이터를 역순환 하여 출력한다.
     * 3. 중요한 요점이라면 b 스택은 데이터 입력시에 상시 비어있어야 한다.
     */
    public void test() {

        try {

            // 입력 0~9 까지 데이터 기입
            for (int i = 0; i < 10; i++) {
                Enqueue(i);
                System.out.println("in : " + i);
            }
            System.out.println("in finish : " + inStack);

            // 출력 Dequeue
            do {
                Object a = Dequeue();
                System.out.println("out : " + a);
            } while (!outStack.isEmpty());
            System.out.println("out finish : " + outStack);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    /**
     * 데이터가 들어가는 큐는 입력만 받는다.
     *
     * @param data
     */
    public void Enqueue(int data) {
        inStack.add(data);
    }

    /**
     * 데이터가 나오는 큐는 비어있는 상태에서만 입력이 되어야 한다.
     * 아니면 데이터가 꼬일 수가 있다.
     *
     * @return
     */
    private Object Dequeue() {

        // 데이터가 비어있다면
        if (outStack.isEmpty()) {

            // 입력 스택의 데이터가 존재하지 않을 때까지
            while (!inStack.isEmpty()) {
                // 입력스택값을 꺼내 출력스택으로
                outStack.push(inStack.pop());
            }
        }

        // 데이터 pop
        return outStack.pop();
    }


}

