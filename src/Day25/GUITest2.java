package Day25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Test extends JFrame implements ActionListener {
   // extends JFrame → 창(Window)을 만들기 위한 상속
   // implements ActionListener → 버튼 클릭 이벤트를 처리하겠다는 선언

    JLabel jl;
    // 라벨 선언, 이벤트 메서드에서도 써야 하므로 멤버 변수.

    public Test() {
        // 창이 생성될 때 실행

        Container ct = getContentPane();
        // JFrame의 실제 내용이 들어가는 공간
        ct.setLayout(new FlowLayout());
        // 컴포넌트를 왼쪽 → 오른쪽 순서로 배치

        JButton j1 = new JButton("1");
        JButton j2 = new JButton("2");
        // 버튼 생성, 버튼에 적힌 글자가 ActionCommand 기본값

        jl = new JLabel("안녕!");
        // 라벨 생성. 화면에 텍스트 출력용, 초기값: "안녕!"

        ct.add(j1);
        ct.add(j2);
        ct.add(jl);
        // 화면에 컴포넌트 추가.
        // 버튼 2개 + 라벨을 컨테이너에 추가

        j1.addActionListener(this);
        j2.addActionListener(this);
        // 이벤트 연결
        // 버튼 클릭 시, 현재 객체(Test)의 actionPerformed() 실행

        // 창 기본 설정
        setTitle("GUI Test2");
        // 창 제목
        setSize(500, 500);
        // 창 크기
        setVisible(true);
        // 화면 표시
    }

    public void actionPerformed(ActionEvent ae) {
        // 버튼 클릭 시 자동 호출
        // ae 안에 어떤 버튼이 눌렸는지 정보 포함

        String input = ae.getActionCommand();
        // 클릭된 버튼의 문자열
        // 여기서는 "1" 또는 "2"

        String result = jl.getText() + input;
        // 기존 라벨 텍스트 + 버튼 값

        jl.setText(result);
        // 라벨 갱신

        System.out.println(input);
        // 클릭된 버튼 값 출력
    }
}

public class GUITest2 {
    static void main() {
        new Test();
    }
}
