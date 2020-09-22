package odp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class marc2 {
	public static void main(String[] args) throws Exception {

		// 시작등록번호
		int k = 0;

		// 시작제어번호

		// 사이트 볼륨넘버 확인
		for (int n = 101; n <= 105; n++) {
			String nn = String.format("%02d", n);

			// 개별사이트 볼륨 확인
			//String path1 = "http://www.deepseadrilling.org/i_reports.htm";
			String path1 = "http://www-odp.tamu.edu/publications/"+n+"_SR/"+n+"TOC.HTM";
			Document doc1 = Jsoup.connect(path1).get();
			Elements links1 = doc1.select("a[href]");
			
			for (Element l : links1) {
				String url1 = l.attr("abs:href");
				
				System.out.println(url1);

			}
		}
	}
}
