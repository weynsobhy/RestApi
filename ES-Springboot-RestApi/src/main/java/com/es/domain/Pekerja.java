package com.es.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Erwin Sobirin 
 * 8juni2016 23:52
 */

@Entity
public class Pekerja{
	
	private Integer idPekerja;
	private String namaPekerja;
	private String upah;
	private String alamat;
	private String divisi;
	
	@Id
	@GeneratedValue
	public Integer getIdPekerja() {
		return idPekerja;
	}
	public void setIdPekerja(Integer idPekerja) {
		this.idPekerja = idPekerja;
	}
	public String getNamaPekerja() {
		return namaPekerja;
	}
	public void setNamaPekerja(String namaPekerja) {
		this.namaPekerja = namaPekerja;
	}
	public String getUpah() {
		return upah;
	}
	public void setUpah(String upah) {
		this.upah = upah;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getDivisi() {
		return divisi;
	}
	public void setDivisi(String divisi) {
		this.divisi = divisi;
	}
	
	
	

}
