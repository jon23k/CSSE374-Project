package problem.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;

import problem.asm.ClassAssociationArrow;
import problem.asm.ClassDataContainer;
import problem.asm.ClassDeclarationVisitor;
import problem.asm.ClassFieldVisitor;
import problem.asm.ClassImplementsArrow;
import problem.asm.ClassInheritanceArrow;
import problem.asm.ClassMethodVisitor;
import problem.asm.ClassUsesArrow;

public class AssociationArrowTest {
	
	@Test
	public void test() throws IOException {
		PrintWriter outputStream = new PrintWriter("Stankfile.txt");
		String className = "javax.swing.Box";
		ClassReader reader = new ClassReader(className);

		ClassDeclarationVisitor declVisitor = new ClassDeclarationVisitor(Opcodes.ASM5,className);
		ClassInheritanceArrow inheritanceArrow = new ClassInheritanceArrow(Opcodes.ASM5, declVisitor);
		ClassImplementsArrow implementsArrow = new ClassImplementsArrow(Opcodes.ASM5, declVisitor);
		ClassFieldVisitor fieldVisitor = new ClassFieldVisitor(Opcodes.ASM5,
				declVisitor);
		ClassUsesArrow usesArrow = new ClassUsesArrow(Opcodes.ASM5, declVisitor);
		ClassMethodVisitor methodVisitor = new ClassMethodVisitor(Opcodes.ASM5, fieldVisitor);
		ClassAssociationArrow associationArrow = new ClassAssociationArrow(Opcodes.ASM5, fieldVisitor);


					
		ClassDataContainer newClassData = new ClassDataContainer(outputStream, declVisitor, fieldVisitor, methodVisitor,
				inheritanceArrow, implementsArrow, associationArrow, usesArrow);
		
		ClassAssociationArrow arrows = new ClassAssociationArrow(Opcodes.ASM5);
		
		reader.accept(inheritanceArrow, ClassReader.EXPAND_FRAMES);
		reader.accept(implementsArrow, ClassReader.EXPAND_FRAMES);
		reader.accept(methodVisitor, ClassReader.EXPAND_FRAMES);
		reader.accept(associationArrow, ClassReader.EXPAND_FRAMES);
		reader.accept(usesArrow, ClassReader.EXPAND_FRAMES);
		
		String answer = fieldVisitor.fields.toString();
		System.out.println(answer);
		
	}

}
