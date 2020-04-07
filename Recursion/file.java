import java.io.File;

public class file {
	public static void main(String[] args) {

		crawl(new File("c:/temp"));

	}

	public static void crawl(File f) {
		crawl(f, "");
	}

	private static void crawl(File f, String indent) {
		System.out.println(indent + f.getName());
		if (f.isDirectory()) {
			for (File subFile : f.listFiles()) {
				crawl(subFile, indent + "    ");
			}
		}
	}

}