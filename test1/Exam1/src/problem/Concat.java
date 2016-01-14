package problem;

import java.util.List;

public class Concat implements ICommand {
	
	@Override
	public String commandExecute(List<String> args) {
//		StringBuffer buffer = new StringBuffer();
		String concatString = "";
		for(String s: args) {
			concatString+=s;
			concatString += " ";
		}
//		buffer.append(concatString);
		return concatString;
	}

}
