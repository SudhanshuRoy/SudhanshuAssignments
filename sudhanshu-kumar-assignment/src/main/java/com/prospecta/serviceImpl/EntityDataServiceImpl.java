package com.prospecta.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.DTO.AllDataDto;
import com.prospecta.DTO.SpecificDataDto;
import com.prospecta.exception.EntryDataException;
import com.prospecta.model.EntryData;
import com.prospecta.repository.EntryDataRepository;
import com.prospecta.service.EntityDataService;

@Service
public class EntityDataServiceImpl implements EntityDataService {
  @Autowired
  private EntryDataRepository dataRepository;
  
  public static List<EntryData>  fetchEntries() {
	  
	  String url="https://api.publicapis.org/entries";
		
		RestTemplate restTemplate=new RestTemplate();
		
		AllDataDto totalData=restTemplate.getForObject(url, AllDataDto.class);
		
		List<EntryData> list=totalData.getEntries();
		
		return list;
	  
  }
	

	@Override
	public List<SpecificDataDto> getDataByCategory(String category) throws EntryDataException {
			
		List<EntryData> list=fetchEntries();
		
		List<SpecificDataDto> myList=new ArrayList<>();
			
		
		for(EntryData element:list) {
			
			if(element.getCategory().equals(category)) {
				
				SpecificDataDto dto=new SpecificDataDto();
				
				dto.setDescription(element.getDescription());
				
				dto.setTitle(element.getApi());
				
				myList.add(dto);
			}
		}
		
		if(myList!=null) {
			return myList;
		}
		else throw new EntryDataException("No entry found of given category");
	}

	@Override
	public EntryData saveNewEntry() {
		
		String message=null;
			
		List<EntryData> list=fetchEntries();
		
		     EntryData element=list.get(0);
		
			dataRepository.save(element);
		
		
		if(element==null) {
			message="Entries saved successfully !";
		}else {
			message="Entries couldn't saved";
		}
		
		return element;
	}
	

}
