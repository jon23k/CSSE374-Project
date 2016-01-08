package problem.asm;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

import junit.framework.Assert;

public class AutomatedUMLTester {
	FileInputStream generatedFile;
	FileInputStream comparatorFile;
	boolean compareFlag = true;
	
	File genFile = new File("Stankfile.txt");
	File compFile = new File("StupidFile.txt");

	@Test
	public void test() throws IOException {
		//fail("Not yet implemented");
		//f1.getAbsolutePath();
		generatedFile = new FileInputStream(genFile.getAbsolutePath());
		comparatorFile = new FileInputStream(compFile.getAbsolutePath());
		
		System.out.println(generatedFile);
		
		DataInputStream di1=new DataInputStream(generatedFile);
		BufferedReader br1=new BufferedReader(new InputStreamReader(di1));
		DataInputStream di2=new DataInputStream(comparatorFile);
		BufferedReader br2=new BufferedReader(new InputStreamReader(di2));
		String s1, s2;
		
		while ((s1=br1.readLine())!=null && (s2=br2.toString())!=null) {
			if(!s1.equals(s2)){
				compareFlag = false;
			}
		}
		
		System.out.println(compareFlag);
		assertTrue(compareFlag);
	}

}
