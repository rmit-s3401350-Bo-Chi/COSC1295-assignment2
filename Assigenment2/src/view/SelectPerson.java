package view;
/*
 * ***@author bo chi
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.Font;
import lib.*;

public class SelectPerson {
	
	JFrame SP = new JFrame();
	JLabel iname;
	JLabel iresult;
	JButton check;
	JButton BackToMenu;
	JButton DeletePerson;
	JTextArea ilist;
	static JTextField tname;
	JPanel SelectPersonall;
	
	
	public SelectPerson() {
		init();
		SP.setSize(800,620);
		SP.setVisible(true);
		SP.setResizable(false);
		SP.setLocationRelativeTo(null);
		
	}
	
	void init() {
		Container interfaceSelectPerson = SP.getContentPane();
		SelectPersonall = new JPanel();
		iname = new JLabel("please input the name:");
		iresult = new JLabel("result :");
		tname = new JTextField();
		check = new JButton("Check");
		BackToMenu = new JButton("Menu");
		ilist = new JTextArea();
		DeletePerson = new JButton("Delete selected person");
		DeletePerson.setForeground(Color.RED);
		
		// button action
		check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ilist.append(Driver.SelectPerson(tname.getText()));
              }
             
        });
		BackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SP.dispose();
             }
         });
		///////////////////////////////////////////////////////////////////////////////
		DeletePerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Driver.deletePerson(tname.getText());
            	File file=new File("D:\\eclipse\\Assigenment2\\relations(2).txt");
        		try {
        			Driver.MaptoTxt(file,Driver.Personmap);
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
             }
         });
		//////////////////////////////////////////////////////////////////////////////////
		
		//position
		
		SelectPersonall.setLayout(null);
		SelectPersonall.add(iname);
		SelectPersonall.add(iresult);
		SelectPersonall.add(tname);
		SelectPersonall.add(check);
		SelectPersonall.add(BackToMenu);
		SelectPersonall.add(ilist);
		SelectPersonall.add(DeletePerson );
		
		
		
		iname.setBounds(54, 63, 168, 18);
		tname.setBounds(150, 94, 325, 24);
		check.setBounds(526, 93, 113, 27);
		iresult.setBounds(54, 179, 72, 18);
		ilist.setBounds(154, 210, 485, 222);
		BackToMenu.setBounds(611, 522, 113, 27);
		DeletePerson.setBounds(54, 522, 217, 27);
		
		interfaceSelectPerson.add(SelectPersonall,BorderLayout.CENTER);
		
	
		
	}

}

