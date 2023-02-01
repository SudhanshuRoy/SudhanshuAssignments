package com.prospecta.DTO;

import java.util.List;

import com.prospecta.model.EntryData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllDataDto {
	
	private Integer count;
	private List<EntryData> entries;
	

}
