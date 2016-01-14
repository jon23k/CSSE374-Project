package problem;

import java.util.HashMap;
import java.util.List;

public class StringOpApp implements IApplication {
	HashMap<String, ICommand> commandmap = new HashMap<String,ICommand>();
	protected ICommand commandToExecute;
	public StringOpApp(){ // main 
		
		commandmap.put("concat", new Concat());
		commandmap.put("find", new FindIndex());
	}
	@Override
	public String toString(String command, List<String> args) {
		StringBuffer buffer = new StringBuffer();
		try{
		buffer.append("Command: ");
		buffer.append(command);
		this.commandToExecute = this.commandmap.get(command);
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
