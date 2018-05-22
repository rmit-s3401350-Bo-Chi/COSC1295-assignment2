package view;
/*
 * ***@author bo chi
 */
import java.awt.BorderLayout;

import java.awt.Checkbox;
import java.awt.Container;
import javax.swing.event.ChangeEvent;
import lib.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;
import lib.*;
public class ConnectPerson extends JFrame{
	
	JFrame CP = new JFrame();
	JLabel titleC;
	JLabel iname;
	JLabel iname2;
	JLabel Crelation;
	JButton ConnectTwoPerson;
	JButton BackToMenu;
	JButton reset;
	static JTextField tname;
	static JTextField tname2;
	JCheckBox CList;
	JCheckBox CList2;
	JPanel ConnectPerson;
    JCheckBox CList3;
	JCheckBox CList4 ;
	private JTextArea CResult;
	

	public ConnectPerson(){
		init();
		CP.setSize(800,620);
		CP.setVisible(true);
		CP.setResizable(false);
		CP.setLocationRelativeTo(null);
		
} 


	void init() {
		Container interfaceConnectPerson = CP.getContentPane();
		ConnectPerson = new JPanel();
		//title
		titleC = new JLabel("CONNECT PRESON");
		titleC.setFont(new Font("Algerian", Font.PLAIN, 20));
		// word
		iname = new JLabel("please input the name:");
		iname2 = new JLabel("please input the name :");
		// put area
		tname = new JTextField();
		tname2 = new JTextField();
		// out area
		CList = new JCheckBox();
		CList.setText("friend");

		CList2 = new JCheckBox("Parent");		
		CList3 = new JCheckBox("Colleague");		
	    CList4 = new JCheckBox("Classmate");		
		
		//relation
		Crelation = new JLabel("Relation:");
		//button
		ConnectTwoPerson = new JButton("ConnectTwoPerson");
		
		reset = new JButton("reset");
		
	 
		 
		CList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				PrintJTextArea();
				CResult.append("\nFriend");
				int i = Integer.parseInt(Driver.Personage(tname.getText()));
				int j = Integer.parseInt(Driver.Personage(tname2.getText()));
				try {
				if(i<3||j<3) {
					throw new TooYoungException();
					}
				}catch(TooYoungException t) {
					t.printStackTrace();
				}
			}
			
		});
		CList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintJTextArea();
				CResult.append("\nParent");
				int i = Integer.parseInt(Driver.Personage(tname.getText()));
				int j = Integer.parseInt(Driver.Personage(tname2.getText()));
				try {
					if(i<17||j<17) {
						throw new NoToBeCoupledException();
						}
					}catch(NoToBeCoupledException t) {
						t.printStackTrace();
					}
			}
			
		});
		CList3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintJTextArea();
				CResult.append("\nColleague");
				int i = Integer.parseInt(Driver.Personage(tname.getText()));
				int j = Integer.parseInt(Driver.Personage(tname2.getText()));
				try {
					if(i<17||j<17) {
						throw new NoToBeClassmatesException();
						}
					}catch(NoToBeClassmatesException t) {
						t.printStackTrace();
					}
			}
			
		});
		CList4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintJTextArea();
				CResult.append("\nClassmate");
				int i = Integer.parseInt(Driver.Personage(tname.getText()));
				int j = Integer.parseInt(Driver.Personage(tname2.getText()));
				try {
				if(i<3||j<3) {
					throw new NoToBeClassmatesException();
					}
				}catch(NoToBeClassmatesException t) {
					t.printStackTrace();
				}
			}
			
		});
		//button action
		ConnectTwoPerson.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	String name1 = tname.getText();
	        	String name2 = tname2.getText();
	           
	
				if(name1.equals("")) {
	        		JOptionPane.showMessageDialog(null, "No Name or Name ERROR!¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);
	        	}
             	else if(name2.equals("")) {
	        		JOptionPane.showMessageDialog(null, "No Name or Name ERROR!¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);
	        	}
             	else if (name1 == name2) {
	        		JOptionPane.showMessageDialog(null, "No Name or Name ERROR!¨r(¨s¨Œ¨t)¨q","ERROR",JOptionPane.ERROR_MESSAGE);
	        	}
             	 
				 
	        	try {
	        	
	        	File file=new File("..\\Assigenment2\\src\\database\\relations.txt");
	        	file.createNewFile();
				if(CList.isSelected()) {	
					writeToTxt(file,name1 +" "+ name2 +" "+ " friend");	 
					Driver.fmapput(name1,name2);
	        	} 
             	if(CList2.isSelected()) {
             		writeToTxt(file,name1 +" "+ name2 +" "+ " Parent");	
             		Driver.pmapput(name1, name2);
	        	}
             	if (CList3.isSelected()) {
             		writeToTxt(file,name1 +" "+ name2 +" "+ " Colleague");	
             		Driver.comapput(name1,name2);
	        	}
             	if (CList4.isSelected()) {
             		writeToTxt(file,name1 +" "+ name2 +" "+ " Classmate");    
             		Driver.clmapput(name1,name2);
	        	}
             	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	new FinalConfirm();
	        }
		 });
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                tname.setText("");
	                tname.setText("");
	          
	         }
	     });
		
		//position
		ConnectPerson.setLayout(null);
		ConnectPerson.add(titleC);
		ConnectPerson.add(iname);
		ConnectPerson.add(iname2);
		ConnectPerson.add(tname);
		ConnectPerson.add(tname2);
		ConnectPerson.add(CList);
		ConnectPerson.add(ConnectTwoPerson);		
		ConnectPerson.add(reset );
		ConnectPerson.add(Crelation);
		ConnectPerson.add(CList2);
		ConnectPerson.add(CList3);
		ConnectPerson.add(CList4);
		
		titleC.setBounds(298, 23,197, 18);
		iname.setBounds(51, 81, 195, 18);
		iname2.setBounds(51, 158, 195, 18);
		tname.setBounds(434, 78, 182, 24);
		tname2.setBounds(434, 155, 182, 24);
		ConnectTwoPerson.setBounds(446, 522, 231, 27);
		//BackToMenu.setBounds(603, 522, 113, 27);
		reset.setBounds(54, 522, 129, 27);
		CList.setBounds(80,270,106,24);
		Crelation.setBounds(51, 234, 132,27);
		CList2.setBounds(311, 269, 133, 27);
		CList3.setBounds(311, 330, 133, 27);
		CList4.setBounds(80, 330, 133, 27);
		
		interfaceConnectPerson.add(ConnectPerson,BorderLayout.CENTER);
		
		CResult = new JTextArea();
		CResult.setText("result");
		CResult.setBounds(91, 378, 523, 88);
		ConnectPerson.add(CResult);
		
			
				
		
		}
	public static void writeToTxt(File path,String content) throws IOException{
	    FileWriter writer = new FileWriter(path, true);
	    writer.write(content);
	    writer.close();
	}
	
	
	protected void PrintJTextArea() {	  
		  CResult.setText("");
          CResult.append("\n name£º " + tname.getText());
          CResult.append("\n name£º " + tname2.getText());
	  }
	  


	
}