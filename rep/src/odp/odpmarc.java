package odp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class odpmarc {
	public static void main(String[] args) throws Exception {

		// 시작등록번호
		int k = 0;

		// 사이트 볼륨넘버 확인
		for (int n = 1; n <= 1; n++) {
			String nn = String.format("%02d", n);
			
			
			// 개별사이트 볼륨 확인
			String path1 = "http://www.deepseadrilling.org/i_reports.htm";
			Document doc1 = Jsoup.connect(path1).get();
			Elements links1 = doc1.select("a[href]");
			for (Element l : links1) {
				String url1 = l.attr("abs:href");
				if (url1.contains("http://www.deepseadrilling.org/" + nn)) {

					// System.out.println(url1);
					List a = new ArrayList();
					a.add(url1);
					String path2 = a.get(0).toString();

					Document doc2 = Jsoup.connect(path2).get();
					Elements links2 = doc2.select("a[href]");

					// 출력결과 파일로 저장

					File file = new File("C:\\odp/ODP v." + n + ".txt");
					FileOutputStream fos = new FileOutputStream(file);
					PrintStream ps = new PrintStream(fos);
					System.setOut(ps);
					System.out.println("<?xml version="+"1.0"+" encoding="+"UTF-8"+" ?><collection xmlns="+"http://www.loc.gov/MARC21/slim"+">");
					int q = 1;

					for (Element l2 : links2) {
						// .pdf 로 끝나는 URL만 추출
						String pdf1 = l2.attr("abs:href");
						String pdf2 = pdf1.substring(pdf1.length() - 3, pdf1.length());

						if (pdf2.contains("pdf")) {
							// 등록번호 증가
							k++;

							// 연도 변수
							int y = 0;
							if (n == 8) {
								y = 1971;
							}
							if (9 <= n && n <= 14) {
								y = 1972;
							}
							if (15 <= n && n <= 21) {
								y = 1973;
							}
							if (22 <= n && n <= 27) {
								y = 1974;
							}
							if (n == 32) {
								y = 1975;
							}
							if (33 <= n && n <= 38) {
								y = 1976;
							}
							if (n == 39) {
								y = 1977;
							}

							// 출력할 서지사항 입력
							System.out.println("》007    ta");
							System.out.println("》022    ▼a 1936-7392");

							String kk = String.format("%05d", k);
							System.out.println("》049    ▼l ODP" + kk + "▼f ODP");

							System.out.println("》110    ▼a IODP");
							System.out.println(
									"》245 01 ▼a " + l2.text() + "▼n v." + nn + "-" + q + ".▼h [전자자료]/▼d IODP.");
							System.out.print("》260    ▼a CA ;▼a USA:▼b IODP ,▼c");
							System.out.println(" " + y);
							System.out.println("》300    ▼a 면수복잡.;▼c 전자자료.");
							System.out.println(
									"》440 00 ▼a Deep Sea Drilling Project Initial Reports;▼v v." + nn + "-" + q);
							System.out.println("》500 00 ▼a Ocean Drilling Program");
							System.out.println("》653    ▼a Ocean Drilling Program▼a ODP▼a DSDP");
							System.out.println("》856    ▼u " + pdf1);

							System.out.println(" ");
							System.out.println(" ");
							System.out.println(" ");
							System.out.println(" ");
							System.out.println(" ");
							// 볼륨 q 증가
							q++;
						}
					}
				}
			}
		}
	}
}
