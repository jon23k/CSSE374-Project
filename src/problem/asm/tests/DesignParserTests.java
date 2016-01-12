package problem.asm.tests;
import org.junit.Test;
import problem.asm.DesignParser;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DesignParserTests 
{
	@Test
	public void DoesTheCreatedFileExist()
	{
		DesignParser parser = new DesignParser();
		Path file = Paths.get("Stankfile.txt");
		boolean doesTheFileExist = Files.exists(file);
		assertEquals(true, doesTheFileExist);
	}
	
}
		

