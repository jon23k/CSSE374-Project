package problem;

import java.util.List;

public class UpperCase implements ICommand {

	@Override
	public String commandExecute(List<String> args) {
		StringBuffer buffer = new StringBuffer();
		for(String s: args) {
			buffer.append(s.toUpperCase());
			buffer.append(" ");
		}
		return buffer.toString();
	}

}
