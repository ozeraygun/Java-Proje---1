package org.ismek.project;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	static String driver = "com.mysql.jdbc.Driver";
	static String baglantiAdresi = "jdbc:mysql://10.1.8.20:3306/ozer?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
	static String username = "ogrenci";
	static String password = "1234";
	

	static ArrayList<Ders> dersList = new ArrayList<Ders>();
	static ArrayList<Ogretmen> ogretmenList = new ArrayList<Ogretmen>();

	public static void main(String[] args) {

		Scanner klavyedenOku = new Scanner(System.in);

		WriterUtils.adminBilgileriniAl();
		String adminAdi = klavyedenOku.next();
		WriterUtils.girisBasligiYazdir();
		WriterUtils.boslukYap();

		boolean donguDegeri = true;
		while (donguDegeri != false) {

			System.out.print("Merhabalar " + adminAdi + ". Yapmak istediginiz islemi seciniz lutfen.");
			WriterUtils.boslukYap();

			System.out.println("1-> Sisteme ders girisi yapacaginiz ogretmeni secmek icin 1 tusuna ;\n"
					+ "2-> Sisteme secilen ogretmenin ders girisilerini yapmak icin 2 tusuna ;\n"
					+ "3-> Sisteme girilen ogretmeni gormek icin 3 tusuna ;\n"
					+ "4-> Sisteme girdiginiz dersleri listelemek icin 4 tusuna ;\n"
					+ "5-> Cikis yapmak icin 5 tusuna basiniz ..!!");
			System.out.print("\nYapilacak islem =");
			byte secim = klavyedenOku.nextByte();

			switch (secim) {

			case 1:
				WriterUtils.boslukYap();
				WriterUtils.ogretmenGirisEkraniBasligi();
				WriterUtils.ayracYazdir();

				Ogretmen ogretmen = new Ogretmen();
				System.out.print("Ogretmenin adini giriniz = ");
				String ogretmenAdi = klavyedenOku.next();
				ogretmen.setAdi(ogretmenAdi);

				System.out.print("Ogretmenin soyadini giriniz = ");
				String ogretmenSoyadi = klavyedenOku.next();
				ogretmen.setSoyadi(ogretmenSoyadi);

				System.out.print("Ogretmenin seri numarasini giriniz = ");
				int ogretmenSeriNo = klavyedenOku.nextInt();
				ogretmen.setSeriNo(ogretmenSeriNo);

				try {
					Connection conn = DriverManager.getConnection(baglantiAdresi, username, password);
					String sorgu = "insert into ogretmen (ogretmen_adi , ogretmen_soyadi ,seri_no) values (?, ?, ?)";
					PreparedStatement prepareStatement = conn.prepareStatement(sorgu);
					prepareStatement.setString(1, ogretmenAdi);
					prepareStatement.setString(2, ogretmenSoyadi);
					prepareStatement.setInt(3, ogretmenSeriNo);
					
					prepareStatement.execute();
					conn.close();
				} catch (Exception e) {
					System.out.println(e);
				} finally {
				}
				System.out.println("Kayit eklendi");

				ogretmenList.add(ogretmen);
				WriterUtils.boslukYap();
				break;

			case 2:
				WriterUtils.boslukYap();
				WriterUtils.dersGirisEkraniBasligi();
				WriterUtils.ayracYazdir();

				System.out.print("Secilen ogretmen icin kac tane ders tanimlanacak = ");
				byte dersSayisi = klavyedenOku.nextByte();
				for (int i = 1; i <= dersSayisi; i++) {
					Ders ders = new Ders();
					System.out.print(i + ".)Ders adini giriniz = ");
					String dersinAdi = klavyedenOku.next();
					ders.setAdi(dersinAdi);

					System.out.print(i + ".)Ders kodunu giriniz = ");
					String dersinKodu = klavyedenOku.next();
					ders.setKodu(dersinKodu);

					System.out.print(i + ".)Ders kredisini giriniz = ");
					byte dersinKredisi = klavyedenOku.nextByte();
					ders.setKredisi(dersinKredisi);

					System.out.print(i + ".)Dersin islenecegi gunu giriniz = ");
					String dersGunu = klavyedenOku.next();
					ders.setGunu(dersGunu);

					System.out.print(i + ".)Dersin islenecegi saat araligini giriniz = ");
					String dersSaatAraligi = klavyedenOku.next();
					ders.setGunu(dersSaatAraligi);

					System.out.print(i + ".)Dersin ogretmeninin seri numarasini giriniz = ");
					int dersOgretmenininSeriNosu = klavyedenOku.nextInt();
					ders.setOgretmeninSeriNosu(dersOgretmenininSeriNosu);

					Connection connec = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						connec = DriverManager.getConnection(baglantiAdresi, username, password);
						String sorgu = "insert into ders (ders_kodu, ders_adi, ders_kredisi, ders_gunu, ders_saati, ogretmen_seri_no) values (?, ?, ?, ?, ?, ?)";
						PreparedStatement prepareStatement = connec.prepareStatement(sorgu);
						prepareStatement.setString(1, dersinKodu);
						prepareStatement.setString(2, dersinAdi);
						prepareStatement.setInt(3, dersinKredisi);
						prepareStatement.setString(4, dersGunu);
						prepareStatement.setString(5, dersSaatAraligi);
						prepareStatement.setInt(6, dersOgretmenininSeriNosu);

						prepareStatement.execute();
						

					} catch (Exception e) {
						System.out.println(e);
					} finally {
						try {
							connec.close();
						} catch (SQLException e) {
							System.out.println("Hata olustu. Baglanti bile kapatilamadi.");
						}
					}
					System.out.println("Kayýt eklendi");

					dersList.add(ders);
					WriterUtils.boslukYap();
				}
				WriterUtils.boslukYap();
				break;

			case 3:
				WriterUtils.boslukYap();
				ogretmenGoruntule();
				WriterUtils.boslukYap();
				break;

			case 4:
				WriterUtils.boslukYap();
				dersListele();
				WriterUtils.boslukYap();
				break;
				
			case 5:
				WriterUtils.boslukYap();
				System.out.println("Sayin " + adminAdi + " sistemden basari ile cikis yaptiniz.");
				donguDegeri = false;
				WriterUtils.boslukYap();
				break;

			default:
				System.out.println("\nSayýn " + adminAdi + " girmis oldugunuz rakam islemler arasýnda mevcut degil.");
				System.out.println("Yeni islem yapmak istiyorsaniz 1 tusuna basiniz ; "
						+ "aksi durumda sistemden cikis gerceklestirilecektir.");
				System.out.print("\nYapilacak islem = ");
				byte islemTekrarSayisi = klavyedenOku.nextByte();
				if (islemTekrarSayisi != 1)
					donguDegeri = false;
				System.out.println("Sayin " + adminAdi + " sistemden cikisiniz gerceklestirildi.");
				break;
			}

		}
	}

/*	private static void dersListele() {   --------------------- Bu listelemeleri veri tabanýndan alarak gerçekleþtir. Direkt olarak Listten alma , veritabanýndakiler kalýyor.
		for (Ders dersListele : dersList) {
			System.out.println(dersListele);
		}
	}

	private static void ogretmenGoruntule() {   ----------------- Bu listeyi de ayný þekilde veri tabanýndan çekerek al.
		for (Ogretmen ogretmenGoruntule : ogretmenList) {
			System.out.println(ogretmenGoruntule);
		}
	}*/

}
