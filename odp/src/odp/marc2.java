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

		// ���۵�Ϲ�ȣ
		int k = 0;

		// ���������ȣ

		// ����Ʈ �����ѹ� Ȯ��
		for (int n = 101; n <= 105; n++) {
			String nn = String.format("%02d", n);

			// ��������Ʈ ���� Ȯ��
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
