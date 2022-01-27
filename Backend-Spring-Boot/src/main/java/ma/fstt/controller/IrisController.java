package ma.fstt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.fstt.model.IrisData;
import ma.fstt.model.Utilisateur;
import ma.fstt.repository.IrisRep;
@CrossOrigin
@RestController
public class IrisController {


@Autowired
private IrisRep rep;

@GetMapping("/irisdata")
public List<IrisData> getData(){
	return rep.findAll();
	
}
@CrossOrigin
@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/addIrisData")
public  IrisData saveIrisData(@RequestBody IrisData u) {
	
	return (rep.save(u));
}



}
