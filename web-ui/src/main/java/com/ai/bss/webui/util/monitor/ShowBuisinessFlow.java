package com.ai.bss.webui.util.monitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.mri.ShowAxonFlow;

import net.sourceforge.plantuml.SourceStringReader;

public class ShowBuisinessFlow {

	public static void ShowBuisinessFlow(String method,PrintStream printStream) throws Exception{
		File spooned=new File("spooned");
		if (spooned.exists()){
			deleteFile(spooned);
		}
		List<String> source=new ArrayList<String>();
		source.add("../");
		ShowAxonFlow showAxonFlow=new ShowAxonFlow(null,new File("../flow.classpath"),source,method,printStream);
		showAxonFlow.doMain();		
	}
	
	private static void deleteFile(File file) throws Exception {
		if (file.exists()&&file.isDirectory()){
			for (File c : file.listFiles())
				deleteFile(c);			
		}
		if (!file.delete()){
			throw new Exception("Spooned directory not deleted ");
		}
	}
	
	 public static void main(String[] args) throws Exception {
		 File flowtxtfile=new File("../flw.txt");
		 File png = new File("../flow.png");
		 PrintStream printStream=new PrintStream(flowtxtfile);
		 ShowBuisinessFlow.ShowBuisinessFlow("createIndividualCustomer",  printStream);
		 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("../flw.txt")));
		 String data = null;
		 String xmlTxt="";
		 while((data = br.readLine())!=null)
		 {
			 xmlTxt+=data+"\n"; 
		 }
		 SourceStringReader reader = new SourceStringReader(xmlTxt);
		 String desc = reader.generateImage(png);
	 }

}
