package problem;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestForExam {
	@Test
	public final void testCmdModelEcho() throws Exception {
		String line = "echo uppercase Hello, World";
		CmdModel model = new CmdModel(line);
		model.applicationMap.put("echo", new EchoApp());
		
		String expected = "echo";
		String actual = model.getExtension();
		assertEquals(expected, actual);
		
		expected = "uppercase";
		actual = model.getCommand();
		assertEquals(expected, actual);

		List<String> expectedArgs = new ArrayList<String>();
		expectedArgs.add("Hello");
		expectedArgs.add("World");
		List<String> actualArgs = model.getArguments();
		assertEquals(expectedArgs, actualArgs);
		
		
		String expectedOutput = ("---------------------------\n"
				+ "Command: uppercase\n"
				+ "HELLO WORLD \n"
				+ "---------------------------\n");
																
		assertEquals(expectedOutput, model.toString());
	}
	
	@Test
	public final void testCmdModelStringOpFind() throws Exception {
		String line = "StringOp find key, My key is lost!";
		CmdModel model = new CmdModel(line);
		model.applicationMap.put("StringOp", new StringOpApp());
		
		String expected = "StringOp";
		String actual = model.getExtension();
		assertEquals(expected, actual);
		
		expected = "find";
		actual = model.getCommand();
		assertEquals(expected, actual);

		List<String> expectedArgs = new ArrayList<String>();
		expectedArgs.add("key");
		expectedArgs.add("My key is lost!");
		List<String> actualArgs = model.getArguments();
		assertEquals(expectedArgs, actualArgs);
		
		
		String expectedOutput = ("---------------------------\n"
				+ "Command: find\n"
				+ "Found at: 3\n"
				+ "---------------------------\n");
																
		assertEquals(expectedOutput, model.toString());
	}
	
	@Test
	public final void testCmdModelStringOpConcat() throws Exception {
		String line = "StringOp concat key, My key is lost!";
		CmdModel model = new CmdModel(line);
		model.applicationMap.put("StringOp", new StringOpApp());
		
		String expected = "StringOp";
		String actual = model.getExtension();
		assertEquals(expected, actual);
		
		expected = "concat";
		actual = model.getCommand();
		assertEquals(expected, actual);

		List<String> expectedArgs = new ArrayList<String>();
		expectedArgs.add("key");
		expectedArgs.add("My key is lost!");
		List<String> actualArgs = model.getArguments();
		assertEquals(expectedArgs, actualArgs);
		
		
		String expectedOutput = ("---------------------------\n"
				+ "Command: concat\n"
				+ "key My key is lost! \n"
				+ "---------------------------\n");
																
		assertEquals(expectedOutput, model.toString());
	}
	
}
