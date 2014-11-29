package Project.v1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * Example program to list links from a URL.
 */
public class SoccerRating {
	
	 	footballMatch mecze[];
	 	Elements tab;
	 	Elements tr;
	 	
    public SoccerRating(String url) throws IOException  {
        //System.out.println("Fetching %s..." +  url);
        Document doc = Jsoup.connect(url).get();
        tab = doc.select("table");
        tr = tab.select("tr");
        mecze = new footballMatch [tr.size()];
    }
    
    void printMatches(int k) {
    	Elements td;
         int i = 0, start = 25;
         int max = start + k;
         for (i = start; i < max; i++) {
         		td = tr.get(i).select("td");
     			mecze[i-start] = new footballMatch(td.get(1).text(), 
     												Team(td.get(2).text(), true),
     												Team(td.get(2).text(), false), 
     												Double.parseDouble(	td.get(3).text()), 
     												Double.parseDouble(	td.get(4).text()),  
     												Double.parseDouble(	td.get(5).text()),  
     												td.get(6).text());
     			System.out.println((i - start + 1) + ". " + (mecze[i-start]).returnMatch());
         }
    }

    public static String Team(String mecz, boolean b) {
			String []teams = mecz.split(" - ");
				if (b)
					return teams[0];
				return teams[1];
        }
        
    }

