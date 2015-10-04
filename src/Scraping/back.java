package Scraping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SuppressWarnings("unused")
public class back {
	
	public static String[] words;
	public static Scanner sc;
	public static boolean running;
	
	public static void main(String[] args) throws IOException {
//		init();
		init2();
		start();
	}
	
	public static void init() throws IOException{
		wordList.doStuff();
		createList();
		populateList();
	}
	
	public static void init2() throws IOException{
		createList();
		populateList();
	}
	
	public static void start() throws IOException{
		sc = new Scanner(System.in);
		running = true;
		while(running){
			guess();
		}
		System.out.println("Goodbye!");
	}
    
	public static void guess() throws IOException{
		int x = (int) (Math.random()*4);
		String ans = "a";
		if(x==0)		ans = "a";
		else if(x==1)	ans = "b";
		else if(x==2)	ans = "c";
		else			ans = "d";
		
		String a = "",b = "",c = "",d = "";
		String word = randomWord();
		
		System.out.println("\n" + word);
		
		switch(x){
			case 0:
				a = getDef(word);
				b = getRandomDef();
				c = getRandomDef();
				d = getRandomDef();
				break;
			case 1:
				a = getRandomDef();
				b = getDef(word);
				c = getRandomDef();
				d = getRandomDef();
				break;
			case 2:
				a = getRandomDef();
				b = getRandomDef();
				c = getDef(word);
				d = getRandomDef();
				break;
			case 3:
				a = getRandomDef();
				b = getRandomDef();
				c = getRandomDef();
				d = getDef(word);
				break;
		}
		
        System.out.println("A: " + "" + a);
        System.out.println("B: " + "" + b);
        System.out.println("C: " + "" + c);
        System.out.println("D: " + "" + d);
        
        System.out.print("\nGuess: ");
        String guess = sc.next();
        if(guess.toLowerCase().equals(ans))
        	System.out.println("Correct");
        else if(guess.toLowerCase().equals("quit"))
        	running = false;
        else
        	System.out.println("Incorrect, answer was: " + ans);
	}
	
	public static void createList() throws IOException{
		words = new String[wordList.getCount()];
	}
	
	public static void populateList() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("src/list2.txt"));
		int count = 0;
		while (in.ready()) { 
			  String text = in.readLine();
			  words[count]=text;
			  count++;
		}
	}
	
	public static String randomWord(){
		int r = (int) (Math.random() * words.length);
		return words[r];
	}
	
    public static String getDef(String term)throws IOException {
        Document doc= Jsoup.connect("http://www.urbandictionary.com/define.php?term="+term).get();
        String ret = doc.select("div.meaning").first().text();
        if(ret.contains(".")){
        	if(ret.indexOf(".")>9)
        		ret = ret.substring(0, ret.indexOf(".")+1);
        }
        if(ret.contains(term))
        	ret = ret.replace(term, "----");
        String caps = term.substring(0,1).toUpperCase();
        caps = caps + term.substring(1);
        if(ret.contains(caps))
        	ret = ret.replace(caps, "----");
        return ret;
    }
    
    public static String getRandomDef() throws IOException {
    	Document doc= Jsoup.connect("http://www.urbandictionary.com/random.php").get();
    	String ret = doc.select("div.meaning").first().text();
    	if(ret.contains(".")){
    		if(ret.indexOf(".")>9)
    			ret = ret.substring(0, ret.indexOf(".")+1);
    	}
    	if(ret.contains(" is "))
    		ret = ret.substring(ret.indexOf(" is ") + 1, ret.indexOf(" is ") + 2).toUpperCase() + ret.substring(ret.indexOf(" is ") + 2);
    	return ret;
    }
}
