package termp0_91;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Calc extends JFrame implements Serializable, ActionListener {
   private final JFrame frame;
   private final JPanel primaryPanel, subPanel1, subPanel2;
   private JTextField t1, t2; // 1차식 계수 받는 용도
   private JTextField t3, t4, t5; // 2차식 계수 받는 용도
   private JButton sendButton,addButton;
   private JLabel label_eq1, label_eq1_1, label_eq1_2; // ax+b=0의 a,b
   private JLabel label_eq2, label_eq2_1, label_eq2_2, label_eq2_3; // ax^2+bx+c=0의 a,b,c
   
   private ArrayList <Map<String,String>>equ_book = new ArrayList<>();
   
   private boolean send_eq =false;
   public void actionPerformed(ActionEvent ae) {
     Map<String,String> m =new HashMap<>();   //map For Coefficient
      JButton getbutton=new JButton();
      getbutton=(JButton)ae.getSource();
      if(getbutton.getText().equals("send")) {
         System.out.println("맵에 저장 완료");
          //getbutton.setText("sended"); 
         send_eq = true;
      }
      else {
         send_eq = false;
         if(getbutton.getText().equals("add")) {
            m.clear();
            m.put(label_eq1_1.getText(), t1.getText());
             m.put(label_eq1_2.getText(), t2.getText());
             m.put(label_eq2_1.getText(), t3.getText());
             m.put(label_eq2_2.getText(), t4.getText());
             m.put(label_eq2_3.getText(), t5.getText());
             equ_book.add(m);
         }
      }
   }

   Calc() {
      frame = new JFrame("calculation problem");
      setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
      
      primaryPanel = new JPanel();
      primaryPanel.setBackground(Color.black);
      //primaryPanel.setPreferredSize(preferredSize);
      subPanel1 = new JPanel();
      subPanel2 = new JPanel();
      subPanel1.setPreferredSize(new Dimension(400, 300));
      subPanel2.setPreferredSize(new Dimension(400, 300));
      subPanel1.setBackground(Color.white);
      subPanel2.setBackground(Color.white);

      subPanel1.setLayout(new GridLayout(15, 15));
      subPanel2.setLayout(new GridLayout(15, 15));
      
      label_eq1 = new JLabel("ax+b=0 (1st order equation)");
      label_eq1_1 = new JLabel("a1: ");
      label_eq1_2 = new JLabel("b1: ");
      label_eq1.setFont(new Font("Arial",Font.BOLD,20));
      label_eq2 = new JLabel("ax^2+bx+c=0 (2nd order equation)");
      label_eq2.setFont(new Font("Arial",Font.BOLD,20));
      
      label_eq2_1 = new JLabel("a2: ");
      label_eq2_2 = new JLabel("b2: ");
      label_eq2_3 = new JLabel("c2: ");

      t1 = new JTextField("", 5);
      t2 = new JTextField("", 5);
      
      t3 = new JTextField("", 5);
      t4 = new JTextField("", 5);
      t5 = new JTextField("", 5);
      
      subPanel1.add(label_eq1);
      subPanel2.add(label_eq2);

      subPanel1.add(label_eq1);
      subPanel1.add(label_eq1_1);
      //subPanel1.add(label_eq1_1, t1);
      subPanel1.add(t1);
      subPanel1.add(label_eq1_2);
      subPanel1.add(t2);

      subPanel2.add(label_eq2);
      subPanel2.add(label_eq2_1);
      subPanel2.add(t3);
      subPanel2.add(label_eq2_2);
      subPanel2.add(t4);
      subPanel2.add(label_eq2_3);
      subPanel2.add(t5);
      
      primaryPanel.add(subPanel1);
      primaryPanel.add(subPanel2);
      sendButton=new JButton("send");
      addButton = new JButton("add");
      addButton.addActionListener(this);
      sendButton.addActionListener(this);
      subPanel2.add(sendButton);
      subPanel2.add(addButton);
      

   
      frame.getContentPane().add(primaryPanel);
      frame.setSize(1000, 800);
      frame.pack();
      frame.setVisible(true);
   }
   
   public ArrayList <Map<String,String>> getField(){
      return this.equ_book;
   }

   public boolean send_eq() {
      return send_eq;
   }
   

}


