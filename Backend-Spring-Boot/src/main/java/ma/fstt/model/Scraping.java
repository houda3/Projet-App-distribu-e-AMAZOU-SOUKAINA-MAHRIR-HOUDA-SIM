package ma.fstt.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ma.fstt.repository.DataRepository;


public class Scraping {

		static DataRepository repository;

		public static void main(String[] args) throws IOException {

			Document doc = Jsoup.connect("https://datahub.io/machine-learning/iris").timeout(6000).get();
			Elements body = doc.select("tbody");
			System.out.println(body.select("tr").size());
			

			for(Element e : body.select("tr"))
			{
			   // String img = e.select("td.posterColumn img").attr("src");
			    //System.out.println(img);
			    String title = e.select("td").text();
			    System.out.println(title);
			   
			}


		}

	}

