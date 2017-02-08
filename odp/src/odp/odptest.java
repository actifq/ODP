package odp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import org.json.*;
import org.jsoup.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class odptest {
	public static void main(String[] args) throws Exception {
		
		
		File file=new File("C:\\Users/user/desktop/odp.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		
		
		
		// 사이트 볼륨 넘버
		int kk = 257;
		for (int n = 8; n <= 41; n++) {
			String nn = String.format("%02d", n);
			String path = "http://www.deepseadrilling.org/" + nn + "/dsdp_toc.htm";
			Document doc = Jsoup.connect(path).get();

			Elements title = doc.select(".Title");
			Elements links = doc.select("a[href]");
			System.out.println("볼륨::::::::::::" + nn);

			//볼륨 변수 설정
			int q = 1;
			
			for (Element l : links) {
				// .pdf 로 끝나는 URL만 추출
				String pdf1 = l.attr("abs:href");
				String pdf2 = pdf1.substring(pdf1.length() - 3, pdf1.length());
				if (pdf2.contains("pdf")) {
					System.out.println("》007    ta");
					System.out.println("》022    ▼a 1936-7392");
					System.out.println("》049    ▼l ODP00" + kk + "▼f ODP");
					System.out.println("》110    ▼a IODP");
					System.out.println("》245 01 ▼a " + l.text() + "▼n v." + nn + "-" + q + ".▼h [전자자료]/▼d IODP.");
					System.out.println("》260    ▼a CA ;▼a USA:▼b IODP ,▼c 1971.");
					System.out.println("》300    ▼a 면수복잡.;▼c 전자자료.");
					System.out.println("》440 00 ▼a Deep Sea Drilling Project Initial Reports;▼v v." + nn + "-" + q);
					System.out.println("》500 00 ▼a Ocean Drilling Program");
					System.out.println("》653    ▼a Ocean Drilling Program▼a ODP▼a DSDP");
					System.out.println("》856    ▼u " + pdf1);
					System.out.println("\n");
					kk++;
					q++;
				}
				
				
				if (!(pdf2.contains("pdf"))) {
					kk++;
				}
			}
		}
	}
}
/*
 * 

 * 
 */

// ---

/*
 * for(Element t:title){ System.out.println(t.text()); }
 */

/*
 * for (Element t : title) { System.out.println("》245 01 ▼a " + t.text() +
 * "▼n v." + nn + "-" + ".▼h [전자자료]/▼d IODP.");} }
 */

/*
 * for (Element t : title) { for (int k = 1; k <= pdf2.length(); k++) { String
 * kk = String.format("%02d", k); System.out.println("》245 01 ▼a " + t.text() +
 * "▼n v." + nn+"-"+kk + ".▼h [전자자료]/▼d IODP."); }
 * 
 * }
 */
// MARC 공통

/*
 * for (int odp = 257; odp <= 300; odp++) { System.out.println("》049 ▼l ODP00" +
 * odp + "▼f ODP"); }
 */

/*
 * 
 * System.out.println( "》245 01 ▼a " + e.text() + "▼n v." + nn + "-" + kk +
 * ".▼h [전자자료]/▼d IODP."); System.out.println(
 * "》440 00 ▼a Deep Sea Drilling Project Initial Reports;▼v v." + nn + "-" +
 * kk); }
 */

/*
 * for (Element e : title) { System.out.println("》245 01 ▼a " + e.text() +
 * "▼n v." + nn + ".▼h [전자자료]/▼d IODP."); }
 */
