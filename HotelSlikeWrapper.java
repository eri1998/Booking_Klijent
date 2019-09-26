package com.comtrade.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.comtrade.domen.Hotel;

public class HotelSlikeWrapper {
	private JButton btnNext;
	private JButton btnPrevius;
	private JButton viseInformacija;
	private Hotel hotel;
	private JLabel lblSlika;
	private int currentPosition = 0;
	public static int CURRENT = 0;
	public static int PREVIUS = 1;
	public static int NEXT = 2;

	public JButton getViseInformacija() {
		return viseInformacija;
	}

	public void setViseInformacija(JButton viseInformacija) {
		this.viseInformacija = viseInformacija;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JButton getBtnPrevius() {
		return btnPrevius;
	}

	public void setBtnPrevius(JButton btnPrevius) {
		this.btnPrevius = btnPrevius;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public JLabel getLblSlika() {
		return lblSlika;
	}

	public void setLblSlika(JLabel lblSlika) {
		this.lblSlika = lblSlika;
	}

	public void setSlika(int tipNavigacije) throws IOException {
		if (hotel.getUrlSlika().size() == 0) {
			return;
		}
		if (tipNavigacije == NEXT) {
			currentPosition++;
			if (currentPosition > hotel.getUrlSlika().size() - 1) {
				currentPosition = 0;
			}
		} else if (tipNavigacije == PREVIUS) {
			currentPosition--;
			if (currentPosition < 0) {
				currentPosition = hotel.getUrlSlika().size() - 1;
			}
		}

		String urlSlike = hotel.getUrlSlika().get(currentPosition);
		File sourceimage2 = new File(urlSlike);
		BufferedImage image2 = ImageIO.read(sourceimage2);
		Image scaled2 = image2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(scaled2);
		lblSlika.setIcon(icon2);
	}

}
