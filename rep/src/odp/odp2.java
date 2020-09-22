package odp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class odp2 {
	
	public static void main(String[] args) throws Exception {
	        File inFile = new File("D:\\1.txt");
	        
	        BufferedReader br = null;
	        
	        
	        try {
	            br = new BufferedReader(new FileReader(inFile));
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	                
	                
	                
	                
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            if(br != null) try {br.close(); } catch (IOException e) {}
	        }

	}
}