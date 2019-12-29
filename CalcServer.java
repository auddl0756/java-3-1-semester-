package termp0_91;

import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CalcServer{
   public static void main(String[] args) {
      Socket socket1=null;
      ServerSocket server;
      try {
         server = server=new ServerSocket(7777);
      
         System.out.println("서버:클라이언트 요청 대기 중... ...");
         while(true) {
            socket1=server.accept();
            System.out.println("서버: accpeted");
            Runnable temp_thread = new Server_service(socket1);
            Thread server_thread = new Thread(temp_thread);
            server_thread.start();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
class Server_service implements Runnable{
   Socket socket;
   Server_service(Socket incoming){
      socket = incoming;
   }
   public void run() {
   
      ObjectOutputStream oos=null;
      ObjectInputStream ois=null;
      ArrayList<Map <String,String>> map_book;
      Map <String,String> getmap = new HashMap <>();
     // Set<Map.Entry<String, String>> getset;
      
      try {
 
         ois=new ObjectInputStream(socket.getInputStream());
         oos=new ObjectOutputStream(socket.getOutputStream());
         
         if((map_book=(ArrayList<Map<String,String>>)ois.readObject())!=null) {
            
            System.out.println("맵 수신완료");
            System.out.println("getmap's elements"+getmap.get("a1"));
            oos.writeObject(new Solution(map_book));
           
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