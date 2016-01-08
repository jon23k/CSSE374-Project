package problem.asm;

import java.util.ArrayList;
import java.util.Arrays;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;

public class ClassDeclarationVisitor extends ClassVisitor {
	
	public int access;
	public String nameGlobal;
	public String desc;
	public String signature;
	public String[] exceptions;
	public ArrayList<String> implementers = new ArrayList<String>();
	public String extendNameGlobal;
	public String implementerNameGlobal;
	//public ArrayList<String> implementedNames = new ArrayList<String>();

	public ClassDeclarationVisitor(int arg0) {
		super(arg0);
		//System.out.println(this.getClass().getName());
		// TODO Auto-generated constructor stub
	}

	public ClassDeclarationVisitor(int arg0, ClassVisitor arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void visit(int version, int access, String name, String signature, 
			String superName, String[] interfaces) {

		String[] parts = name.split("/");
		this.nameGlobal = parts[parts.length - 1];
		
		//name.getClass();
		
		//System.out.println("is interface? "+ this.getClass());
		
		//System.out.println("signature: ");
		
		String[] extender = superName.split("/");
		this.extendNameGlobal = extender[extender.length - 1];

		for(int i = 0; i < interfaces.length; i++) {
			String[] implementer = interfaces[i].split("/");
			this.implementerNameGlobal = implementer[implementer.length - 1];
			//System.out.println("the implementer name is: " + this.implementerNameGlobal);
			if(!this.implementerNameGlobal.equals("null")) {
				implementers.add(this.implementerNameGlobal);
			}

		}
		super.visit(version, access, name, signature, superName, interfaces);
	}

	public int getImplementedNameList() {
		// TODO Auto-generated method stub
		//System.out.println("ImplementerSize" + implementers.size());
		return implementers.size();
	}

}
