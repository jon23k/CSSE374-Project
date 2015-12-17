package problem.asm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

public class DesignParser {
	public static void main(String[] args) throws IOException {
		for(String className: args) {
			ClassReader reader = new ClassReader(className);
			
			ClassDeclarationVisitor declVisitor = new ClassDeclarationVisitor(Opcodes.ASM5);
			ClassFieldVisitor fieldVisitor = new ClassFieldVisitor(Opcodes.ASM5,
					declVisitor);
			ClassMethodVisitor methodVisitor = new ClassMethodVisitor(Opcodes.ASM5,
					fieldVisitor);

			reader.accept(methodVisitor, ClassReader.EXPAND_FRAMES);
			
			try
			{
			 PrintWriter outputStream = new PrintWriter("Stankfile.txt");
			 Charset charset = Charset.forName("US-ASCII");
			 outputStream.println("digraph Stankfile{");
			 outputStream.println("rankdir=BT;");
			 
			 generateClassPrintSequence(outputStream, declVisitor, fieldVisitor, methodVisitor);

			 outputStream.println("}");
			 System.out.println("Your file has been converted!");
			 outputStream.close();
		    }   
			catch (FileNotFoundException e) 
			{
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 System.out.println("Your file was not found");
		    }
		}
	}
	
	public static void generateClassPrintSequence(PrintWriter outputStream, ClassDeclarationVisitor declVisitor,
			ClassFieldVisitor fieldVisitor, ClassMethodVisitor methodVisitor) {
		outputStream.println(declVisitor.nameGlobal + "[");
		outputStream.println("shape=\"record\", ");
		//outputStream.println(" label = \" {\<\<interface\>\> \n Subject|+ notifyObservers() : void\l}\" ");
		outputStream.print("label = \" ");
		//outputStream.print(" {\\<\\<interface\\>\\> \\n " );
		outputStream.print(declVisitor.nameGlobal + " | ");
		
		for(int i = 0; i < fieldVisitor.fields.size() - 2; i++) {
			outputStream.print(fieldVisitor.fields.get(i));
		}
		outputStream.print(fieldVisitor.fields.get(fieldVisitor.fields.size()-1) + "|");
		
		for(int i = 1; i < methodVisitor.methods.size() - 2; i++) {
			outputStream.print(methodVisitor.methods.get(i) + "\\l");
		}
		outputStream.print(methodVisitor.methods.get(methodVisitor.methods.size()-1) + "\\l}");
		outputStream.println("\"");
		outputStream.println("];");
		
		//WeatherData -> Subject [arrowhead="onormal", style="dashed"];
		// Extends
		outputStream.println(declVisitor.nameGlobal + " -> " + declVisitor.extendNameGlobal + "[arrowhead=\"onormal\", style=\"dashed\"] ");
		
		// Implements
		//for(int i = 1; i < declVisitor.implementers.size() - 1; i++) {
			//System.out.println(declVisitor.implementers.get(i).toString());
		outputStream.println(declVisitor.nameGlobal + " -> " + declVisitor.implementerNameGlobal + "[arrowhead=\"vee\", style=\"dashed\"] ");
		//}
		
		//outputStream.print("+ notifyObservers() : void \\l "); // We would need to print the method stuff
	}

}
