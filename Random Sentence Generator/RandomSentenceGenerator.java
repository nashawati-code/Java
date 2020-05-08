import java.util.HashMap;
import java.io.*;
import java.net.URL;
import java.util.*;

public class RandomSentenceGenerator 
{
	String treeLink="http://chart.googleapis.com/chart?cht=gv&chl=digraph{";
	HashMap<String,String[]> nonTerminals=new HashMap<String,String[]>();
	//=========================================================================//
	public RandomSentenceGenerator() throws IOException 
	{
		File file = new File("test.txt");
		BufferedReader re = new BufferedReader(new FileReader(file)); 
		String str;
		String[] text;
		while ((str = re.readLine()) != null) 
		{
			text=str.split("::=");
			nonTerminals.put(text[0], text[1].split("\\|"));
		}
	}
	//=========================================================================//
	public void generate_sentence(String str) 
	{
		if(nonTerminals.containsKey(str)!=true)
		{
			System.out.print(str+" ");
		}
		else 
		{
			int rand =new Random().nextInt(nonTerminals.get(str).length);
		
			String r=nonTerminals.get(str)[rand];
			String[] string_text;
			string_text=r.split(" ");
			for (String b:string_text) 
			{
				treeLink+=(str+"->" + b+";");
				generate_sentence(b);
			}
		}
	}
	//=========================================================================//
	public void downloadimg(String str) 
	{
		try (BufferedInputStream in = new BufferedInputStream(new URL(str).openStream());
				
		FileOutputStream fileOutputStream = new FileOutputStream("GeneratedMap")) 
		{
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) 
			{
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
		} catch (IOException e) 
		{
		    // handle exception
		}
	}
	//=========================================================================//
	public static void main(String[] args) throws IOException 
	{
		RandomSentenceGenerator sentence=new RandomSentenceGenerator();
		sentence.generate_sentence("<s>");
		System.out.println(" ");
		System.out.println(sentence.treeLink+"}");
		sentence.downloadimg(sentence.treeLink+"}");
	}
	//=========================================================================//
}