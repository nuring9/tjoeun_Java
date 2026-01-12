package Day26;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Calculator extends JFrame implements ActionListener{

    JLabel label;
    String textOutput = "";
    ArrayList<String> op = new ArrayList<String>();

    public Calculator() {
        // TODO Auto-generated constructor stub
        setSize(400,400);
        setLocation(800,400);
        setTitle("계산기");
        setVisible(true);

        label = new JLabel("0",JLabel.RIGHT);
        JPanel mainView = new JPanel();
        label.setBackground(Color.WHITE);
        label.setFont(new Font("",Font.BOLD,50));
        label.setOpaque(true);// 배경색을 설정을 true

        JPanel btnView = new JPanel();
        btnView.setLayout(new GridLayout(5,4,5,5));

        JButton b1 = new JButton("1");
        b1.addActionListener(this);
        btnView.add(b1);

        JButton b2 = new JButton("2");
        b2.addActionListener(this);
        btnView.add(b2);


        JButton b3 = new JButton("3");
        b3.addActionListener(this);
        btnView.add(b3);

        JButton bminer = new JButton("-");
        bminer.addActionListener(this);
        btnView.add(bminer);

        //2번째 줄
        JButton b4 = new JButton("4");
        b4.addActionListener(this);
        btnView.add(b4);

        JButton b5 = new JButton("5");
        b5.addActionListener(this);
        btnView.add(b5);

        JButton b6 = new JButton("6");
        b6.addActionListener(this);
        btnView.add(b6);

        JButton bplus = new JButton("+");
        bplus.addActionListener(this);
        btnView.add(bplus);

        //3번째 줄
        JButton b7 = new JButton("7");
        b7.addActionListener(this);
        btnView.add(b7);

        JButton b8 = new JButton("8");
        b8.addActionListener(this);
        btnView.add(b8);

        JButton b9 = new JButton("9");
        b9.addActionListener(this);
        btnView.add(b9);

        JButton bgob = new JButton("*");
        bgob.addActionListener(this);
        btnView.add(bgob);

        //4번째 줄
        JButton b0 = new JButton("0");
        b0.addActionListener(this);
        btnView.add(b0);

        JButton bnone = new JButton("");
        btnView.add(bnone);

        JButton beq = new JButton("=");
        beq.addActionListener(this);
        btnView.add(beq);


        JButton bna = new JButton("/");
        bna.addActionListener(this);
        btnView.add(bna);

        mainView.setLayout(new BorderLayout());
        add(label,BorderLayout.CENTER);
        add(btnView,BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //56 + 10 - 8 =
        String input = e.getActionCommand(); // 버튼 이벤트가 왔다 -> 문자열
        if(input.equals("=")) {
            //연산
            String regExp ="[^0-9]"; // 정규화 표현식
            String[] number = textOutput.split(regExp);  ///[0] 56  [1] 10 [2] 8
            int result = 0;
            //                 2
            for(int i = 0;i<op.size();i++) {
                if(i == 0) {
                    if(op.get(i).equals("+")) {
                        // Integer.parseInt -> 문자열을 정수 바꿔주눈거
                        // 66             56                              10
                        result = Integer.parseInt(number[i]) + Integer.parseInt(number[i+1]);
                    }
                    if(op.get(i).equals("-")) {
                        result = Integer.parseInt(number[i]) - Integer.parseInt(number[i+1]);
                    }
                    if(op.get(i).equals("*")) {
                        result = Integer.parseInt(number[i]) * Integer.parseInt(number[i+1]);
                    }
                    if(op.get(i).equals("/")) {
                        result = Integer.parseInt(number[i]) / Integer.parseInt(number[i+1]);
                    }
                }
                else {
                    if(op.get(i).equals("+")) {
                        result  += Integer.parseInt(number[i+1]);
                    }
                    if(op.get(i).equals("-")) {
                        // 66   -=   8 -> 58
                        result  -= Integer.parseInt(number[i+1]);
                    }
                    if(op.get(i).equals("*")) {
                        result  *= Integer.parseInt(number[i+1]);
                    }
                    if(op.get(i).equals("/")) {
                        result  /= Integer.parseInt(number[i+1]);
                    }
                }
            }

            textOutput = result + ""; // 58
            label.setText(textOutput); // 쓰기
            op.clear(); // 연산자 클리어
        }
        else {
            if(input.equals("+")) {
                op.add("+"); // ArrayList에 "+" 추가  "-" 추가
            }
            if(input.equals("-")) {
                op.add("-");
            }
            if(input.equals("*")) {
                op.add("*");
            }
            if(input.equals("/")) {
                op.add("/");
            }

            textOutput += input;
            label.setText(textOutput);
        }
    }
}


public class Q1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Calculator(); // 생성자 호출
    }

}

