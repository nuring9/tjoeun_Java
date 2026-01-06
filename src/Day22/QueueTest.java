package Day22;

import java.util.LinkedList;

/*
큐는 먼저 들어간사람이 먼저 나옴. 즉, 순서대로 선입선출 FIFO
스택은 나중에 들어간사람이 먼저 나옴. 메소드가 이런 형태
 */
public class QueueTest {
    static void main() {
        LinkedList<String> queue = new LinkedList<String>();
        System.out.println("큐에 경기도 offer : " + queue.offer("경기도"));
        System.out.println("큐에 경기도 offer : " + queue.offer("충청도"));
        System.out.println("큐에 경기도 offer : " + queue.offer("강원도"));
        System.out.println("큐에 경기도 offer : " + queue.offer("전라도"));
        System.out.println("큐에 경기도 offer : " + queue.offer("경상도"));
        System.out.println("큐에 경기도 offer : " + queue.offer("제주도"));

        System.out.println("===========================================");
        int n = queue.indexOf("제주도");
        if (n != -1) {
            System.out.println("큐에서 숫자 \"제주도\"의 위치는 : " + n + "번째 입니다.");
        } else {
            System.out.println("큐에서 숫자 \"제주도\"가 없습니다.");
        }
        System.out.println("===========================================");
        while (!queue.isEmpty()) {
            Object obj = queue.poll();
            System.out.println("큐에서 poll : " + obj);
        }
    }
}
