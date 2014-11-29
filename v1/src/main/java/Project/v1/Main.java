package Project.v1;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String args[]) throws IOException {
        //SoccerRating tab = new SoccerRating("http://www.soccer-rating.com/Manchester-United/213/");
		 String url= "http://www.soccer-rating.com/England/";
		 System.out.println("Fetching %s..." +  url);
	     Document doc = Jsoup.connect(url).get();
	      Elements links = doc.select("a[href]");	
	      System.out.println("Links:" + links.size());
	      int i = 13;  
	      String temp;
	      SoccerRating t;
	      for (i = 13; i < 33; i++) {
	    	    temp = links.get(i).attr("abs:href");
	            System.out.println("	" + (i-12) + ". " + temp);
	            t = new SoccerRating(temp);
	            t.printMatches(10);
	        }
	      url= "http://www.soccer-rating.com/Spain/";
	 	 System.out.println("Fetching %s..." +  url);
	       doc = Jsoup.connect(url).get();
	       links = doc.select("a[href]");	
	       System.out.println("Links:" + links.size());
	  
	       for (i = 13; i < 33; i++) {
	     	    temp = links.get(i).attr("abs:href");
	             System.out.println("	" + (i-12) + ". " + temp);
	             t = new SoccerRating(temp);
	             t.printMatches(10);
	         }
	}
}
