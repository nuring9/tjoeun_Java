package Day25;

import javax.swing.*;
import java.awt.*;

class  GridLayout1 extends JFrame{
    // JFrame 상속 → 창(Window) 생성
    // GridLayout을 사용하는 GUI 창

    public GridLayout1() {
        // 객체 생성 시 자동 실행
        // 화면 구성 전부 여기서 함

        Container ct = getContentPane();  // 컨테이너 얻기
        // JFrame 내부에 실제 컴포넌트를 올리는 공간
        // 버튼, 라벨 등은 여기에 추가

        GridLayout gl = new GridLayout(4,5,10,10);
        // GridLayout 생성, GridLayout은 모든 컴포넌트를 동일 크기 셀로 강제
        // 의미 하나씩 풀면: 4 = 행(row) 개수 / 5 = 열(column) 개수 / 10 = 가로 간격 / 10 = 세로 간격
        // -> 4 × 5 = 20칸짜리 격자
        ct.setLayout(gl);
        // 레이아웃 설정, 컨테이너 배치 방식을 GridLayout으로 지정
        // 이후 add() 되는 컴포넌트는 격자에 자동 배치

        for(int i = 1; i <= 20; i++) { // 1부터 20까지 반복
            // 격자 칸 수와 정확히 맞음.
            ct.add(new JButton("버튼"+i));
            // 버튼 생성 + 바로 추가
            // GridLayout은 추가 순서대로 왼쪽 → 오른쪽, 위 → 아래
        }
        setTitle("GridLayout Test1");
        // 창 제목
        setSize(800,800);
        // 창 크기
        setVisible(true);
        // 화면에 창 표시, 없으면 창 안 보임
    }
}


public class GridLayoutTest1 {
    static void main() {
            new GridLayout1();
            // GridLayout1 객체 생성 → 창 실행
    }
}
