package rims;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class article {
	public static void main(String[] args) throws Exception {

		for (int k = 0; k <= 6000; k= k+100) {
			String path = 
					"http://210.110.184.172/simple-search?query=&sort_by=score&order=desc&rpp=100&etal=5&filter_field_1=type&filter_type_1=equals&filter_value_1=Article&start="
					+ k;
			Document doc1 = Jsoup.connect(path).get();
			Elements url = doc1.select(".al_title");
			System.out.println(k+"¹øÂ°");
			System.out.println(url);

		}

		//File file = new File("C:\\dev/1.txt");
		//FileOutputStream fos = new FileOutputStream(file);
		//PrintStream ps = new PrintStream(fos);
		//System.setOut(ps);

	
		
		
	}
}
