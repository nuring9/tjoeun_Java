package Day25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 계산기 + 연산자만 완료.


class Calculator extends JFrame implements ActionListener {
    //  JLabel jl; // 라벨 선언인데 여기코드에선 사용하지 않으니 주석
    JTextField display;   // display 라는 이름으로 JTextField 참조 변수 클래스 멤버로 선언.
    // 왜 멤버로? → actionPerformed()에서도 값을 바꿔야 하니까(지역변수면 밖에서 못 씀)
    // JTextField -> 한 줄짜리 텍스트 입력/출력 컴포넌트
    // 사용자가 글자를 입력하거나, 프로그램이 값을 표시하는 용도로 한 줄 텍스트를 다루는 입력창.

    boolean justCalculated = false; // 직후 상태 체크용
    // = 버튼을 방금 눌렀는지 기억하는 상태 변수
    // true → 방금 계산 결과가 화면에 있음, false → 일반 입력 중
    // actionPerformed() 여러 번 호출되기 때문에, 버튼 클릭 사이에서도 상태가 유지돼야 함. 그래서 멤버 변수로 만듦.

    public Calculator() {
        // 생성자
        Container ct = getContentPane();
        // 컨테이너 가져오기, JFrame 안에서 실제 컴포넌트를 올리는 공간
        // 버튼, 패널, 레이아웃 설정은 전부 여기서 수행


        // jl = new JLabel();  라벨 사용하지 않음. 창안에 고정된 텍스트

        // 전체 레이아웃 설정 "5행 1열"
        ct.setLayout(new GridLayout(5, 1, 5, 5));
        // ContentPane를 5행 1열 Grid로 설정,
        // 꼭 5행으로 맞춰야함. 그래서 2,3,4행이 병합없이 같더라도 따로 분리하여 만들어줘야한다. 컴포넌트 기준이기때문에,
        // 행 단위로 JPanel을 배치하기 위한 구조, “열 병합”이 아니라 “행 틀”만 잡음
        /*
        setLayout(LayoutManager)
        컨테이너의 배치 방식 설정
        GridLayout(int rows, int cols, int hgap, int vgap)
        rows = 5 → 행 4개
        cols = 1 → 열 1개
        hgap = 5 → 가로 간격
        vgap = 5 → 세로 간격
        */


        // 1행 4열 전부 병합
        JPanel row1 = new JPanel(new BorderLayout());
        // 첫 번째 행에 들어갈 패널 생성, BorderLayout 사용 → 내부를 하나의 큰 영역으로 사용
        // JPanel(LayoutManager) -> 레이아웃을 지정한 패널 생성
        // BorderLayout -> CENTER가 남은 공간을 전부 차지, “병합된 한 칸”처럼 쓰기 좋음

        display = new JTextField();  // 기본 생성자: 빈 텍스트 필드 생성
        // 한 줄짜리 텍스트 입력/출력 컴포넌트를 생성해서 display에 저장
        display.setEditable(false); // 키보드 입력 막기 (버튼으로만 입력되게)
        // 편집(타이핑)만 금지, 컴포넌트는 활성 상태, 색상 설정 O
        // true면 입력 가능,

        //  display.setEnabled(false); -> 키보드 입력막기를 setEnabled도 가능한데 이건 컴포넌트 비활성화, 색상 설정 X, 회색/하늘색으로 바꿔버림
        display.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽 정렬
        // setHorizontalAlignment -> 정렬 기준 지정 JTextField.RIGHT / LEFT / CENTER
        // 숫자(텍스트필드 안의 글자) 오른쪽 정렬 (계산기 느낌)
        display.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        // 출력창 글자를 “맑은 고딕, 굵게, 24pt”로
        display.setForeground(new Color(0, 0, 0));
        // 글자 색상 블랙
        display.setBackground(Color.WHITE);
        // 배경 색상은 setBackground();
        row1.add(display, BorderLayout.CENTER);
        // row1 패널의 중앙에 display를 배치
        // BorderLayout의 CENTER는 남은 공간을 전부 먹기 때문에 “1행 전체 병합 출력창”이 되는 효과
        // add(Component comp, Object constraints) 컴포넌트를 컨테이너에 추가하면서 위치(제약조건)를 지정
        ct.add(row1);
        // 메인 컨테이너(ct)에 row1 패널을 추가, 1행에 들어감. 추가 순서가 곧 위치


        // 1행 버튼으로 사용할 경우,
        // row1.add(new JButton("1행전체 병합"), BorderLayout.CENTER);
        // 버튼을 패널 중앙에 배치, 결과적으로 4칸을 합친 것처럼 보임
        // // 사용 메서드 add(Component, Object constraint) 컴포넌트를 특정 위치에 배치
        // ct.add(row1);
        // 1행 자리에 row1 패널 추가.
        // GridLayout에서는 위에서부터 순서대로 행 채움


        // 2행4열 그대로
        JPanel row2 = new JPanel(new GridLayout(1, 4, 5, 5));
        // 2행은 1행 4열 Grid, 기본적인 4칸 구조
        for (int i = 1; i <= 4; i++) {
            JButton btn;
            if (i == 4) {
                row2.add(new JButton("+"));
            } else {
                row2.add(new JButton(String.valueOf(i)));
                // String.valueOf(i) -> 숫자, boolean, char 같은 값을 문자열(String)로 바꿔주는 메서드
            }

            // 버튼 4개 생성, GridLayout이 왼쪽 → 오른쪽 순으로 배치
            // GridLayout에서는 순서 = 위치.
        }
        ct.add(row2);
        // 2번째 행에 row2 패널 배치


        // 3행4열 그대로, 2행과 동일 구조
        JPanel row3 = new JPanel(new GridLayout(1, 4, 5, 5));
        // 독립된 패널이라 수정·유지보수 쉬움
        row3.add(new JButton("4"));
        row3.add(new JButton("5"));
        row3.add(new JButton("6"));
        row3.add(new JButton("-"));
        ct.add(row3);
        // 3번째 행에 배치


        //  4행 : 4열 그대로, 2,3행과 동일 구조
        JPanel row4 = new JPanel(new GridLayout(1, 4, 5, 5));
        row4.add(new JButton("7"));
        row4.add(new JButton("8"));
        row4.add(new JButton("9"));
        row4.add(new JButton("*"));
        ct.add(row4);


        //  5행 1,2열 병합, 원래 4열이어야 하지만 3열로 구성
        // 첫 버튼이 2칸 합친 효과
        JPanel row5 = new JPanel(new GridLayout(1, 3, 5, 5));
        row5.add(new JButton("0"));
        // 첫 버튼이 넓게 보이며 병합처럼 동작, 실제 병합 X → 시각적 병합
        row5.add(new JButton("="));
        row5.add(new JButton("/"));
        ct.add(row5);
        // 마지막 행에 배치

        // ct.add(jl);  라벨 추가
        addListeners(row2);
        addListeners(row3);
        addListeners(row4);
        addListeners(row5);

        setTitle("계산기");
        setSize(400, 500);
        setVisible(true);
    }

    private void addListeners(JPanel row) {
        for (Component c : row.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(this);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // actionPerformed -> 버튼 같은 컴포넌트에서 “Action 이벤트”가 발생했을 때, 자동으로 호출되는 메서드
        // 사용자가 "=" 버튼을 눌렀을 때 연산이 되어 출력되므로 여기에다가 연산기능도 넣어야 함.

        String input = e.getActionCommand();
        // 클릭된 버튼의 문자열, 사용자가 누른 버튼의 글자를 가져옴


        if (input.equals("=")) { // = 버튼은 계산 트리거 역할만 함
            // 여기에 "="을 누르면 결과가 출력되는 메소드를 호출.
            calculate();  // 계산 전용 메서드 호출.
            justCalculated = true;  // “지금 결과가 방금 계산된 값이다” 라고 상태 저장, 이후 숫자 입력 시 초기화 판단 기준
            return;  // 아래로 내려가지 않게 return으로 끝내기.
            // 즉 "=" 눌르면 아래 display.setText(display.getText() + input);때문에 창에 "="까지 출력이 되니까
        }

        //  계산 직후 숫자 입력이면 새로 시작
        if (justCalculated && Character.isDigit(input.charAt(0))) {
            // Character.isDigit(char) -> 문자가 숫자인지 검사 (0~9)
            // input.charAt(0) -> 버튼 글자의 첫 문자 가져오기
            display.setText("");       // 화면 초기화 → 새 입력 시작
            justCalculated = false;  // 계산 직후 상태 해제, 이후부터는 일반 입력 모드
        }

        // 연산자 누르면 결과 이어서 사용 가능
        if (justCalculated && !Character.isDigit(input.charAt(0))) {
            // 숫자가 아니면 연산자, 이전 결과를 이어서 계산 허용
            justCalculated = false;
            // 이어서 계산 상태로 전환
        }

        // 라벨을 사용할 경우,
        // String result = input;
        // 기존 라벨 텍스트 + 버튼 값
        // jl.setText(result);
        // 라벨 갱신
        //System.out.println(input);
        // 클릭된 버튼 값 출력

        display.setText(display.getText() + input);
        // 현재 출력된 문자열 뒤에, 새 입력값을 그대로 이어붙임
        // getText() : 현재 화면 문자열 / setText() : 새 문자열 설정
    }


    // 생성자 밖, 클래스 안에다가 연산 로직 생성
    // 클래스 메서드이기 때문에, actionPerformed() 안에서 자유롭게 호출할 수 있다.
    // 같은 클래스 안이면 서로 호출 가능, 메서드 위치(위/아래)는 전혀 상관없다.
    private void calculate() {
        // 실제 연산 로직
        String exp = display.getText();   // 예: "2+3+4+5"
        // 화면에 보이는 전체 수식 문자열 가져오기

        double result = 0;  // 계산 결과를 누적해서 담는 변수. 처음엔 0에서 시작해서 +면 더하고 -면 빼면서 최종 결과
        String num = "";  // 숫자를 문자열로 임시 저장
        // 123을 입력하면 num이 "1" → "12" → "123" 이렇게 쌓인다.
        // 화면에서 읽어오는 수식은 "3+33-5" 처럼 문자들이니까, 숫자 부분을 모아서 나중에 숫자로 변환해야 함.
        char op = '+'; // 첫 연산은 +로 시작
        // 현재 적용할 연산자(직전에 등장한 연산자)를 저장. 첫 숫자는 “그냥 결과에 반영”해야 하므로 기본을 +로 둔다.
        // 예: "3-1"에서 3은 result에 더해져야 시작이 맞음.

        for (int i = 0; i < exp.length(); i++) {
            // 수식 문자열 exp를 왼쪽부터 끝까지 한 글자씩 훑는다.
            char c = exp.charAt(i);
            // exp에서 i번째 문자를 하나 꺼내서 c에 저장. 즉, 문자열에서 한 글자씩 꺼내기

            if (Character.isDigit(c)) {  // isDigit(c) 숫자인지 판별, 연산자(+ -)와 숫자 구분
                // 지금 문자 c가 **숫자(0~9)**면 true.
                num += c; // 숫자 이어붙이기, 숫자라면 num에 붙임
                // 첫 '3'에서 num="3"  다음 '3'에서 num="33
            }


            // 연산자이거나 마지막 문자일 때 계산
            // "계산을 실행할 타이밍”을 잡는 조건.
            if (!Character.isDigit(c) || i == exp.length() - 1) {
                // 지금 문자가 숫자가 아니라면(= 연산자라면) || 지금이 마지막 문자라면 (마지막 숫자도 계산에 반영하려고 이 조건이 필요함)
                if (num.isEmpty()) return;
                // um이 비어있으면 계산할 숫자가 없다는 뜻. return으로 (예외) 미리 막는 거.
                double value = Double.parseDouble(num);  // 문자열 숫자 → 실제 숫자 계산용
                   // 지금까지 모아둔 숫자 문자열 num을 진짜 숫자(double)로 변환.

                if (op == '+') { // op는 이 숫자 앞에 있던 연산자
                    result += value;
                } else if (op == '-') {
                    result -= value;
                }

                op = c;   // 다음 연산자 저장 (연산자”를 만났을 때 의미)
                num = ""; // 다음 숫자를 새로 모아야 하니까 num을 초기화
            }
        }

        display.setText(String.valueOf(result));
        // 계산 결과를 문자열로 바꿔서 화면에 출력
        // String.valueOf(double) 숫자 → 문자열 => JTextField.setText(String)

    }

}

public class Q1 {
    static void main() {
        new Calculator();
    }
}
