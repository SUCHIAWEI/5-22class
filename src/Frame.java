import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.awt.image.GifImageDecoder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame{
    private Container cp;
    private JLabel lb =  new JLabel();
    private ImageIcon icon = new ImageIcon("魚.png");
    private Timer t ;
    private JButton jb[] = new JButton[6];
    private JPanel jp2 = new JPanel();
    private JPanel jp1 = new JPanel(new GridLayout(1,6,3,3));
    int op = 0 , objx =50 ,objy = 50 ,objw = 100 ,objh = 100 ;
    public Frame (){
        init();
    }
    private void init() {
        this.setBounds(100,100,600,600);
        cp = this.getContentPane();
        cp.add(jp1, BorderLayout.SOUTH);
        cp.add(jp2, BorderLayout.CENTER);

        

        jp2.add(lb);
        lb.setBounds(objx, objy, objw, objh);

        lb.setIcon(icon);
        t = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (op) {
                    case 1:
                        if (objy -10 >0){
                            objy -=10;
                        }
                        break;
                    case 2:
                        if (objy<530-objh){
                            objy += 10;
                        }
                        break;
                    case 3:
                        if (objx -10>0){
                            objx -=10;
                        }
                        break;
                    case 4:
                        if (objx<550-objw){
                            objx +=10;
                        }
                        break;
                }
                lb.setLocation(objx,objy);
            }
        });

        for (int i= 0 ;i<6;i++){
            switch (i){
                case 0 :
                    jb[i] = new JButton("RUN");
                    jp1.add(jb[i]);
                    break;
                case 1 :
                    jb[i] = new JButton("↑");
                    jp1.add(jb[i]);
                    break;
                case 2 :
                    jb[i] = new JButton("↓");
                    jp1.add(jb[i]);

                    break;
                case 3 :
                    jb[i] = new JButton("←");
                    jp1.add(jb[i]);
                    break;
                case 4 :
                    jb[i] = new JButton("→");
                    jp1.add(jb[i]);
                    break;
                case 5 :
                    jb[i] = new JButton("Exit");
                    jp1.add(jb[i]);
                    break;
            }


            jb[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmp = (JButton) e.getSource();
                    switch (tmp.getText()){
                        case "RUN":
                            t.start();
                            break;
                        case "↑":
                            op=1;
                            break;
                        case "↓":
                            op=2;
                            break;
                        case "←":
                            op=3;
                            break;
                        case "→":
                            op=4;
                            break;

                    }
                }
            });

            jb[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_UP:
                            op=1;
                            break;
                        case KeyEvent.VK_DOWN:
                            op=2;
                            break;
                        case KeyEvent.VK_LEFT:
                            op=3;
                            break;
                        case KeyEvent.VK_RIGHT:
                            op=4;
                            break;
                        case KeyEvent.VK_F1:
                            JLabel l = new JLabel("11");
                            l.setSize(10,10);
                            l.setLocation(50,50);
                            jp2.add(l);
                    }
                }
            });
        }


    }
}
