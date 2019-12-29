package termp0_91;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;

import termp0_9.Solution_Panel;
import termp0_9.graph_panel;

import java.awt.*;
import java.util.*;

public class Solution extends JFrame implements Serializable{
	 
   private ArrayList<Map<String,String>> m_b;
   public Solution(ArrayList<Map<String,String>> a) {
       this.m_b = a;
       
   }
   public void run() {
	      final JFrame frame;
	      JTabbedPane tp = new JTabbedPane();
	       for(int i =0; i<m_b.size(); i++) {
	    	   if(m_b.get(i).isEmpty()) {
	    		   continue;
	    	   }else {
	    		   tp.addTab(Integer.toString(i+1), new Solution_Panel(m_b.get(i)));
	    		   tp.addTab(Integer.toString(i+1), new graph_panel(m_b.get(i)));
	    	   }
	    	   //this.repaint();
	       }
	       
	       
	      


	      
	       frame = new JFrame("solution");
	       frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	       frame.getContentPane().add(tp);
	       frame.pack();
	       frame.setVisible(true);
	   }
  
   
}

   


