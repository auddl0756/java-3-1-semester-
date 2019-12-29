package termp0_91;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Solution_Panel extends JPanel implements ActionListener{
	   private static final double NaN = 0;
	   private JPanel primaryPanel;
	   private JPanel subPanel1;
	      private JTextField t1,  t21,t22;   //1,2차식 해
	      private JTextField t2_2, t2_1; // 2차식 계수 받는 용도
	      private JButton sendButton;
	      private JLabel label_eq1, label_eq1_1, label_eq1_2; // ax+b=0의 a,b
	      private JLabel label_eq2, label_eq2_1, label_eq2_2, label_eq2_3; // ax^2+bx+c=0의 a,b,c
	      private Map<String,String> m  = new HashMap<>();   //map For Coefficient
	      boolean isImaginary1=false,isImaginary2=false;      //이차식에서 근이 허수인지 아닌지
	     
	      private JButton delete;
	      
	      public void actionPerformed(ActionEvent ae) {
	    	     //Map<String,String> m =new HashMap<>();   //map For Coefficient
	    	      JButton getbutton=new JButton();
	    	      getbutton=(JButton)ae.getSource();
	    	      if(getbutton.getText().equals("delete")) {
	    	    	 this.removeAll();
	    	    	 
	    	    	 //m_b.remove(o)
	    	    	 //tp.removeTabAt(1);
	    	         System.out.println("삭제완료");
	    	         
	    	      }
	    	     
	    	   }
	      
	      
	      
	      public Solution_Panel(Map<String,String> a) {
	         System.out.println("solution 생성자..");
	            this.m = a;
	            
	         label_eq1 = new JLabel(m.get("a1: ")+"x + " +m.get("b1: ")+"=0 (1st order equation)");
	         label_eq1_1 = new JLabel("x = ");
	         label_eq1.setFont(new Font("Arial",Font.BOLD,20));
	         label_eq2 = new JLabel(m.get("a2: ")+"x^2 + "+m.get("b2: ")+"x + "+m.get("c2: ")+"=0 (2nd order equation)");
	         label_eq2.setFont(new Font("Arial",Font.BOLD,20)); 
	         label_eq2_1 = new JLabel("x1 =  ");
	         label_eq2_2 = new JLabel("x2 =  ");
	         
	         delete=new JButton("delete");
	         delete.addActionListener(this);
	         
	         t1 = new JTextField(" ", 8);
	         t21= new JTextField(" ", 8);
	         t22= new JTextField(" ", 8);
	          t2_1 = new JTextField(" ",8);
	          t2_2 = new JTextField(" ", 8);
	          
	          double g1_1= Double.valueOf(m.get("a1: "));
	          double g1_2= Double.valueOf(m.get("b1: "));
	          double g2_1 = Double.valueOf(m.get("a2: "));
	          double g2_2 = Double.valueOf(m.get("b2: "));
	          double g2_3 = Double.valueOf(m.get("c2: "));
	          String imaginary="";
	          if(isImaginary1==true) {
	             System.out.println("hey???");
	             imaginary="j ";
	          
	          }
	          
	          
	          /*
	          t1.setText( imaginary +(equation_1(g1_1,g1_2)));
	          t21.setText( imaginary +(equation_2_1(g2_1,g2_2,g2_3)));
	          t22.setText( imaginary +(equation_2_2(g2_1,g2_2,g2_3)));
	          
	        
	          add (label_eq1);
	           add (label_eq1_1);
	           add (t1);
	           add (label_eq2);
	           add (label_eq2_1);
	           add (t21);
	           add (label_eq2_2);
	           add (t22);
	           add (delete);
	       
	           */
	          
	           setBackground (Color.white);
	           setPreferredSize (new Dimension(750, 480));

	   }
	      
	      

	public double equation_1(double a,double b){
	    if(a!=0) {         //최고차항 계수가 0이 아닐 때..
	    return -(b/a);
	    }
	    else                //최고차항 계수가 0일 때..
	       return NaN;
	 }
	 
	 public String equation_2_1(double a,double b,double c) {
	    SolutionDto dto;
	    isImaginary1=false;
	   Double t;
	    if(b*b -(4*a*c)>=0) {      //실수근일 때..
	       dto=new SolutionDto(-(b/(2*a)),Math.sqrt(((b*b)-(4*a*c))/(2*a)));
	       if(a!=0) {            //최고차항이 0이 아닐 때..
	          t=new Double(dto.get_real()+dto.get_imaginary());
	          return t.toString();
	       }
	       else                  //최고차항이 0일 때..
	          if(b!=0) {
	             t=new Double(-(c/b));
	             return t.toString();
	          }
	          else
	             return "NaN";
	    }
	    else {      //허수근일  때..
	       dto=new SolutionDto(-(b/(2*a)),Math.sqrt(-((b*b)-(4*a*c))/(2*a)));
	       isImaginary1=true;
	       if(a!=0)            //최고차항이 0이 아닐 때..
	          return dto.get_real()+" +j"+Math.abs(dto.get_imaginary());
	       else               //최고차항이 0일 때..
	          if(b!=0) {
	             t=new Double(-(c/b));
	             return t.toString();
	          }
	          else
	             return "NaN";
	    }
	 }
	 public String equation_2_2(double a,double b,double c) {
	    SolutionDto dto;
	    isImaginary2=false;
	    Double t;
	    if(b*b -(4*a*c)>=0) {   //실수근일 때..
	       dto=new SolutionDto(-b/(2*a),-Math.sqrt(((b*b)-(4*a*c))/(2*a)));
	       if(a!=0) {
	          t=new Double(dto.get_real()+dto.get_imaginary());
	          return t.toString();
	       }
	       else
	          if(b!=0) {
	             t=new Double(-(c/b));
	             return t.toString();
	          }
	          else
	             return "NaN";
	    }
	    else {      //허수근일  때..
	       dto=new SolutionDto(-b/(2*a),-Math.sqrt(-((b*b)-(4*a*c))/(2*a)));
	       isImaginary1=true;
	       if(a!=0)            //최고차항이 0이 아닐 때..
	          return dto.get_real()+" -j"+Math.abs(dto.get_imaginary());
	       else               //최고차항이 0일 때..
	          if(b!=0) {
	             t=new Double(-(c/b));
	             return t.toString();
	          }
	          else
	             return "NaN";
	    }
	 }

	}


class SolutionDto{
 private double realpart,imaginarypart;
 
 SolutionDto(double realpart,double imaginarypart){
    this.realpart=realpart;
    this.imaginarypart=imaginarypart;
 }
 
 public double get_real() {
    return this.realpart;
 }
 public double get_imaginary() {
    return this.imaginarypart;
 }
 
// public String toString() {
//    return this.realpart+"+"+this.imaginarypart;
// }
 
}

	 