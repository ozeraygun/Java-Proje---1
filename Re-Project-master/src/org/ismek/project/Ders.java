package org.ismek.project;

public class Ders extends TemelSinif {
	private String adi;
	private String kodu;
	private byte kredisi;
	private String gunu;
	private int ogretmeninSeriNosu;
	private String dersSaatAraligi;
	
	public String getDersSaatAraligi() {
		return dersSaatAraligi;
	}
	public void setDersSaatAraligi(String dersSaatAraligi) {
		this.dersSaatAraligi = dersSaatAraligi;
	}
	public int getOgretmeninSeriNosu() {
		return ogretmeninSeriNosu;
	}
	public void setOgretmeninSeriNosu(int ogretmeninSeriNosu) {
		this.ogretmeninSeriNosu = ogretmeninSeriNosu;
	}
	public String getGunu() {
		return gunu;
	}
	public void setGunu(String gunu) {
		this.gunu = gunu;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getKodu() {
		return kodu;
	}
	public void setKodu(String kodu) {
		this.kodu = kodu;
	}
	public byte getKredisi() {
		return kredisi;
	}
	public void setKredisi(byte kredisi) {
		this.kredisi = kredisi;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		// 1 - ABCDEF
		return adi + " - " + kodu + " - " + kredisi + " ---" + gunu;
	}
	
}
