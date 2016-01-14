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
	public ArrayList<String> returnTypes = new ArrayList<String>();
	public ArrayList<String> argumentTypes = new ArrayList<String>();


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
			System.out.println(t.getClassName() + " this is the t.getClassname");
			if(t.getClassName().contains(".")) {
				String[] classNames = t.getClassName().split(".");
				stypes.add(classNames[classNames.length-1]);
			}
			else {
				stypes.add(t.getClassName());
			}
		}
		
		// This block prints out all the argument types for each method
		System.out.println("The argument types are: ");
		for(int k = 0; k < stypes.size() - 1;k++) {
			//System.out.println(stypes.get(k) + " ");
			if(argumentTypes.contains(stypes.get(k))){
				// do nothing
			}else {
				argumentTypes.add(stypes.get(k));
			}
		}
		
		String symbol = "";
		if((access & Opcodes.ACC_PUBLIC) != 0) {
			symbol = "+";
		}if(name.contains("<") == true) {
			name = name.replace("<", "");
		}if(name.contains(">") == true) {
			name = name.replace(">", "");
		}
		
		if(returnTypes.contains(returnType) == false) {
			//System.out.print("I should be adding in a new return type of: ");
			//returnTypes.add(returnType);
			//System.out.println(returnType);
			//argumentTypes.add(returnType); // This line works because both of these types are keeping track of the "uses" arrow
			
			
			System.out.println(returnType + " this is the t.getClassname");
			if(returnType.contains(".")) {
				System.out.println(returnType + " return type again");
				System.out.println(returnType.length());
				System.out.println(returnType.split(".").toString());
				String[] classNames = returnType.split(".");
				//System.out.println(returnType.charAt(9));
				System.out.println(classNames[0]);
				if(argumentTypes.contains(classNames[classNames.length-1])){
					// do nothing
				}else {
					argumentTypes.add(classNames[classNames.length-1]);
				}
			}
			else {
				if(argumentTypes.contains(returnType)){
					// do nothing
				}else {
					argumentTypes.add(returnType);
				}
			}
		}
		
		String line = symbol + " " + name + "()" + " : " + returnType;
		methods.add(line);
		
		//System.out.println("    method " + symbol + " " + returnType + " " + name + " " + stypes.toString());
		//System.out.println(symbol + " " + name + "()" + " " + returnType);
		
		return toDecorate;
	}

}
