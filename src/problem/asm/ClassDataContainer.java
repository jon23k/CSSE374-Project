package problem.asm;

import java.io.PrintWriter;

public class ClassDataContainer {
	PrintWriter outputStream = null;
	ClassDeclarationVisitor declVisitor = null;
	ClassFieldVisitor fieldVisitor = null;
	ClassMethodVisitor methodVisitor= null;

	public ClassDataContainer(PrintWriter outputStreamSent, ClassDeclarationVisitor declVisitorSent,
			ClassFieldVisitor fieldVisitorSent, ClassMethodVisitor methodVisitorSent) {
		// TODO Auto-generated constructor stub
		this.outputStream = outputStreamSent;
		this.declVisitor = declVisitorSent;
		this.fieldVisitor = fieldVisitorSent;
		this.methodVisitor = methodVisitorSent;
	}
	
	public void printInformation() {
		outputStream.println(declVisitor.nameGlobal + "[");
		outputStream.println("shape=\"record\", ");
		outputStream.print("label = \" {");
		outputStream.print(declVisitor.nameGlobal + " | ");
		printFields();
	}

	private void printFields() {
		// TODO Auto-generated method stub
		if(this.fieldVisitor.fields.size() > 1) {
			for(int i = 0; i < this.fieldVisitor.fields.size(); i++) {
				//String symbol = this.fieldVisitor.symbol;
				//String name = this.fieldVisitor.fieldTypes.get(i);
				//String type = this.fieldVisitor.type;
				//symbol + " " + name + " : \"" + type + "\" \\l"
				//outputStream.print(symbol + " " + name + " : \"" + type + "\" \\l");
				outputStream.print(this.fieldVisitor.fields.get(i));
			}
			this.outputStream.print(this.fieldVisitor.fields.get(this.fieldVisitor.fields.size()-1) + "|");
		}
		printMethods();
	}

	private void printMethods() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.methodVisitor.methods.size(); i++) {
			this.outputStream.print("" + this.methodVisitor.methods.get(i) + "" + "\\l");
		}
		this.outputStream.print(this.methodVisitor.methods.get(this.methodVisitor.methods.size()-1) + "\\l}");
		this.outputStream.println("\"");
		this.outputStream.println("];");
		printConnections();
	}

	private void printConnections() {
		// TODO Auto-generated method stub
		this.outputStream.println(this.declVisitor.nameGlobal + " -> " + this.declVisitor.extendNameGlobal + "[arrowhead=\"onormal\", style=\"dashed\"] ");
		
		if((this.declVisitor.getImplementedNameList() > 0)) {
			this.outputStream.println(this.declVisitor.nameGlobal + " -> " + this.declVisitor.implementerNameGlobal + "[arrowhead=\"curve\", style=\"dashed\"] ");
		}
		
		for(int i = 1; i < this.methodVisitor.argumentTypes.size(); i++) {
			this.outputStream.println(this.declVisitor.nameGlobal + " -> " + "\"" +this.methodVisitor.argumentTypes.get(i) + "\"" + "[arrowhead=\"onormal\", style=\"dashed\"] ");
			// This should be for the uses section
		}
		
		for(int i = 1; i < fieldVisitor.fieldTypes.size(); i++) {
			this.outputStream.println(this.declVisitor.nameGlobal + " -> " + "\"" + this.fieldVisitor.fieldTypes.get(i) + "\"" + "[arrowhead=\"onormal\", style=\"solid\"] ");
			// This should be for the uses section
		}
	}

}
