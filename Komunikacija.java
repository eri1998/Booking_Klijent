package com.comtrade.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.comtrade.konstante.Konstante;
import com.comtrade.transferKlasa.TransferKlasa;

public class Komunikacija {
	private Socket socket;
	private static Komunikacija instanca;

	private Komunikacija() {
		try {
			socket = new Socket(Konstante.IP_ADRESA.getIp_adresa(), Konstante.PORT.getPort());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Komunikacija getInstanca() {
		if (instanca == null) {
			instanca = new Komunikacija();
		}
		return instanca;
	}

	public void posaljiNaServer(TransferKlasa transferKlasa) {

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferKlasa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TransferKlasa procitajSaServera() throws ClassNotFoundException, IOException {

		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		return (TransferKlasa) objectInputStream.readObject();

	}

}
