package odp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.regex.*;

public class odpmarc2 {
	public static void main(String[] args) throws Exception {

		// ���۵�Ϲ�ȣ
		int k = 0;

		// ����Ʈ �����ѹ� Ȯ��
		for (int n = 1; n <= 1; n++) {
			String nn = String.format("%02d", n);

			// ��������Ʈ ���� Ȯ��
			String path1 = "http://www.deepseadrilling.org/i_reports.htm";
			Document doc1 = Jsoup.connect(path1).get();
			Elements links1 = doc1.select("a[href]");
			for (Element l : links1) {
				String url1 = l.attr("abs:href");
				String url2 = url1.substring(url1.length() - 12, url1.length());

				if (url2.contains("dsdp_toc.htm")) {
					System.out.println(url1);
					
					//System.out.println(a);
					
					
					
					
				for (int qi=1;qi<98;qi++){
					
					int nunu = 1;
					String ss = "http://www.deepseadrilling.org/"+"^*\\d$*"+"/dsdp_toc.htm";
					
				//	System.out.println(ss);
					
					
					//	System.out.println(a.get(qi));
					}
		
					
					
					//System.out.println(path3);
					
					
					
					/*
					
					{
						List a = new ArrayList();
						a.add(url1);
						String path2 = a.get(0).toString();

						Document doc2 = Jsoup.connect(path2).get();
						Elements links2 = doc2.select("a[href]");

						// ��°�� ���Ϸ� ����

						File file = new File("C:\\test/ODP v." + nn + ".txt");
						FileOutputStream fos = new FileOutputStream(file);
						PrintStream ps = new PrintStream(fos);
						System.setOut(ps);
						int q = 1;

						for (Element l2 : links2) {
							// .pdf �� ������ URL�� ����
							String pdf1 = l2.attr("abs:href");
							String pdf2 = pdf1.substring(pdf1.length() - 3, pdf1.length());

							if (pdf2.contains("pdf")) {
								// ��Ϲ�ȣ ����
								k++;

								// ���� ����
								int y = 0;

								// ����� �������� �Է�
								System.out.println("��007    ta");
								System.out.println("��022    ��a 1936-7392");

								String kk = String.format("%05d", k);
								System.out.println("��049    ��l ODP" + kk + "��f ODP");

								System.out.println("��110    ��a IODP");
								System.out.println(
										"��245 01 ��a " + l2.text() + "��n v." + nn + "-" + q + ".��h [�����ڷ�]/��d IODP.");
								System.out.print("��260    ��a CA ;��a USA:��b IODP ,��c");
								System.out.println(" " + y);
								System.out.println("��300    ��a �������.;��c �����ڷ�.");
								System.out.println(	"��440 00 ��a Deep Sea Drilling Project Initial Reports;��v v." + nn + "-" + q);
								System.out.println("��500 00 ��a Ocean Drilling Program");
								System.out.println("��653    ��a Ocean Drilling Program��a ODP��a DSDP");
								System.out.println("��856    ��u " + pdf1);

								System.out.println(" ");
								System.out.println(" ");
								System.out.println(" ");
								System.out.println(" ");
								System.out.println(" ");

								// ����
								q++;
							}
						}
					}
				}
			}
			*/
				}
			}
		}
	}

}
