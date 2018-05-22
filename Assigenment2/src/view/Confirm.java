package view;
/*
 * ***@author qiaoxi li
 */
import lib.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.Font;

public class Confirm  {
	
	static JFrame CF = new JFrame();
	JButton confirmall;
	JButton cancel;
	JLabel ConfirmText;
	JPanel Confirm;
	
	
	public Confirm() {
		init();
		CF.setSize(400,300);
		CF.setVisible(true);
		CF.setResizable(false);
		CF.setLocationRelativeTo(null);
	
	}
	void init() {
		
		Container interfaceConfirm = CF.getContentPane();
		Confirm = new JPanel();
		
		
		 ConfirmText = new JLabel("PLEAZE CONFIRM");
		 ConfirmText.setFont(new Font("Algerian", Font.BOLD, 22));
		 confirmall = new JButton("confirm");
		 cancel = new JButton("reset");
		
		
		confirmall = new JButton("Confirm");
		cancel = new JButton("Reset");
		
		
		
		Confirm.setLayout(null);
		Confirm.add(ConfirmText);
		Confirm.add(confirmall);
		Confirm.add(cancel);
		
		
		
		//action
		
		confirmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				new FinalConfirm();
				Driver.Personmapput(addPerson.getname(),addPerson.getage());
				Driver.Personothersput(addPerson.getname(),addPerson.getothers());
			}
		});
		
	       cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CF.dispose();
			}
		});
	       
	       
	       
	       
	  //position     
		cancel.setBounds(138, 202, 109, 38);
		ConfirmText.setBounds(99, 58, 205, 48);
		confirmall.setBounds(138, 138, 109, 38);

	  interfaceConfirm.add(Confirm,BorderLayout.CENTER);	
	}
	
	public static void confirmclose() {
		CF.dispose();
	}
	
}
