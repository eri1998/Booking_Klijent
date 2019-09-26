package com.comtrade.proxy.logovanje;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.comtrade.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.view.Proba;
import com.comtrade.view.admin.AdminForma;
import com.comtrade.view.hotel.HotelForma;

public class ProxyLogin implements IProxy {
	private static final String USER = "USER";
	private static final String SUPER_USER = "SUPER USER";
	private static final String ADMIN = "ADMIN";

	@Override
	public void login(User user) throws ClassNotFoundException, IOException {
		User user1 = (User) KontrolerKI.getInstanca().login(user).getServer_object_response();
		if (user1.getUsername() != null && user1.getPassword() != null && user1.getEmail() != null
				&& user1.getStatus().equals(USER)) {
			HotelForma hotelForma = new HotelForma(user1);
			hotelForma.setVisible(true);

		} else if (user1.getUsername() != null && user1.getPassword() != null && user1.getEmail() != null
				&& user1.getStatus().equals(SUPER_USER)) {
			Proba proba = new Proba(user1);
			proba.setVisible(true);
		} else if (user1.getUsername() != null && user1.getPassword() != null && user1.getEmail() != null
				&& user1.getStatus().equals(ADMIN)) {
			AdminForma af = new AdminForma();
			af.setVisible(true);
		}

		else {
			JOptionPane.showMessageDialog(null, "Neuspesno logovanje,kreirajte nalog ukoliko niste");
		}

	}

}
