package view;
/*
 * ***@author bo chi
 */
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.Font;
import lib.*;
public class FinalConfirm {

	JFrame FC = new JFrame();;
	JButton Back;
	JPanel FinalConfirm;
	JLabel FinalText;
	
	
	public FinalConfirm() {
		init();
		FC.setSize(250,150);
		FC.setVisible(true);
		FC.setResizable(false);
		FC.setLocationRelativeTo(null);
	
	}
	void init() {
		Container interfaceFinalConfirm = FC.getContentPane();
		FinalConfirm = new JPanel();
		
		
		FinalText = new JLabel("Successful !");
		FinalText.setFont(new Font("Arial",Font.PLAIN,20));
		Back = new JButton("MENU");

		FinalConfirm.setLayout(null);
		FinalConfirm.add(FinalText);
		FinalConfirm.add(Back);
		
		
   //action
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Confirm.confirmclose();
				FC.dispose();
			}
		});
		
		FinalText.setBounds(66, 24, 113, 27);
		Back.setBounds(77, 64, 89, 27);
		
		
		
		interfaceFinalConfirm.add(FinalConfirm,BorderLayout.CENTER);
	}

}
