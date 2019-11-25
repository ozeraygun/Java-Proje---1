package org.ismek.project;

public class Ogretmen extends TemelSinif{
	private String adi;
	private String soyadi;
	private int seriNo;
	
	
	public int getSeriNo() {
		return seriNo;
	}
	public void setSeriNo(int seriNo) {
		this.seriNo = seriNo;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		// 1 - ABCDEF
		return adi + "  " + soyadi + "   " + seriNo;
	}
	

}
