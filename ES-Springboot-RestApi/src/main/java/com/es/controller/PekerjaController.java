package com.es.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.es.domain.Pekerja;
import com.es.service.PekerjaService;

/**
 * Erwin Sobirin 
 * 8juni2016 23:52
 */

@Controller
@RequestMapping("/pekerja")
public class PekerjaController {
	@Autowired
	private PekerjaService pekerjaService;

	@Inject
	public PekerjaController(PekerjaService pekerjaService) {
		this.pekerjaService = pekerjaService;
	}

	// Get-All
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Pekerja>> listAllpekerjas() {
		List<Pekerja> pekerjas = pekerjaService.findAllpekerjas();
		if (pekerjas.isEmpty()) {
			return new ResponseEntity<List<Pekerja>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pekerja>>(pekerjas, HttpStatus.OK);
	}

	// Get-Id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pekerja> getpekerja(@PathVariable("id") Integer id) {
		System.out.println("cari id pekerja " + id);
		Pekerja pekerja = pekerjaService.findByIdPekerja(id);
		if (pekerja == null) {
			System.out.println("Pekerja yang id nya " + id + " tidak ada");
			return new ResponseEntity<Pekerja>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pekerja>(pekerja, HttpStatus.OK);
	}
	// Post
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pekerja> savePekerja(@RequestBody Pekerja pekerja) {
		try {
			pekerjaService.simpan(pekerja);
			return new ResponseEntity<Pekerja>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Pekerja>(HttpStatus.NOT_FOUND);
		}
	}
	// Put
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pekerja> updatepekerja(@PathVariable("id") Integer id, @RequestBody Pekerja pekerja) {
		System.out.println("Updating pekerja " + id);
		Pekerja currentpekerja = pekerjaService.findById(id);
		if (currentpekerja == null) {
			System.out.println("pekerja with id " + id + " not found");
			return new ResponseEntity<Pekerja>(HttpStatus.NOT_FOUND);
		}
		currentpekerja.setNamaPekerja(pekerja.getNamaPekerja());
		currentpekerja.setAlamat(pekerja.getAlamat());
		currentpekerja.setDivisi(pekerja.getDivisi());
		currentpekerja.setUpah(pekerja.getUpah());

		pekerjaService.simpan(currentpekerja);
		return new ResponseEntity<Pekerja>(currentpekerja, HttpStatus.OK);
	}
	// Delete-Id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pekerja> deletepekerja(@PathVariable("id") Integer id) {
		System.out.println("delete pekerja id " + id);
		Pekerja pekerja = pekerjaService.findById(id);
		if (pekerja == null) {
			System.out.println("tidak bisa didelete pekerja id " + id + " not found");
			return new ResponseEntity<Pekerja>(HttpStatus.NOT_FOUND);
		}
		pekerjaService.deletepekerjaById(id);
		return new ResponseEntity<Pekerja>(HttpStatus.NO_CONTENT);
	}

}
