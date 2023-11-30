package entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity

public class OgrenciBilgi implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ogrAd;
	private String ogrSoyad;
	private String cinsiyet;
	private static final long serialVersionUID = 1L;

	public OgrenciBilgi() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getOgrAd() {
		return this.ogrAd;
	}

	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}   
	public String getOgrSoyad() {
		return this.ogrSoyad;
	}

	public void setOgrSoyad(String ogrSoyad) {
		this.ogrSoyad = ogrSoyad;
	}   
	public String getCinsiyet() {
		return this.cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
   
}
