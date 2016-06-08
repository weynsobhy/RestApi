package com.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.domain.Pekerja;
import com.es.repository.PekerjaRepository;

/**
 * Erwin Sobirin 
 * 8juni2016 23:52
 */

@Service
public class PekerjaService {

	@Autowired
	private PekerjaRepository pekerjaRepository;
	
	public List<Pekerja> findAllpekerjas() {
		return pekerjaRepository.findAll();		
	}

	public Pekerja findByIdPekerja(Integer id) {
		return pekerjaRepository.findOne(id);
	}

	public Pekerja findById(Integer id) {
	return pekerjaRepository.getOne(id);
	}

	public void deletepekerjaById(Integer id) {
		pekerjaRepository.delete(id);		
	}

	public void simpan(Pekerja pekerja) {
		pekerjaRepository.save(pekerja);		
	}

}
