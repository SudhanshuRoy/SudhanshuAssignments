package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospecta.model.EntryData;

public interface EntryDataRepository extends JpaRepository<EntryData, String>{

}
