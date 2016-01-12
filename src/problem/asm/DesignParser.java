package problem.asm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;


public class DesignParser {
	
	public static ArrayList<ClassDataContainer> classData = new ArrayList<ClassDataContainer>();	
	public static void main(String[] args) throws IOException {
		
		PrintWriter outputStream = new PrintWriter("Stankfile.txt");
		outputStream.println("digraph Stankfile{");
		outputStream.println("rankdir=BT;");
		
		for(String className: args) {
			// put multiple names in the run configurations
			// or recursively look up classes and parse them
			// Save the information in a seperate object like a differe class as an example and then print
			// everything out at once when you are ready to
			ClassReader reader = new ClassReader(className);
			System.out.println("Reader Class: " + reader.getClass());
			ClassDeclarationVisitor declVisitor = new ClassDeclarationVisitor(Opcodes.ASM5);
			System.out.println(declVisitor.getClass().toString());
			ClassFieldVisitor fieldVisitor = new ClassFieldVisitor(Opcodes.ASM5,
					declVisitor);
			ClassMethodVisitor methodVisitor = new ClassMethodVisitor(Opcodes.ASM5,
					fieldVisitor);
			reader.accept(methodVisitor, ClassReader.EXPAND_FRAMES);
			ClassDataContainer newClassData = new ClassDataContainer(outputStream, declVisitor, fieldVisitor, methodVisitor);
			 classData.add(newClassData);
		}
		getClassData(classData);
		for(int k = 0; k < classData.size();k++) {
			classData.get(k).printInformation();
		}		
		outputStream.println("}");
		System.out.println("Your file has been converted!");
		outputStream.close();
	}
	
	//Created this extra method so I could get the array of ClassDataContainers and test them.
	//DON'T DELETE THIS
	public static ArrayList<ClassDataContainer> getClassData(ArrayList<ClassDataContainer> classData)
	{
		return classData;
	}
	

	
}
