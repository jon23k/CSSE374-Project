import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaToText{
	
	private String fileName;
	private String dataPath;
	
	public JavaToText(String newFile, String fileDataPath)
	{
		fileName = newFile +".txt";
		dataPath = fileDataPath;
	}
	
	public void run()
	{
		try
		{
		 PrintWriter outputStream = new PrintWriter(fileName);
		 Charset charset = Charset.forName("US-ASCII");
			try (BufferedReader reader = Files.newBufferedReader(Paths.get(dataPath), charset)) 
			{
			    String line = null;
			    while ((line = reader.readLine()) != null) {
			    	outputStream.println(line);
			    }
			}
			catch (IOException x) {
			    System.err.format("IOException: %s%n", x);
			    System.out.println("Your file failed to convert");
			}
		 System.out.println("Your file has been converted!");
		 outputStream.close();
	    }   
		catch (FileNotFoundException e) 
		{
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 System.out.println("Your file was not found");
	    }
	}
	

}
	
		
