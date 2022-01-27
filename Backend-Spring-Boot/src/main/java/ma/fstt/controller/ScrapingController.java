package ma.fstt.controller;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.fstt.model.Data;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@CrossOrigin
@RestController
public class ScrapingController {
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/getdonnees")
	public  List<String> getDataHtml(@RequestBody String url) throws IOException {
		List<String> myArrayList = new ArrayList<>();
		Document doc = Jsoup.connect(url).timeout(6000).get();
		Elements body = doc.getAllElements();
		myArrayList.add(body.toString());
		return myArrayList;
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/paramettres")
	public  List<String> donnee(@RequestBody Data data) throws IOException {
		String url=data.getUrl();
		String emp=data.getBalise1()+"."+data.getClasse1();
		List<String> myArrayList = new ArrayList<>();
		Document doc = Jsoup.connect(url).timeout(6000).get();
		Elements body = doc.select(emp);
		System.out.print(data.getBalise1()+ "_++++++++++++++++++_");
		System.out.print(data.getClasse1()+ "_++++++++++++++++++_");

		for(Element e : body.select(data.getBalise1()))
		{
		    String title = e.select(emp).text();
		    myArrayList.add(title);
		   
		}
		return myArrayList;
	}
	
	

}

