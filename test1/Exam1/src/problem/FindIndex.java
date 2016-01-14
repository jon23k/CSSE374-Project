package problem;

import java.util.List;

public class FindIndex implements ICommand {
	private int index =-1;
	private String key;
	private String stringargs;
	
	@Override
	public String commandExecute(List<String> args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Found at: ");
		key = args.get(0).toLowerCase();
		stringargs = args.get(1).toLowerCase();
		if(stringargs.contains(key)){
			index = stringargs.indexOf(key);
		}
		buffer.append(index);
		return buffer.toString();
	}
}
