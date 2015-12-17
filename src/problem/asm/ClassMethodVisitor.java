package problem.asm;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class ClassMethodVisitor extends ClassVisitor {
	
	public int access;
	public String name;
	public String desc;
	public String signature;
	public String[] exceptions;
	public ArrayList<String> methods = new ArrayList<String>();


	public ClassMethodVisitor(int arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ClassMethodVisitor(int arg0, ClassVisitor arg1) {
		super(arg0, arg1);
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		
		MethodVisitor toDecorate = super.visitMethod(access, name, desc, signature, exceptions);
		
		String returnType = Type.getReturnType(desc).getClassName();
		
		Type[] argTypes = Type.getArgumentTypes(desc);
		
		List<String> stypes = new ArrayList<String>();
		for(Type t: argTypes) {
			stypes.add(t.getClassName());
		}
		
		String symbol = "";
		if((access & Opcodes.ACC_PUBLIC) != 0) {
			symbol = "+";
		}
		
		String line = symbol + " " + name + "()" + " : " + returnType;
		//System.out.println(line);
		methods.add(line);
		
		//System.out.println("    method " + symbol + " " + returnType + " " + name + " " + stypes.toString());
		//System.out.println(symbol + " " + name + "()" + " " + returnType);
		
		return toDecorate;
	}

}
