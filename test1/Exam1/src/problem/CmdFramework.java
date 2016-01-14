package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdFramework {

	public CmdFramework() {
	}
	
	public void execute() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = this.readLine(in);
		while(!line.equals("quit")) {
			CmdModel cmdModel = new CmdModel(line);
			cmdModel.applicationMap.put("echo", new EchoApp());
			cmdModel.applicationMap.put("StringOp", new StringOpApp());
			
			System.out.println("Executing App Extension: " + cmdModel.getExtension());
			System.out.println(cmdModel);

			line = readLine(in);
		}		
	}

	private String readLine(BufferedReader in) throws IOException {
		System.out.print("GPFCLA>");
		return in.readLine();
	}
}
