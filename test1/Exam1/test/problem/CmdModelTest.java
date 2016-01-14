package problem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CmdModelTest {

	@Test
	public final void testCmdModelBaseCase() throws Exception {
		String line = "echo uppercase Hello, World";
		CmdModel model = new CmdModel(line);
		
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
	}

	@Test
	public final void testCmdModelWithSingleArg() throws Exception {
		String line = "echo uppercase Hello ";
		CmdModel model = new CmdModel(line);
		
		String expected = "echo";
		String actual = model.getExtension();
		assertEquals(expected, actual);
		
		expected = "uppercase";
		actual = model.getCommand();
		assertEquals(expected, actual);

		List<String> expectedArgs = new ArrayList<String>();
		expectedArgs.add("Hello");
		List<String> actualArgs = model.getArguments();
		assertEquals(expectedArgs, actualArgs);	
	}
	
	@Test
	public final void testCmdModelWithNoArg() throws Exception {
		String line = "echo uppercase";
		CmdModel model = new CmdModel(line);
		
		String expected = "echo";
		String actual = model.getExtension();
		assertEquals(expected, actual);
		
		expected = "uppercase";
		actual = model.getCommand();
		assertEquals(expected, actual);

		List<String> expectedArgs = new ArrayList<String>();
		List<String> actualArgs = model.getArguments();
		assertEquals(expectedArgs, actualArgs);	
	}	
	
	@Test(expected=Exception.class) 
	public final void testCmdModelWithEmptyInput() throws Exception {
		new CmdModel("");
	}

	
	@Test(expected=Exception.class) 
	public final void testCmdModelWithNoCommand() throws Exception {
		new CmdModel("echo");
	}

	
	@Test(expected=Exception.class) 
	public final void testCmdModelWithNoCommandAndWithExtraSpace() throws Exception {
		new CmdModel("echo ");
	}
	
	
}
