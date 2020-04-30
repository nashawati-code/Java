import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Program 
{

	//================================================================//
	
	/*
	 * Find all files in the filesystem subtree rooted at folder.
	 * 
	 * @param folder root of subtree, requires folder.isDirectory() == true
	 * @return stream of all ordinary files (not folders) that have folder as their
	 *         ancestor
	 */
	
	static Stream<File> allFilesIn(File folder) 
	{
		File[] children = folder.listFiles();
		Stream<File> descendants = Arrays.stream(children).filter(File::isDirectory).flatMap(Program::allFilesIn);
		return Stream.concat(descendants, Arrays.stream(children).filter(File::isFile));
	}
	
	//================================================================//
	
	/*
	 * Make a filename suffix testing predicate.
	 * 
	 * @param suffix string to test
	 * @return a predicate that returns true iff the filename ends with suffix.
	 */
	
	static Predicate<File> endsWith(String suffix) 
	{
		return f -> f.getPath().endsWith(suffix);
	}
	
	//================================================================//

	/*
	 * Read in a file.
	 * 
	 * @param file file to read in
	 * @return stream of lines in the file
	 */
	
	static Stream<String> readIn(File file) 
	{
		try 
		{
			return Files.readAllLines(file.toPath()).stream();
		} 
		catch (IOException ioe) 
		{
			throw new UncheckedIOException(ioe);
		}
	}
	
	//================================================================//
	
	/*
	 * Split a string into words.
	 * 
	 * @param str string to split
	 * @return stream of non-word-character-separated words in str
	 */
	
	static Stream<String> splitIntoWords(String str) 
	{
		return Arrays.stream(str.split("\\W+")).filter(s -> s.length() > 0);
	}
	
	//================================================================//

	public static void main(String[] args) 
	{
//		training();
		realWorld();
	}

	public static void training() 
	{
		String text = "Hello, world. How are you?";
		String[] words = text.split("\\W+");

		Stream<String> unk = Arrays.stream(words);
		
//		for (String s : unk.toArray(String[]::new)) 
//		{
//			System.out.println(s);
//		}
		
		Stream<String> mapr = unk.map(String::toUpperCase);
		
//		for (String s : mapr.toArray(String[]::new)) 
//		{
//			System.out.println(s);
//		}
			
		//CTRL-1 to have Eclipse declare the variable for you (resolves data type)
		Stream<String> fil = mapr.filter(s -> s.startsWith("H"));
		for (String s : fil.toArray(String[]::new)) {
			System.out.println(s);
		}
		
//		String[] ar = fil.toArray(String[]::new);
//		for (String s : ar) 
//		{
//			System.out.println(s);
//		}
//		System.out.println("Done");
	}
	
	//stream of files available in the current direction (.)
	public static void realWorld() 
	{
		Stream<File> roots = Arrays.stream(new String[] { "." }).map(File::new); 
		
		Stream<File> files = roots.flatMap(Program::allFilesIn).filter(endsWith(".java"));
		Stream<String> lines = files.flatMap(Program::readIn);
		Stream<String> words = lines.flatMap(Program::splitIntoWords);
		words.forEach(System.out::println);
		System.out.println("Done");
	}
}