package org.ismek.project;

public class WriterUtils {
	public static void adminBilgileriniAl() {
		System.out.println("Kullanici adinizi kullanarak sisteme giriþ yapiniz lutfen..!!\n");
		System.out.print("Kullanici adi = ");
	}

	public static void girisBasligiYazdir() {
		System.out.println("----------" + 
						   "Universitemizin Ders Secim Sistemine Basariyla Giris Yaptiniz"+
						   "----------");
	}
	
	public static void ayracYazdir() {
		System.out.println("------------------------------------");
	}
	
	public static void boslukYap(){
		System.out.print("\n");
	}
	
	public static void dersGirisEkraniBasligi(){
		System.out.println("----Ders Girisi Ekranina Hosgeldiniz----");
	}
	
	public static void ogretmenGirisEkraniBasligi(){
		System.out.println("----Ogretmen Girisi Ekranina Hosgeldiniz----");
	}	
	
	
}
