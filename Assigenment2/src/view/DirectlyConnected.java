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
public class DirectlyConnected extends JFrame {

//	private static final long serialVersionUID = 934315190662143757L;
	JFrame DC = new JFrame();
	JLabel iname;
	JLabel iname2;
	JLabel title1;
	JButton checkrelation;
	JButton BackToMenu;
	JButton reset;
	JTextArea putoutThings;
	static JTextField tname;
	static JTextField tname2;
	JPanel DirectlyConnected;


public DirectlyConnected(){
	init();
	DC.setSize(800,620);
	DC.setVisible(true);
	DC.setResizable(false);
	DC.setLocationRelativeTo(null);
	
}
void init() {
	Container interfaceDirectlyConnected = DC.getContentPane();
	DirectlyConnected = new JPanel();
	title1 = new JLabel("DIRECT CONNECT PERSON");
	title1.setFont(new Font("Algerian", Font.PLAIN, 20));
	iname = new JLabel("please input the name:");
	iname2 = new JLabel("Result:");
	tname = new JTextField();
	tname2 = new JTextField();
	checkrelation = new JButton("Checkrelation");
	BackToMenu = new JButton("Menu");
	reset = new JButton("reset");
	putoutThings = new JTextArea();
	
	//button action
	checkrelation.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	putoutThings.append(Driver.RelationCheck(tname.getText(),tname2.getText()));
          }
         
    });
	BackToMenu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	DC.dispose();
         }
     });
	
	
	reset.addActionListener(new ActionListener() {
        

		public void actionPerformed(ActionEvent e) {
                tname.setText(" ");
                tname2.setText(" ");
                putoutThings.setText(" ");
          
         }
     });
	
	
	//position
	DirectlyConnected.setLayout(null);
	DirectlyConnected.add(title1);
	DirectlyConnected.add(iname);
	DirectlyConnected.add(iname2);
	DirectlyConnected.add(tname);
	DirectlyConnected.add(tname2);
	DirectlyConnected.add(checkrelation);
	DirectlyConnected.add(BackToMenu);
	DirectlyConnected.add(reset );
	DirectlyConnected.add(putoutThings);
	
	
	title1.setBounds(276, 13, 282, 18);
	iname.setBounds(33, 65, 198, 18);
	iname2.setBounds(33, 174, 198, 18);
	tname.setBounds(73, 112, 158, 24);
	tname2.setBounds(337, 112, 168, 24);
	checkrelation.setBounds(586, 111, 148, 27);
	BackToMenu.setBounds(611, 522, 113, 27);
	reset.setBounds(54, 522, 120, 27);
	BackToMenu.setBounds(611, 522, 113, 27);
	putoutThings.setBounds(91, 219, 617, 235);
	
	interfaceDirectlyConnected.add(DirectlyConnected,BorderLayout.CENTER);
}
}
