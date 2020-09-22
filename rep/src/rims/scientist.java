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

public class scientist {
	public static void main(String[] args) throws Exception {

		for 
		(
		int i=0,j = 0 ; 
		i <= 14 ; 
		i++, j=j+30
		)
		{
			String path = 
					"http://210.110.184.172/browse-researcher?tab=0&filter=&focus=&starts_with=&sortType=english&filter=&page="+i+"&offset="+j;
			Document doc1 = Jsoup.connect(path).get();
			Elements url = doc1.select(".researcher_card");
			System.out.println(i+"ÆäÀÌÁö");
			System.out.println(url);

		}

		//File file = new File("C:\\dev/1.txt");
		//FileOutputStream fos = new FileOutputStream(file);
		//PrintStream ps = new PrintStream(fos);
		//System.setOut(ps);

	
		
		
	}
}
