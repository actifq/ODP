package odp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class odptest {
	public static void main(String[] args) throws Exception {

		// ���۵�Ϲ�ȣ
		int kk = 257;

	
		
		// ����Ʈ �����ѹ� Ȯ��
		for (int n = 8; n <= 38; n++) {
			String nn = String.format("%02d", n);
			String path = "http://www.deedpseadrilling.org/" + nn + "/dsdp_toc.htm";
			Document doc = Jsoup.connect(path).get();
			Elements links = doc.select("a[href]");

			
			// ��°�� ���Ϸ� ����
			File file = new File("C:\\Users/user/desktop/odp/odp" + " v." + n + ".txt");
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);

			System.out.println("::::: ���� " + nn + ":::::");

			// ���� ���� ����
			int q = 1;

			for (Element l : links) {
				// .pdf �� ������ URL�� ����
				String pdf1 = l.attr("abs:href");
				String pdf2 = pdf1.substring(pdf1.length() - 3, pdf1.length());

				if (pdf2.contains("pdf")) {

					// ��Ϲ�ȣ ����
					kk++;

					// ���� ����
					int y=0;
					if (n == 8) {y = 1971;	}
					if (9 <= n  &&  n <= 14) {	y = 1972;}
					if (15 <= n  &&  n <= 21) {	y = 1973;}
					if (22 <= n  &&  n <= 27) {	y = 1974;}
					if (n == 32) {y = 1975;	}
					if (33 <= n  &&  n <= 38) {	y = 1976;}
					if (n == 39) {y = 1977;	}
					
					// ����� �������� �Է�
					System.out.println("��007    ta");
					System.out.println("��022    ��a 1936-7392");
					System.out.println("��049    ��l ODP00" + (kk - 1) + "��f ODP");
					System.out.println("��110    ��a IODP");
					System.out.println("��245 01 ��a " + l.text() + "��n v." + nn + "-" + q + ".��h [�����ڷ�]/��d IODP.");
					System.out.print("��260    ��a CA ;��a USA:��b IODP ,��c");
					System.out.println(" " + y);
					System.out.println("��300    ��a �������.;��c �����ڷ�.");
					System.out.println("��440 00 ��a Deep Sea Drilling Project Initial Reports;��v v." + nn + "-" + q);
					System.out.println("��500 00 ��a Ocean Drilling Program");
					System.out.println("��653    ��a Ocean Drilling Program��a ODP��a DSDP");
					System.out.println("��856    ��u " + pdf1);
					
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");

					// ����-q ����
					q++;
				}
			}
		}
	}
}