package com.prospecta.service;

import java.util.List;

import com.prospecta.DTO.SpecificDataDto;
import com.prospecta.exception.EntryDataException;
import com.prospecta.model.EntryData;

public interface EntityDataService {
	
	public List<SpecificDataDto> getDataByCategory(String category) throws EntryDataException;
	
	public EntryData saveNewEntry();

}
