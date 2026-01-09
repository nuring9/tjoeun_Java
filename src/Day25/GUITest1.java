package Day25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

class GUI1 extends JFrame implements ActionListener {
    private JTextField jtf;
    // jtf → 파일 이름 입력
    private JTextArea jta;
    // jta → 파일 내용 입력

    public GUI1() {
        // 창 생성 시 실행

        JButton jb = new JButton("파일로 저장");
        // 버튼 생성
        jtf = new JTextField("파일 이름을 입력하세요.", 20);
        // 파일명 입력칸 (가로 20칸)
        jta = new JTextArea("파일의 내용을 입력하세요.", 10, 20);
        // 여러 줄 텍스트 입력 영역


        Container ct = getContentPane();
        // JFrame 기본 컨테이너
        ct.setLayout(new FlowLayout());
        // FlowLayout → 왼쪽부터 차례로 배치

        JPanel p1 = new JPanel();
        // 컴포넌트 묶기용 패널

        ct.add(jta);
        p1.add(jtf);
        p1.add(jb);
        ct.add(p1);
        // TextArea는 바로 추가
        // TextField + Button은 패널로 묶어서 추가

        jb.addActionListener(this);
        // 버튼 클릭 시 actionPerformed() 호출

        setTitle("GUI Test1");
        // 창 제목
        setSize(500, 300);
        // 창 크기
        setVisible(true);
        // 화면 표시 (이 창(JFrame)을 “화면에 보여줘라)

    }

    public void actionPerformed(ActionEvent ae) {
        // 버튼 클릭 이벤트 발생 시 실행

        try {
            String s = jtf.getText();
            // 입력한 파일 이름 읽기

            FileOutputStream fos = new FileOutputStream(s);
            // 파일 생성
            // 같은 이름 있으면 덮어쓰기

            DataOutputStream dos = new DataOutputStream(fos);
            // 문자열을 편하게 쓰기 위한 스트림

            dos.writeUTF(jta.getText());
            // TextArea의 내용을 파일에 저장
            // UTF 형식으로 저장
            fos.close();
            // 파일 닫기 (중요)

            System.out.println(s + "파일이 생성되었습니다.");
            // 콘솔 출력

        } catch (Exception e) {
            // catch 블록은 비어 있음 → 오류 숨김

        }
    }
}

public class GUITest1 {
    static void main(String[] args) {
        new GUI1();
        // GUI1 객체 생성 → 창 띄움.
    }
}
