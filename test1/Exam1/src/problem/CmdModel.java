package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class CmdModel {
	private String extension;
	private String command;
	private List<String> arguments;
	protected HashMap<String, IApplication> applicationMap = new HashMap<String, IApplication>();
	private IApplication extensionToExecute;

	public CmdModel(String line) throws Exception {
		if (line == null || line.length() == 0)
			throw new Exception("FORMAT ERROR: Empty command is not supported!");

		StringTokenizer tokenizer = new StringTokenizer(line);
		if (tokenizer.hasMoreTokens())
			this.extension = tokenizer.nextToken(" ");
		else
			throw new Exception("FORMAT ERROR: Missing application name!");

		if (tokenizer.hasMoreTokens())
			this.command = tokenizer.nextToken(" ");
		else
			throw new Exception("FORMAT ERROR: Missing application command!");

		List<String> params = new ArrayList<String>();
		while (tokenizer.hasMoreTokens()) {
			params.add(tokenizer.nextToken(",").trim());
		}

		this.arguments = Collections.unmodifiableList(params);
	}

	public String getExtension() {
		return extension;
	}

	public String getCommand() {
		return command;
	}

	public List<String> getArguments() {
		return arguments;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---------------------------\n");
		this.extensionToExecute = this.applicationMap.get(this.extension);
		buffer.append(this.extensionToExecute.toString(command, this.arguments));
		return buffer.toString();

	}
}
