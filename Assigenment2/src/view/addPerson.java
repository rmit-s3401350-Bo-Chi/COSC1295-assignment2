package view;
/*
 * ***@author bochi
 */
import java.util.*;

import lib.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import lib.*;


public class addPerson {
	
	JFrame aP = new JFrame();
	JLabel iname ;
	JLabel iage;
	JLabel atitle;
	JLabel aotherinfo;
	JButton confirm;
	JButton reset;
	JButton menu;
	static JTextField tname;
	static JTextField tage;
	static JTextField tother;
	JPanel addPersonall;
	static JTextField Istate;
	
	public addPerson(){
		init();
		aP.setSize(800,620);
		aP.setVisible(true);
		aP.setResizable(false);
		aP.setLocationRelativeTo(null);
	}
	void init() {
		
		Container interfaceaddPerson = aP.getContentPane();
		addPersonall =new JPanel();
		atitle = new JLabel("ADD PERSON ");
		atitle.setFont(new Font("Algerian", Font.PLAIN, 20));
		iname = new JLabel("Please input name :");
		iage = new JLabel("Please input age :");
		aotherinfo = new JLabel("Please input gender(F or M :");
		tname = new JTextField();
		tage = new JTextField();
		tother = new JTextField();
		confirm = new JButton("Confirm");
		reset = new JButton("Reset");
		menu = new JButton("MENU");
	    
		 
		
		
		//button action
		confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
              String namestr = tname.getText();
              String otherstr = tother.getText( );
              String agestr = tage.getText();
              String istate = Istate.getText();
             
           
              int age = Integer.parseInt(agestr);

              if(namestr.equals("")) {
            	  JOptionPane.showMessageDialog(null, "No Name or Name ERROR!¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE); 
              }else if(namestr.equals("[0-9]")) {
            	 JOptionPane.showMessageDialog(null, " Name error!¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);       	  
              }
              else if( age<0 ||age>150 ) {
            	  new NoSuchAgeException();
              }
              
              else if(otherstr.equals(""))  {
            	  JOptionPane.showMessageDialog(null, "No information!¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);
              }
              else if(otherstr.equals("/^[FM]*$/"))  {
            	  JOptionPane.showMessageDialog(null, "no information !¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);
              }else if (istate.equals("\"[a-zA-Z ]*$/\"")) {
            	  JOptionPane.showMessageDialog(null, "¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);
              }else if(istate.equals("vic") || istate.equals("act") || istate.equals("nsw")|| istate.equals("qld") || istate.equals("wa") || istate.equals("tas")) {
            	  JOptionPane.showMessageDialog(null, "MUST INPUT state name like VIC¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);
              }
              else {        	
            	  new Confirm();
            	  }     
              }
            }
	   );
		reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               tname.setText("");
               tage.setText("");
               tother.setText("");
               Istate.setText("");
             }
         });
		
		
		menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		File file=new File("..\\Assigenment2\\src\\database\\people.txt");
		
		try {
			Driver.MaptoTxt(file,Driver.Personmap);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		aP.dispose();
		
            }
        });
	
	    addPersonall.setLayout(null);
		addPersonall.add(atitle);
		addPersonall.add(iname);
		addPersonall.add(iage);
		addPersonall.add(aotherinfo);
		addPersonall.add(tname);
		addPersonall.add(tage);
		addPersonall.add(tother);
		addPersonall.add(confirm);
		addPersonall.add(reset);
		addPersonall.add(menu);
		
		atitle.setBounds(298, 23,197, 18);
		iname.setBounds(200,86,380,25);
		iage.setBounds(200,194,380,25);
		aotherinfo.setBounds(200, 296, 272, 40);
		tother.setBounds(416, 304, 164, 25);
		tname.setBounds(200,141,380,25);
		tage.setBounds(200,248,380,25);
		confirm.setBounds(200,450,100,25);
		reset.setBounds(350,450,100,25);
		menu.setBounds(550,450,100,25);
		
		interfaceaddPerson.add(addPersonall,BorderLayout.CENTER);
		
		JLabel InputState = new JLabel("Please input state :");
		InputState.setBounds(200, 368, 172, 32);
		addPersonall.add(InputState);
		
		Istate = new JTextField();
		Istate.setBounds(416, 371, 164, 25);
		addPersonall.add(Istate);
		Istate.setColumns(10);
	
	}
	
	public static String getname() {
		return tname.getText();
	}
	public static String getothers() {
		return tother.getText();
	}
	public static String getage() {
		return tage.getText();
	}
	public static String getinputstate() {
		return tage.getText();
	}
}
