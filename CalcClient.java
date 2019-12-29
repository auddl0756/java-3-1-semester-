package termp0_91;

import java.util.*;
import java.awt.Frame;
import java.awt.Panel;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;

public class CalcClient {
   public static void main(String[] args) {
      Socket socket=null;
      ObjectOutputStream oos=null;
      ObjectInputStream ois=null;
      ArrayList<Map <String,String>> Equal_a = null;
      Solution b = null;
       boolean done =  true;
      try {
         Calc x=new Calc();
      
         while(done) {
            if(!x.send_eq()) {
               Thread.sleep(1400);
               System.out.println("Yet send");
               continue;
            }
            else {
               System.out.println("gui send");
               Equal_a = x.getField();
               done = false;
            }
         }
      
         socket=new Socket("127.0.0.1",7777);
         System.out.println("서버에 접속 성공");
         
         oos=new ObjectOutputStream(socket.getOutputStream());
         ois=new ObjectInputStream(socket.getInputStream());
       
         oos.writeObject(Equal_a);
        
         System.out.println("맵 전송 완료..");
         if((b =(Solution)ois.readObject()) !=null) {
            
            System.out.println("최종완료");
            b.run();
         }
   
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            socket.close();
            System.out.println("종료");
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
}