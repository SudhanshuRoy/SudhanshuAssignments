package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.DTO.SpecificDataDto;
import com.prospecta.model.EntryData;
import com.prospecta.service.EntityDataService;

@RestController
public class EntityDataController {
	@Autowired
	EntityDataService dataService;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<SpecificDataDto>> getEntryByCategoryHandler(@PathVariable("category")  String category) throws Exception
	
	{
		List<SpecificDataDto> data=	dataService.getDataByCategory(category);
		
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	@GetMapping("/entries")
	public ResponseEntity<EntryData> saveNewEntryHandler(){
		EntryData entry=dataService.saveNewEntry();
		return new ResponseEntity<EntryData>(entry,HttpStatus.ACCEPTED);
	}

}
