package problem.asm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

public class DesignParser {
	
	public static ArrayList<ClassDataContainer> classData = new ArrayList<ClassDataContainer>();
	
	public static void main(String[] args) throws IOException {
		
		PrintWriter outputStream = new PrintWriter("Stankfile.txt");
		Charset charset = Charset.forName("US-ASCII");
		outputStream.println("digraph Stankfile{");
		outputStream.println("rankdir=BT;");
		
		String[] st = new String[3];
		
		//;
		
		//System.out.println("arg classtype: " + st.getClass().toString());
		//System.out.println("arg classtype: " + args[3].getClass().toString());
		
		
		for(String className: args) {
			// put multiple names in the run configurations
			// or recursively look up classes and parse them
			// Save the information in a seperate object like a differe class as an example and then print
			// everything out at once when you are ready to
			ClassReader reader = new ClassReader(className);
			
			System.out.println("Reader Class: " + reader.getClass());
			
			//System.out.println("is interface? "+ className.getClass().toString());
			//System.out.println("classname: ");			
				
			ClassDeclarationVisitor declVisitor = new ClassDeclarationVisitor(Opcodes.ASM5);
			System.out.println(declVisitor.getClass().toString());
			ClassFieldVisitor fieldVisitor = new ClassFieldVisitor(Opcodes.ASM5,
					declVisitor);
			ClassMethodVisitor methodVisitor = new ClassMethodVisitor(Opcodes.ASM5,
					fieldVisitor);

			reader.accept(methodVisitor, ClassReader.EXPAND_FRAMES);
			
			ClassDataContainer newClassData = new ClassDataContainer(outputStream, declVisitor, fieldVisitor, methodVisitor);
			 classData.add(newClassData);
			 //System.out.println("I added a new class to the classData arraylist: " + declVisitor.nameGlobal);
			 

		}
		//System.out.println("class data size is: " + classData.size());
		for(int k = 0; k < classData.size();k++) {
			classData.get(k).printInformation();
		}
		//OutputStream one = new OutputStream();
		
		//System.out.println(outputStream.equals(outputStream));
		
		outputStream.println("}");
		System.out.println("Your file has been converted!");
		outputStream.close();
	}
}
