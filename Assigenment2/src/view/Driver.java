package view;
/*
 * ***@author bo chi
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JTextArea;
import lib.*;
public class Driver {
	static Map<String,String> friendmap = new HashMap<>();
	static Map<String,String> parentmap = new HashMap<>();
	static Map<String,String> colleaguemap = new HashMap<>();
	static Map<String,String> classmatemap = new HashMap<>();
	static Map<String,String> Personmap= new HashMap<>();
	static Map<String,String> Personothers= new HashMap<>();
	
	public static void fmapput(String s,String t) {
		friendmap.put(s,t);
	}
	public static void pmapput(String s,String t) {
		parentmap.put(s,t);
	}
	public static void comapput(String s,String t) {
		colleaguemap.put(s,t);
	}
	public static void clmapput(String s,String t) {
		classmatemap.put(s,t);
	}
	public static void Personmapput(String s,String t) {
		Personmap.put(s,t);
	}
	public static void Personothersput(String s,String t) {
		Personothers.put(s,t);
	}
	////////main funcation
	public static String RelationCheck(String s,String t) {
		String s1 = null ;
		int mark = 0;
		try {
		if(friendmap.get(s).equals(t)||friendmap.get(t).equals(s)) {
			mark =1 ;
		}
		}catch(Exception e) {}
		try {
		if(parentmap.get(s).equals(t)||parentmap.get(t).equals(s)) {
			mark = 2 ;
		}
		}catch(Exception e) {}
		try {
		if(colleaguemap.get(s).equals(t)||colleaguemap.get(t).equals(s)) {
			mark = 3 ;
		}
		}catch(Exception e) {}
		try {
		if(classmatemap.get(s).equals(t)||classmatemap.get(t).equals(s)) {
			mark = 4 ;
		}
		}catch(Exception e) {}
		switch(mark) {
		case 1: s1 = "Friend"; break;
		case 2: s1 = "Parent"; break;
		case 3: s1 = "Colleagus"; break;
		case 4: s1 = "Classmate"; break;
		}
		return "They are "+s1;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	public static String SelectPerson(String s) {
		return s +" "+ Personmap.get(s)+" "+Personothers.get(s);/////////////////////////////////
	}
	public static void deletePerson(String s) {
		Personmap.remove(s);
		Personothers.remove(s);
	}
	public static void Personout(JTextArea TA) {
		Iterator iter = Personmap.entrySet().iterator();  
        while (iter.hasNext()) {  
            Map.Entry entry = (Map.Entry) iter.next();  
            Object key = entry.getKey();  
            Object value = entry.getValue();  
            TA.append(key+" "+value+" "+Personothers.get(key)+"\n");///////////////////////////////////
        }  
	}
	
	public static void MaptoTxt(File path,Map<String, String> hmap) throws IOException{
		FileWriter writer = new FileWriter(path, false);//////////////////////////////////////////////
		Iterator iter = hmap.entrySet().iterator();  
        while (iter.hasNext()) {  
            Map.Entry entry = (Map.Entry) iter.next();  
            Object key = entry.getKey();  
            Object value = entry.getValue();  
            writer.write(key+" "+value+" "+Personothers.get(key)+" ");
            
        }  
        writer.close();
	}

	public static String Personage(String s) {
		return  Personmap.get(s);
	}
}

