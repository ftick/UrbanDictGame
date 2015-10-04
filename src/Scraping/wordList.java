package Scraping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SuppressWarnings("unused")

public class wordList {
	
	public static int count = 0;
	public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public static void doStuff() throws IOException{
		
		PrintWriter out = new PrintWriter(new FileWriter("src/list.txt")); 
		
		for(char chr: alphabet)
			out.println(removeHTML(getList(chr + "")));
		
		removePrefixes();
		
		out.close();
	}
	
	public static void removePrefixes() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("src/list.txt")); 
		PrintWriter out = new PrintWriter(new FileWriter("src/list2.txt"));
		while (in.ready()) { 
			  String text = in.readLine();
			  if(text.length()>0){
				  text = text.substring(text.indexOf(">")+1);
				  out.println(text);
				  count++;
			  }
		}
	}
	
	public static int getCount() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("src/list2.txt"));
		int count = 0;
		while (in.ready()) { 
			  String text = in.readLine();
			  count++;
		}
		return count;
	}
	
	public static String getList(String chr)throws IOException {
        Document doc= Jsoup.connect("http://www.urbandictionary.com/popular.php?character="+chr.toUpperCase()).get();
        return "\n" + doc.select("ul.no-bullet").html();
    }

	public static String removeHTML(String list){
		String ret = list.replace("<li> <a class=\"popular\" href=\"/define.php?term=", "");
		ret = ret.replace("<li> <a href=\"/tos.php\">terms of service</a> </li>","");
		ret = ret.replace("<li> <a href=\"/privacy.php\">privacy</a> </li>","");
		ret = ret.replace("<li> <a href=\"https://urbandictionary.wufoo.com/forms/how-can-we-help-you/\">feedback</a> </li>","");
		ret = ret.replace("<li> <a href=\"/remove.php\">remove</a> </li>","");
		
		ret = ret.replace("</a> </li> ","");
		
		ret = ret.substring(0,ret.length()-16);
		ret = ret.substring(0,ret.length()-1);
		
		return ret;
	}
}
