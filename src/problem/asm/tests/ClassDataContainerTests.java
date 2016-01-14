package problem.asm.tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import problem.asm.DesignParser;
import problem.asm.ClassDataContainer;

public class ClassDataContainerTests {

	@Test()
	public void gotClassData() {
		DesignParser parser = new DesignParser();
		ArrayList<ClassDataContainer> classes = parser.getClassData();
		try{
		      classes.get(0);
		   }
		   catch(IndexOutOfBoundsException e){
		      fail("Your ClassDataContainer is not getting any class data");
		   }
	}

}
