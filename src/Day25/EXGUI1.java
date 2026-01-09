package Day25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event1 extends JFrame implements ActionListener {
    JLabel jl;

    public Event1() {
        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());
        JButton jb = new JButton("버튼");
        jl = new JLabel("버튼을 누르세요");
        jb.addActionListener(this);
        ct.add(jb);
        ct.add(jl);
        setTitle("Event Test1");
        setSize(200, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // e.getActionCommand() 버튼에 쓴 글씨
        jl.setText("헬로우");
    }

}

public class EXGUI1 {
    static void main(String[] args) {
     new Event1();
    }
}
