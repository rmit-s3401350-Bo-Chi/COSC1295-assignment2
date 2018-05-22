package view;
/*
 * ***@author bo chi
 */

import lib.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Mininet {
	
	JFrame CL =new JFrame();
	static JLabel menu ;
	JPanel all;
	JButton option1;
	JButton option2;
	JButton option3;
	JButton option4;
	JButton option5;
	JButton option6;
	
	public Mininet() {
		init();
		CL.setSize(800,620);
		CL.setVisible(true);
		CL.setResizable(false);
		CL.setLocationRelativeTo(null);
		CL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		option1 = new JButton("Add a person into the network");
		option2= new JButton("Select a person");
		option3 = new JButton("List everyone");
		option4 = new JButton("Connect two persons");
		option5 = new JButton("Are these two have directly relation ? ");
		option6 = new JButton("Exit");
		menu = new JLabel("Minnet Menu");
	// action
		
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addPerson();
			}
		});
		
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectPerson();
			}
			
		});
		
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListPerson();
				
				
			}
			
		});
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConnectPerson();
				
				
			}
			
		});
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DirectlyConnected();
					
			}
			
		});
		option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CL.dispose();
			}
			
		});
	
		
		

		    Container interfacechatroom = CL.getContentPane();
		    all=new JPanel();
	        all.setLayout(null);
	        all.add(menu);
	        all.add(option1);
	        all.add(option2);
	        all.add(option3);
	        all.add(option4);
	        all.add(option5);
	        all.add(option6);
	        
	        //起始X 起始Y 宽  高 
	        menu.setBounds(200,10,380,25);
	        option1.setBounds(200,70,380,25);
	        option2.setBounds(200,140,380,25);
	        option3.setBounds(200,210,380,25);
	        option4.setBounds(200,280,380,25);
	        option5.setBounds(200,350,380,25);
	        option6.setBounds(200,420,380,25);
	        
	        interfacechatroom.add(all,BorderLayout.CENTER);
	}
}

