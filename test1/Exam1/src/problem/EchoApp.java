package problem;

import java.util.HashMap;
import java.util.List;

public class EchoApp implements IApplication {
	
	HashMap<String, ICommand> commandmap = new HashMap<String,ICommand>();
	protected ICommand commandToExecute;
	
	public EchoApp(){
		commandmap.put("uppercase", new UpperCase());
	}
	
	@Override
	public String toString(String command, List<String> args) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command: ");
		try {
		buffer.append(command);
		this.commandToExecute = commandmap.get(command);
		buffer.append("\n");
		buffer.append(this.commandToExecute.commandExecute(args));
		buffer.append("\n");
		buffer.append("---------------------------\n");
		}catch(NullPointerException e){
			System.out.println("Unsupported command try an existing command");
		}
		return buffer.toString();
	}

}
