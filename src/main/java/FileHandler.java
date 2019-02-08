import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
/*
 * ==== File Handler ====
 * Class to handle the reading of the JSON file
 * and writing the SQL statements to a text file.
 */
public class FileHandler {
	/* Instance variables */
	private String fileName;
	private Site [] mySites;
	/**
	 * Constructor - file name is obtained here.
	 * @param fileName
	 */
	public FileHandler(String fileName) {
		this.fileName = "src/main/resources/" + fileName;
	}
	/**
	 * Read File method.
	 * Uses GSON, a library used to handle JSON files.
	 * If file not found it exits the program.
	 */
	public void readFile() {
		Gson gson = new Gson();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			mySites = gson.fromJson(reader, Site[].class);
			reader.close(); // Close reader
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Writes SQL to a file. 
	 * Name of file and what is written are taken as arguments. 
	 * @param outFile
	 * @param create
	 * @param insert
	 */
	public void writeFile(String outFile, String create, String insert) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
			out.write(create);
			out.write(insert);
			out.close(); // Close writer
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Get sites.
	 * To pass on to relevant object.
	 * @return
	 */
	public Site [] getSites() {
		return mySites;
	}
}