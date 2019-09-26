package com.comtrade.kontrolerKI;

import java.io.IOException;
import java.util.List;

import com.comtrade.domen.Adresa;
import com.comtrade.domen.Drzava;
import com.comtrade.domen.Grad;
import com.comtrade.domen.Hotel;
import com.comtrade.domen.HotelPretragaVrednosti;
import com.comtrade.domen.Soba;
import com.comtrade.domen.SobaSlike;
import com.comtrade.domen.TipSoba;
import com.comtrade.domen.User;
import com.comtrade.domen.Usluge;
import com.comtrade.domen.photos.Photo;
import com.comtrade.domen.pretraga.Pretraga;
import com.comtrade.domen.rezervacije.Rezervacije;
import com.comtrade.komunikacija.Komunikacija;

import com.comtrade.operacije.Operacije;
import com.comtrade.transferKlasa.TransferKlasa;

public class KontrolerKI {
	private static KontrolerKI instanca;

	private KontrolerKI() {

	}

	public static KontrolerKI getInstanca() {
		if (instanca == null) {
			instanca = new KontrolerKI();
		}
		return instanca;
	}

	public TransferKlasa sacuvajKorisnika(User user) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(user);
		transferKlasa.setOperacija(Operacije.SACUVAJ_KORISNIKA);

		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa login(User user) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(user);
		transferKlasa.setOperacija(Operacije.LOGIN);

		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa posaljiVrati(TransferKlasa transferKlasa) throws ClassNotFoundException, IOException {
		Komunikacija.getInstanca().posaljiNaServer(transferKlasa);
		TransferKlasa transferKlasa1 = Komunikacija.getInstanca().procitajSaServera();
		return transferKlasa1;

	}

	public TransferKlasa upisiDrzavu(Drzava drzava) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(drzava);
		transferKlasa.setOperacija(Operacije.SACUVAJ_DRZAVU);
		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa vratiPoslednjuUnetuDrzavu() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_DRZAVU);

		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa upisiGrad(Grad grad) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(grad);
		transferKlasa.setOperacija(Operacije.SACUVAJ_GRAD);

		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa upisiAdresu(Adresa adresa) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(adresa);
		transferKlasa.setOperacija(Operacije.SACUVAJ_ADRESU);

		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa vratiGradIzBaze() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_GRAD);
		return posaljiVrati(transferKlasa);
	}

	public TransferKlasa vratiAdresuIzBaze() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_ADRESU);
		return posaljiVrati(transferKlasa);
	}

	public TransferKlasa sacuvajHotel(Hotel hotel) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(hotel);
		transferKlasa.setOperacija(Operacije.SACUVAJ_HOTEL);
		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa vratiHotelIzBaze() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_HOTEL);

		return posaljiVrati(transferKlasa);
	}

	public TransferKlasa sacuvajSobu(TipSoba soba) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(soba);
		transferKlasa.setOperacija(Operacije.SACUVAJ_SOBU);
		return posaljiVrati(transferKlasa);
	}

	public TransferKlasa vratiSobuIzBaze() throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setOperacija(Operacije.VRATI_SOBU);
		return posaljiVrati(tc);
	}

	public TransferKlasa upisiSobu(Soba soba) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(soba);
		transferKlasa.setOperacija(Operacije.SACUVAJ_SOBUU);

		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa upisiUsluge(Usluge usluge) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(usluge);
		transferKlasa.setOperacija(Operacije.SACUVAJ_USLUGE);
		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa sacuvajSlike(Photo photo) throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setKlijent_object_request(photo);
		tc.setOperacija(Operacije.SACUVAJ_SLIKE);
		return posaljiVrati(tc);

	}

	public TransferKlasa vratiSliku(Hotel hotel) throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setOperacija(Operacije.VRATI_SLIKU);
		tc.setKlijent_object_request(hotel);
		return posaljiVrati(tc);
	}

	public TransferKlasa vratiSveHotele() throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setOperacija(Operacije.VRATI_SVE_HOTELE);

		return posaljiVrati(tc);
	}

	

	public TransferKlasa adresaHotela(Adresa adresa) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(adresa);
		transferKlasa.setOperacija(Operacije.HOTEL_ADRESA);
		return posaljiVrati(transferKlasa);
	}

	public TransferKlasa gradHotela(Grad grad) throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setKlijent_object_request(grad);
		tc.setOperacija(Operacije.GRAD_HOTEL);
		return posaljiVrati(tc);
	}

	public TransferKlasa DrzavaHotela(Drzava drzava) throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setKlijent_object_request(drzava);
		tc.setOperacija(Operacije.DRZAVA_HOTEL);
		return posaljiVrati(tc);
	}



	public TransferKlasa pretragaFull(HotelPretragaVrednosti pretragaVrednosti)
			throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setKlijent_object_request(pretragaVrednosti);
		tc.setOperacija(Operacije.HOTEL_PRETRAGA_FULL);
		return posaljiVrati(tc);
	}

	public TransferKlasa sacuvajRezervaciju(Rezervacije rezervacija) throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setKlijent_object_request(rezervacija);
		transferKlasa.setOperacija(Operacije.SACUVAJ_REZERVACIJU);
		return posaljiVrati(transferKlasa);

	}

	public TransferKlasa vratiSveSobeIzBaze() {
		// TODO Auto-generated method stub
		return null;
	}

	public TransferKlasa sacuvajSlikeSoba(SobaSlike photo) throws ClassNotFoundException, IOException {

		TransferKlasa tc = new TransferKlasa();
		tc.setKlijent_object_request(photo);
		tc.setOperacija(Operacije.SACUVAJ_SLIKE_SOBA);
		return posaljiVrati(tc);
	}

	public TransferKlasa vratiPoslednjuSobuIzBaze() throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setOperacija(Operacije.VRATI_POSLEDNJU_SOBU);
		return posaljiVrati(tc);

	}

	public TransferKlasa fullPretragaSvihSoba(Soba idHotela) throws ClassNotFoundException, IOException {
		TransferKlasa tc = new TransferKlasa();
		tc.setKlijent_object_request(idHotela);
		tc.setOperacija(Operacije.VRATI_FULL_SOBE);
		return posaljiVrati(tc);
	}

	public TransferKlasa vratiRezervacije() throws ClassNotFoundException, IOException {

		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_REZERVACIJE);
		return posaljiVrati(transferKlasa);
	}

	public TransferKlasa poslednjuRezervaciju() throws ClassNotFoundException, IOException {
		TransferKlasa transferKlasa = new TransferKlasa();
		transferKlasa.setOperacija(Operacije.VRATI_POSLEDNJU_REZERVACIJU);
		return posaljiVrati(transferKlasa);
	}

}
