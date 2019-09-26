package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.Rectangle;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domen.Adresa;
import com.comtrade.domen.Drzava;
import com.comtrade.domen.Grad;
import com.comtrade.domen.Hotel;
import com.comtrade.domen.HotelPretragaVrednosti;
import com.comtrade.domen.Soba;
import com.comtrade.domen.TipSoba;
import com.comtrade.domen.User;
import com.comtrade.domen.Usluge;
import com.comtrade.domen.photos.Photo;
import com.comtrade.domen.pretraga.Pretraga;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.proxy.logovanje.IProxy;
import com.comtrade.proxy.logovanje.ProxyLogin;
import com.comtrade.view.rezervacije.RezervacijeForma;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;

public class Proba extends JFrame {

	private JPanel contentPane;
	private JTextField tfPretragaHotelNaziv;
	private List<Hotel> rezultati;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<HotelSlikeWrapper> listSlikeWrapper;
	private JCheckBox ck1z;
	private JCheckBox ck2z;
	private JCheckBox ck3z;
	private JCheckBox ck4z;
	private JCheckBox ck5z;
	private JCheckBox ckPlaza;
	private JCheckBox ckParking;
	private JCheckBox ckBazen;
	private JCheckBox ckSpa;
	private JCheckBox ckBar;
	private JCheckBox ckRestoran;
	private JCheckBox ckDorucak;
	private JCheckBox ckFitness;
	private JCheckBox ckNet;
	private JCheckBox ckPrevoz;
	private int idHotela;
	private JPanel panelResults;
	JPanel panelBtnDesni;
	private Image image;
	private JTextField tfPretragaDrzava;
	private JTextField tfPretragaGrad;
	private JLabel lblUnesiteNekeOd;
	private List<Soba> listSoba;
	private User user;

	public Proba(User user1) throws ClassNotFoundException, IOException {
		listSlikeWrapper = new ArrayList<HotelSlikeWrapper>();
		this.user = user1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 875);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfPretragaHotelNaziv = new JTextField();
		tfPretragaHotelNaziv.setBackground(new Color(192, 192, 192));
		tfPretragaHotelNaziv.setBounds(379, 39, 373, 20);
		contentPane.add(tfPretragaHotelNaziv);
		tfPretragaHotelNaziv.setColumns(10);
		panelResults = new JPanel();

		// panelResults.add(panelBtnDesni,BorderLayout.WEST);

		panelResults.setLayout(new BoxLayout(panelResults, BoxLayout.PAGE_AXIS));
		panelResults.setBorder(new MatteBorder(5, 5, 5, 5, Color.BLACK));

		JScrollPane spResults = new JScrollPane();
		panelResults.setBackground(new Color(100, 149, 237));
		UIManager.put("ScrollBar.background", new Color(100, 149, 237));
		UIManager.put("ScrollBar.foreground", new Color(100, 149, 237));
		spResults.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		spResults.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spResults.setBounds(154, 233, 482, 515);
		spResults.setViewportView(panelResults);
		contentPane.add(spResults);

		JButton btnCene = new JButton("Prikazi Cene");

		JButton btnTrazi = new JButton("Trazi");
		btnTrazi.setBackground(new Color(192, 192, 192));

		btnTrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelResults.removeAll();
				revalidate();
				repaint();
				pretrazi();
			}

		});

		btnTrazi.setBounds(493, 132, 121, 23);
		contentPane.add(btnTrazi);

		JLabel lblNazivHotela = new JLabel("Hotel:");
		lblNazivHotela.setFont(new Font("Engravers MT", Font.ITALIC, 14));
		lblNazivHotela.setForeground(new Color(100, 149, 237));
		lblNazivHotela.setBounds(283, 42, 97, 14);
		contentPane.add(lblNazivHotela);

		JLabel lblDrzava_1 = new JLabel("Drzava:");
		lblDrzava_1.setForeground(new Color(100, 149, 237));
		lblDrzava_1.setFont(new Font("Engravers MT", Font.ITALIC, 14));
		lblDrzava_1.setBounds(283, 73, 97, 14);
		contentPane.add(lblDrzava_1);

		tfPretragaDrzava = new JTextField();
		tfPretragaDrzava.setBackground(new Color(192, 192, 192));
		tfPretragaDrzava.setBounds(379, 70, 373, 20);
		contentPane.add(tfPretragaDrzava);
		tfPretragaDrzava.setColumns(10);

		JLabel lblGrad_1 = new JLabel("Grad:");
		lblGrad_1.setForeground(new Color(100, 149, 237));
		lblGrad_1.setFont(new Font("Engravers MT", Font.ITALIC, 14));
		lblGrad_1.setBounds(283, 104, 97, 14);
		contentPane.add(lblGrad_1);

		tfPretragaGrad = new JTextField();
		tfPretragaGrad.setBackground(new Color(192, 192, 192));
		tfPretragaGrad.setBounds(379, 101, 373, 20);
		contentPane.add(tfPretragaGrad);
		tfPretragaGrad.setColumns(10);
		JPanel panleFilterAdvanced = new JPanel();
		panleFilterAdvanced.setBackground(new Color(100, 149, 237));
		panleFilterAdvanced.setBorder(new MatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
		panleFilterAdvanced.setBounds(0, 0, 273, 155);
		contentPane.add(panleFilterAdvanced);
		panleFilterAdvanced.setLayout(null);

		// filter advanced
		ck1z = new JCheckBox("1 zvezdica");
		ck1z.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ck1z.setOpaque(false);
		ck2z = new JCheckBox("2 zvezdice");
		ck2z.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ck2z.setOpaque(false);
		ck3z = new JCheckBox("3 zvezdice");
		ck3z.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ck3z.setOpaque(false);
		ck4z = new JCheckBox("4 zvezdice");
		ck4z.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ck4z.setOpaque(false);
		ck5z = new JCheckBox("5 zvezdica");
		ck5z.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ck5z.setOpaque(false);
		ckPlaza = new JCheckBox("hoteli na plazi");
		ckPlaza.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckPlaza.setOpaque(false);

		ckParking = new JCheckBox("parking");
		ckParking.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckParking.setOpaque(false);

		ckBazen = new JCheckBox("bazen");
		ckBazen.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckBazen.setOpaque(false);

		ckSpa = new JCheckBox("spa");
		ckSpa.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckSpa.setOpaque(false);

		ckBar = new JCheckBox("bar");
		ckBar.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckBar.setOpaque(false);

		ckRestoran = new JCheckBox("restoran");
		ckRestoran.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckRestoran.setOpaque(false);

		ckDorucak = new JCheckBox("dorucak");
		ckDorucak.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckDorucak.setOpaque(false);

		ckFitness = new JCheckBox("fitness center");
		ckFitness.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckFitness.setOpaque(false);

		ckNet = new JCheckBox("internet");
		ckNet.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckNet.setOpaque(false);

		ckPrevoz = new JCheckBox("airport shuttle");
		ckPrevoz.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 13));
		ckPrevoz.setOpaque(false);

		ck1z.setBounds(6, 28, 78, 23);
		panleFilterAdvanced.add(ck1z);

		ck2z.setBounds(6, 51, 78, 23);
		panleFilterAdvanced.add(ck2z);

		ck3z.setBounds(6, 77, 78, 23);
		panleFilterAdvanced.add(ck3z);

		ck4z.setBounds(6, 103, 78, 23);
		panleFilterAdvanced.add(ck4z);

		ck5z.setBounds(6, 129, 87, 23);
		panleFilterAdvanced.add(ck5z);

		ckPlaza.setBounds(165, 103, 102, 23);
		panleFilterAdvanced.add(ckPlaza);

		ckParking.setBounds(94, 28, 69, 23);
		panleFilterAdvanced.add(ckParking);

		ckBazen.setBounds(94, 51, 69, 23);
		panleFilterAdvanced.add(ckBazen);

		ckSpa.setBounds(94, 77, 59, 23);
		panleFilterAdvanced.add(ckSpa);

		ckBar.setBounds(94, 103, 52, 23);
		panleFilterAdvanced.add(ckBar);

		ckRestoran.setBounds(165, 129, 102, 23);
		panleFilterAdvanced.add(ckRestoran);

		ckDorucak.setBounds(165, 28, 87, 23);
		panleFilterAdvanced.add(ckDorucak);

		ckFitness.setBounds(165, 77, 97, 23);
		panleFilterAdvanced.add(ckFitness);

		ckNet.setBounds(95, 129, 97, 23);
		panleFilterAdvanced.add(ckNet);

		JLabel lblBrojZvezdica = new JLabel("Broj zvezdica:");
		lblBrojZvezdica.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 14));
		lblBrojZvezdica.setBounds(10, 9, 213, 14);
		panleFilterAdvanced.add(lblBrojZvezdica);
		ckPrevoz.setBounds(165, 51, 108, 23);

		panleFilterAdvanced.add(ckPrevoz);

		JLabel lblNewLabel_3 = new JLabel("Usluge:");
		lblNewLabel_3.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(131, 3, 88, 26);
		panleFilterAdvanced.add(lblNewLabel_3);

		lblUnesiteNekeOd = new JLabel("Pretrazite pomocu neka od tri moguca nacina");
		lblUnesiteNekeOd.setForeground(new Color(100, 149, 237));
		lblUnesiteNekeOd.setFont(new Font("Engravers MT", Font.ITALIC, 14));
		lblUnesiteNekeOd.setBounds(283, 11, 506, 14);
		contentPane.add(lblUnesiteNekeOd);

		JLabel lblPozadina = new JLabel("");
		lblPozadina.setIcon(new ImageIcon(Proba.class.getResource("/com/comtrade/view/slike/black.jpg")));
		lblPozadina.setBounds(0, 0, 799, 837);
		contentPane.add(lblPozadina);

	}

	private int getCheckBoxValue(JCheckBox ck) {
		if (ck.isSelected()) {
			return 1;
		}

		return 0;
	}

	private void pretrazi() {
		HotelPretragaVrednosti pretraga = new HotelPretragaVrednosti();
		pretraga.setHotela(tfPretragaHotelNaziv.getText());
		pretraga.setDrzava(tfPretragaDrzava.getText());
		pretraga.setGrad(tfPretragaGrad.getText());

		List<Integer> brojZvezdica = new ArrayList<Integer>();

		if (getCheckBoxValue(ck1z) == 1) {
			brojZvezdica.add(1);
		}

		if (getCheckBoxValue(ck2z) == 1) {
			brojZvezdica.add(2);
		}

		if (getCheckBoxValue(ck3z) == 1) {
			brojZvezdica.add(3);
		}

		if (getCheckBoxValue(ck4z) == 1) {
			brojZvezdica.add(4);
		}

		if (getCheckBoxValue(ck5z) == 1) {
			brojZvezdica.add(5);
		}

		pretraga.setBrojZvezdica(brojZvezdica);

		pretraga.setNaPlazi(getCheckBoxValue(ckPlaza));
		pretraga.setParking(getCheckBoxValue(ckParking));
		pretraga.setBazen(getCheckBoxValue(ckBazen));
		pretraga.setSpa(getCheckBoxValue(ckSpa));
		pretraga.setBar(getCheckBoxValue(ckBar));
		pretraga.setDorucak(getCheckBoxValue(ckDorucak));
		pretraga.setAirportShuttle(getCheckBoxValue(ckPrevoz));
		pretraga.setInternet(getCheckBoxValue(ckNet));
		pretraga.setFitness(getCheckBoxValue(ckFitness));

		try {
			rezultati = (List<Hotel>) KontrolerKI.getInstanca().pretragaFull(pretraga).getServer_object_response();
			// postaviPanel(rezultati);
			prikaziUI(rezultati);

		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}

	private void prikaziUI(List<Hotel> rezultati2) throws IOException {

		JLabel lblNaziv = null;
		JLabel lblDrzava;
		JLabel lblGrad;
		JLabel lblAdresa;
		JLabel lblBroj = null;
		JLabel lblPic;
		JLabel linija;
		JButton viseInformacija;
		HotelSlikeWrapper hotelSlikeWrapper = null;
		int picSize = 220;
		int picInitY = 110;
		int lblDrzavaSize = 230;
		int lblDrzavaInitY = 83;
		int lblGradSize = 228;
		int lblGradInitY = 104;
		int lblAdresaSize = 230;
		int lblAdresaInitY = 124;
		int lblBrojSize = 225;
		int lblBrojInitY = 39;
		JButton levo, desno;

		for (int i = 0; i < rezultati2.size(); i++) {
			hotelSlikeWrapper = new HotelSlikeWrapper();
			listSlikeWrapper.add(hotelSlikeWrapper);
			hotelSlikeWrapper.setHotel(rezultati2.get(i));

			lblNaziv = new JLabel();
			lblNaziv.setText(hotelSlikeWrapper.getHotel().getNaziv());
			lblNaziv.setForeground(Color.LIGHT_GRAY);
			lblNaziv.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
			panelResults.add(lblNaziv);
			lblNaziv.setAlignmentX(Component.CENTER_ALIGNMENT);

			String urlSlike = null;

			int brojZvezdica = hotelSlikeWrapper.getHotel().getBrojZvezdica();
			if (brojZvezdica == 1) {
				urlSlike = ("C:\\Users\\win7\\eclipse-workspace\\Server\\folder\\1zvezdice.png");
			}
			if (brojZvezdica == 2) {
				urlSlike = ("C:\\Users\\win7\\eclipse-workspace\\Server\\folder\\2zvezdice.png");
			}
			if (brojZvezdica == 3) {
				urlSlike = ("C:\\Users\\win7\\eclipse-workspace\\Server\\folder\\3zvezdice.png");
			}
			if (brojZvezdica == 4) {
				urlSlike = ("C:\\Users\\win7\\eclipse-workspace\\Server\\folder\\4zvezdice.png");
			}
			if (brojZvezdica == 5) {
				urlSlike = ("C:\\Users\\win7\\eclipse-workspace\\Server\\folder\\5zvezdice.png");
			}

			lblBroj = new JLabel();

			File sourceimage = new File(urlSlike);
			BufferedImage image = ImageIO.read(sourceimage);
			Image scaled = image.getScaledInstance(80, 32, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaled);
			lblBroj.setIcon(icon);
			lblBroj.setForeground(Color.GREEN);
			lblBroj.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBroj.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelResults.add(lblBroj);

			hotelSlikeWrapper.setLblSlika(new JLabel());

			hotelSlikeWrapper.getLblSlika().setAlignmentX(Component.CENTER_ALIGNMENT);

			panelResults.add(hotelSlikeWrapper.getLblSlika());
			hotelSlikeWrapper.setSlika(HotelSlikeWrapper.CURRENT);
			//

			panelBtnDesni = new JPanel();
			panelBtnDesni.setLayout(new GridBagLayout());

			panelBtnDesni.setBackground(new Color(100, 149, 237));

			levo = new JButton();

			panelBtnDesni.add(levo);
			panelResults.add(panelBtnDesni);
			hotelSlikeWrapper.setBtnNext(levo);
			levo.setText("<<");
			levo.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					navigationButtonClicked((JButton) e.getSource(), HotelSlikeWrapper.NEXT);

				}
			});
			desno = new JButton();
			panelBtnDesni.add(desno);
			panelResults.add(panelBtnDesni);
			hotelSlikeWrapper.setBtnPrevius(desno);
			desno.setText(">>");

			desno.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					navigationButtonClicked((JButton) e.getSource(), HotelSlikeWrapper.PREVIUS);
				}
			});

			lblDrzava = new JLabel();
			lblDrzava.setText("Drzava" + ":" + hotelSlikeWrapper.getHotel().getNazivDrzave());
			lblDrzava.setForeground(Color.LIGHT_GRAY);
			lblDrzava.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDrzava.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelResults.add(lblDrzava);

			lblGrad = new JLabel();
			lblGrad.setText("Grad" + ":" + hotelSlikeWrapper.getHotel().getNazivGrada());
			lblGrad.setForeground(Color.LIGHT_GRAY);
			lblGrad.setFont(new Font("Tahoma ", Font.PLAIN, 16));
			lblGrad.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelResults.add(lblGrad);

			lblAdresa = new JLabel();
			lblAdresa.setText("Adresa" + ":" + hotelSlikeWrapper.getHotel().getUlica() + " /" + "Broj :"
					+ hotelSlikeWrapper.getHotel().getBroj());
			lblAdresa.setForeground(Color.LIGHT_GRAY);
			lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
			panelResults.add(lblAdresa);
			lblAdresa.setAlignmentX(Component.CENTER_ALIGNMENT);

			viseInformacija = new JButton();
			hotelSlikeWrapper.setViseInformacija(viseInformacija);
			viseInformacija.setAlignmentX(CENTER_ALIGNMENT);
			Dimension d = lblBroj.getMaximumSize();

			viseInformacija.setMaximumSize(d);
			viseInformacija.setText("Cene");

			viseInformacija.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					try {

						HotelSlikeWrapper hotelSlikeWrapper = getHotelWrapper(e.getSource());
						if (hotelSlikeWrapper != null) {

							RezervacijeForma rf = new RezervacijeForma(hotelSlikeWrapper.getHotel(), user);
							rf.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Nece moci");
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			});

			panelResults.add(viseInformacija);

			linija = new JLabel();

			panelResults.add(linija);
			linija.setBorder(new MatteBorder(36, 0, 0, 0, Color.BLACK));
			linija.setAlignmentX(CENTER_ALIGNMENT);
			linija.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblBroj.getMaximumSize().width));

		}
	}

	private HotelSlikeWrapper getHotelWrapper(Object kontrol) {
		for (int i = 0; i < listSlikeWrapper.size(); i++) {

			if (kontrol == listSlikeWrapper.get(i).getBtnPrevius() || kontrol == listSlikeWrapper.get(i).getBtnNext()
					|| kontrol == listSlikeWrapper.get(i).getViseInformacija()) {
				return listSlikeWrapper.get(i);
			}
		}
		return null;
	}

	private void navigationButtonClicked(JButton button, int navigationType) {

		try {
			HotelSlikeWrapper hotelWrapper = getHotelWrapper(button);
			if (hotelWrapper != null) {
				hotelWrapper.setSlika(navigationType);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
