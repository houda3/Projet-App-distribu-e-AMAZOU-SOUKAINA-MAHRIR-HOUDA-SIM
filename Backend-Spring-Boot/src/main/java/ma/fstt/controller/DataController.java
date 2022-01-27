package ma.fstt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.fstt.model.Data;
import ma.fstt.repository.DataRep;

@CrossOrigin
@RestController
public class DataController {
	@Autowired
	private DataRep dataRep;
	
	@GetMapping("/dataset")
	public List<Data> getData(){
		return dataRep.findAll();
		
	}
}
