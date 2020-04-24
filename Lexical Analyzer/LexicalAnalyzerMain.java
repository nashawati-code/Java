import java.io.FileWriter;
import java.io.IOException;

public class LexicalAnalyzerMain {

	public static void main(String[] args) throws IOException {
		String stmt = "(75+97343*(i/j))/(sum/count)";
		LexicalAnalyzer lex = new LexicalAnalyzer(stmt);
		FileWriter  file = new FileWriter("text.txt");
		file.write(lex.html.toString());
		file.close();
	}
}