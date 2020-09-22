package odp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class odp {
	public static void main(String[] args) throws Exception {


		try {
			String path1 = "http://intra.kordi.re.kr/intra2008/sign/sign_mis.php?kind=51&orgcl=1&req_yy=2018&req_dep=E031&req_bno=4";
			// �α��� ������ ����
			Connection.Response loginPageResponse = Jsoup.connect(path1)
			                                                .timeout(3000)
			                                                .header("Origin", "http://tistory.com/")
			                                                .header("Referer", "https://www.tistory.com/auth/login")
			                                                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
			                                                .header("Content-Type", "application/x-www-form-urlencoded")
			                                                .header("Accept-Encoding", "gzip, deflate, br")
			                                                .header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
			                                                .method(Connection.Method.GET)
			                                                .execute();

			// �α��� ���������� ���� ��Ű
			Map<String, String> loginTryCookie = loginPageResponse.cookies();

			// �α��� ���������� �α��ο� �Բ� �����ϴ� ��ū ����
			Document loginPageDocument = loginPageResponse.parse();

			String ofp = loginPageDocument.select("input.ofp").val();
			String nfp = loginPageDocument.select("input.nfp").val();
			
			// Window, Chrome�� User Agent.
			String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36";

			// ������ �� ������
			Map<String, String> data = new HashMap<>();
			data.put("loginId", "���̵�");
			data.put("password", "��й�ȣ");
			data.put("rememberLoginId", "1");
			data.put("redirectUrl", "http://tistory.com/");
			data.put("ofp", ofp); // �α��� ���������� ���� ��ū��
			data.put("nfp", nfp);

			// �α���(POST)
			Connection.Response response = Jsoup.connect(path1)
			                                    .userAgent(userAgent)
			                                    .timeout(3000)
			                                    .header("Origin", "http://tistory.com/")
			                                    .header("Referer", "https://www.tistory.com/auth/login")
			                                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
			                                    .header("Content-Type", "application/x-www-form-urlencoded")
			                                    .header("Accept-Encoding", "gzip, deflate, br")
			                                    .header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
			                                    .cookies(loginTryCookie)
			                                    .data(data)
			                                    .method(Connection.Method.POST)
			                                    .execute();

			// �α��� ���� �� ���� ��Ű.
			// ��Ű �� TSESSION �̶�� ���� Ȯ���� �� �ִ�.
			Map<String, String> loginCookie = response.cookies();

			// Desktop.getDesktop().browse(new URI(path1));

			//Document doc1 = Jsoup.connect(path1).get();
			//System.out.println(doc1);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}


/*
 * Elements links1 = doc1.select("a[href]"); for (Element l : links1) { String
 * url1 = l.attr("abs:href"); if
 * (url1.contains("http://www.deepseadrilling.org/" + nn)) {
 * 
 * // System.out.println(url1); List a = new ArrayList(); a.add(url1); String
 * path2 = a.get(0).toString();
 * 
 * Document doc2 = Jsoup.connect(path2).get(); Elements links2 =
 * doc2.select("a[href]");
 * 
 * // ��°�� ���Ϸ� ����
 * 
 * File file = new File("C:\\test/ODP v." + n + ".txt"); FileOutputStream fos =
 * new FileOutputStream(file); PrintStream ps = new PrintStream(fos);
 * System.setOut(ps); System.out.println("::::: ���� " + nn + ":::::");
 * 
 * int q = 1;
 * 
 * for (Element l2 : links2) { // .pdf �� ������ URL�� ���� String pdf1 =
 * l2.attr("abs:href"); String pdf2 = pdf1.substring(pdf1.length() - 3,
 * pdf1.length());
 * 
 * if (pdf2.contains("pdf")) { // ��Ϲ�ȣ ���� k++;
 * 
 * // ���� ���� int y = 0; if (n == 8) { y = 1971; } if (9 <= n && n <= 14) { y =
 * 1972; } if (15 <= n && n <= 21) { y = 1973; } if (22 <= n && n <= 31) { y =
 * 1974; } if (n == 32) { y = 1975; } if (33 <= n && n <= 38) { y = 1976; } if
 * (n == 39) { y = 1977; } if (40 <= n && n <= 42) { y = 1978; } if (44 == n) {
 * y = 1978; } if (45 <= n && n <= 49) { y = 1979; } if (50 <= n && n <= 58) { y
 * = 1980; } if (59 <= n && n <= 63) { y = 1981; } if (64 <= n && n <= 68) { y =
 * 1982; } if (69 <= n && n <= 72) { y = 1983; } if (73 <= n && n <= 81) { y =
 * 1984; } if (82 <= n && n <= 86) { y = 1985; } if (87 <= n && n <= 92) { y =
 * 1986; } if (93 <= n && n <= 95) { y = 1987; } if ( 96 == n) { y = 1986; } //
 * ����� �������� �Է� System.out.println("��007    ta");
 * System.out.println("��022    ��a 1936-7392");
 * 
 * String kk = String.format("%05d", k); System.out.println("��049    ��l ODP" +
 * kk + "��f ODP");
 * 
 * System.out.println("��110    ��a IODP"); System.out.println( "��245 01 ��a " +
 * l2.text() + "��n v." + nn + "-" + q + ".��h [�����ڷ�]/��d IODP.");
 * System.out.print("��260    ��a CA ;��a USA:��b IODP ,��c"); System.out.println(" "
 * + y); System.out.println("��300    ��a �������.;��c �����ڷ�."); System.out.println(
 * "��440 00 ��a Deep Sea Drilling Project Initial Reports;��v v." + nn + "-" + q);
 * System.out.println("��500 00 ��a Ocean Drilling Program");
 * System.out.println("��653    ��a Ocean Drilling Program��a ODP��a DSDP");
 * System.out.println("��856    ��u " + pdf1);
 * 
 * System.out.println(" "); System.out.println(" "); System.out.println(" ");
 * System.out.println(" "); System.out.println(" ");
 * 
 * // ���� q ���� q++; } } } } } } }
 */
