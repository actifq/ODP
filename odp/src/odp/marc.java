package odp;

import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class marc {
	public static void main(String[] args) throws Exception {

		  int k = 0; for (int n = 1; n <= 1; n++) { String nn = String.format("%02d",
		  n); String path1 = "http://www-odp.tamu.edu/publications/mail.htm"; Document
		  doc1 = Jsoup.connect(path1).get(); Elements links1 = doc1.select("a[href]");
		  
		  for (Element l : links1) { String url1 = l.attr("abs:href"); if
		  (url1.contains("http://www-odp.tamu.edu/publications/" + n + "_IR/" + n +
		  "ir.htm")) { List a = new ArrayList(); a.add(url1);
		  
		  System.out.println(a);
		  
		  String path2 = a.get(0).toString(); Document doc2 =
		  Jsoup.connect(path2).get(); Elements links2 = doc2.select("a[href]");
		  
		  System.out.println(links2);

		System.out.println("EE");

		/*
		 * for (Element l2 : links2) { // .pdf 로 끝나는 URL만 추출 String pdf1 =
		 * l2.attr("abs:href"); String pdf2 = pdf1.substring(pdf1.length() - 3,
		 * pdf1.length()); }
		 */

	}
}
