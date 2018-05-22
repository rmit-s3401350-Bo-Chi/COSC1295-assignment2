package view;
/*
 * ***@author qiaoxi li
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.Font;
import lib.*;

public class ListPerson extends JFrame {
	
	File f1;
	BufferedReader in = null;
	JButton BackList;
	JLabel ListPeople;
	JPanel ListPersonall;
	JTextArea Listshow;
	
	public ListPerson() {
		init();
		setSize(800,620);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	
	}
	void init() {
		Container interfaceListPerson = getContentPane();
		ListPersonall = new JPanel();
		
		ListPeople = new JLabel("THE PERSON LIST");
		ListPeople.setFont(new Font("Algerian", Font.PLAIN, 20));
		BackList = new JButton("List all");
		Listshow = new JTextArea();
	// action
		BackList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {    
                    String encoding = "GBK"; // 字符编码(可解决中文乱码问题 )    
                    File file = new File("D:\\eclipse\\Assigenment2\\people(2).txt");    
                     if (file.isFile() && file.exists()) {    
                       InputStreamReader read = new InputStreamReader(    
                                new FileInputStream(file), encoding);    
                        BufferedReader bufferedReader = new BufferedReader(read);    
                        String lineTXT = null;    
                         while ((lineTXT = bufferedReader.readLine()) != null) {    
                           //   System.out.println(lineTXT.toString().trim());
                              Listshow.setText(lineTXT.toString().trim());
           
                         }    
                         read.close();    
                    }else{    
                    	JOptionPane.showMessageDialog(null, "No information!╮(╯▽╰)╭","ERROR",JOptionPane.ERROR_MESSAGE);   
                    }    
                } catch (Exception f) {    
                	JOptionPane.showMessageDialog(null, "No information!╮(╯▽╰)╭","ERROR",JOptionPane.ERROR_MESSAGE);   
                    f.printStackTrace();    
                } 
            	Driver.Personout(Listshow);
            }      	
                         
        });
		
		
		//position
		ListPersonall.setLayout(null);
		ListPersonall.add(BackList);
		ListPersonall.add(ListPeople);
		ListPersonall.add(Listshow);
		
		
		
		ListPeople.setBounds(324, 42, 168, 27);
		Listshow.setBounds(47, 100, 699, 416);
		BackList.setBounds(342, 545, 113, 27);
		
		
		interfaceListPerson.add(ListPersonall,BorderLayout.CENTER);
		
		
		
	}
	
}
