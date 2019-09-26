package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.transferKlasa.TransferKlasa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RegistracijaForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JTextField tfImePrezime;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JPasswordField pfPassword1;
	private JCheckBox chckbxNewCheckBox;
	private User user;

	private void setujPasswordFieldNa8karaktera(MouseEvent e) {
		JPasswordField field = (JPasswordField) e.getSource();
		char[] password = field.getPassword();
		if (password.length < 8) {
			JOptionPane.showMessageDialog(null, "Sifra mora imati najmanje 8 karaktera");

			field.setText("");
		}

	}

	public RegistracijaForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(46, 23, 505, 511);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setForeground(new Color(255, 215, 0));
		lblNewLabel_6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblNewLabel_6.setBounds(107, 74, 36, 19);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("*");
		lblNewLabel_7.setForeground(new Color(255, 215, 0));
		lblNewLabel_7.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblNewLabel_7.setBounds(328, 74, 22, 19);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel = new JLabel("Create a new Account");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Ravie", Font.PLAIN, 22));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBounds(72, 41, 326, 60);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("It's free and always will be");
		lblNewLabel_1.setFont(new Font("Ravie", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setBounds(124, 74, 274, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(169, 212, 90, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 215, 0));
		lblNewLabel_3.setBounds(169, 268, 109, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Confirm password");
		lblNewLabel_4.setForeground(new Color(255, 215, 0));
		lblNewLabel_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(158, 320, 120, 19);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Full name");
		lblNewLabel_5.setForeground(new Color(255, 215, 0));
		lblNewLabel_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(171, 156, 78, 14);
		panel.add(lblNewLabel_5);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(255, 215, 0));
		lblEmail.setBounds(181, 88, 90, 19);
		panel.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfEmail.setText("");
			}
		});
		tfEmail.setText("Enter email");
		tfEmail.setForeground(new Color(230, 230, 250));
		tfEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfEmail.setBorder(null);
		tfEmail.setOpaque(false);
		tfEmail.setBounds(107, 118, 234, 23);
		panel.add(tfEmail);
		tfEmail.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 128, 128));
		separator.setBounds(109, 149, 234, 14);
		panel.add(separator);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.GRAY);
		separator_4.setBounds(107, 366, 234, 14);
		panel.add(separator_4);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(109, 265, 234, 14);
		panel.add(separator_2);

		tfImePrezime = new JTextField();
		tfImePrezime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfImePrezime.setText("");
			}
		});
		tfImePrezime.setText("Enter name and surname ");
		tfImePrezime.setForeground(new Color(230, 230, 250));
		tfImePrezime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfImePrezime.setBorder(null);
		tfImePrezime.setOpaque(false);
		tfImePrezime.setBounds(107, 181, 232, 20);
		panel.add(tfImePrezime);
		tfImePrezime.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.GRAY);
		separator_3.setBounds(109, 319, 234, 14);
		panel.add(separator_3);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(109, 209, 234, 14);
		panel.add(separator_1);

		tfUsername = new JTextField();
		tfUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfUsername.setText("");
			}
		});
		tfUsername.setText("Enter username");
		tfUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfUsername.setForeground(new Color(230, 230, 250));
		tfUsername.setBorder(null);
		tfUsername.setOpaque(false);
		tfUsername.setBounds(107, 237, 232, 20);
		panel.add(tfUsername);
		tfUsername.setColumns(10);

		pfPassword = new JPasswordField();

		pfPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pfPassword.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setujPasswordFieldNa8karaktera(e);

			}

		});
		pfPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		pfPassword.setForeground(new Color(230, 230, 250));
		pfPassword
				.setText("\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF");
		pfPassword.setBorder(null);
		pfPassword.setOpaque(false);
		pfPassword.setBounds(109, 293, 232, 20);
		panel.add(pfPassword);

		pfPassword1 = new JPasswordField();

		pfPassword1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pfPassword1.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setujPasswordFieldNa8karaktera(e);
			}

		});
		pfPassword1
				.setText("\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF");
		pfPassword1.setForeground(new Color(230, 230, 250));
		pfPassword1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		pfPassword1.setBorder(null);
		pfPassword1.setOpaque(false);
		pfPassword1.setBounds(109, 350, 232, 20);
		panel.add(pfPassword1);

		JLabel lblNewLabel_8 = new JLabel("Agree");
		lblNewLabel_8.setForeground(new Color(255, 250, 250));
		lblNewLabel_8.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(151, 410, 48, 14);
		panel.add(lblNewLabel_8);

		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(124, 379, 22, 13);
		panel.add(chckbxNewCheckBox);

		JCheckBox cbUslovi = new JCheckBox("");
		cbUslovi.setBackground(new Color(230, 230, 250));
		cbUslovi.setBounds(124, 410, 21, 14);
		panel.add(cbUslovi);

		JLabel lblNewLabel_9 = new JLabel("<html>\r\n<body>\r\n<u>Terms and conditions</u>\r\n</body>\r\n</html>");
		lblNewLabel_9.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_9.setForeground(new Color(255, 215, 0));
		lblNewLabel_9.setBounds(190, 410, 144, 14);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_11 = new JLabel("Sign up");
		lblNewLabel_11.setFont(new Font("Berlin Sans FB", Font.ITALIC, 17));
		lblNewLabel_11.setForeground(new Color(255, 250, 250));
		lblNewLabel_11.setBounds(201, 446, 59, 19);
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String email = tfEmail.getText();
				String fullName = tfImePrezime.getText();
				String username = tfUsername.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				String pass = String.copyValueOf(pfPassword1.getPassword());

				if (!cbUslovi.isSelected()) {
					JOptionPane.showMessageDialog(null, "Niste prihvatili uslove");
				}
				while (cbUslovi.isSelected())

					if (password.equals(pass) && !chckbxNewCheckBox.isSelected()) {

						dodeli(username, password, email, fullName);
						user.setStatus("SUPER USER");

						proslediKorisnika(user);
						vratiNaLogovanjeFormu();
						break;

					} else if (password.equals(pass) && chckbxNewCheckBox.isSelected()) {

						dodeli(username, password, email, fullName);
						user.setStatus("USER");

						proslediKorisnika(user);
						vratiNaLogovanjeFormu();
						break;

					}

					else {
						JOptionPane.showMessageDialog(null, "Sifre se ne podudaraju ");
						break;
					}

			}

			private void vratiNaLogovanjeFormu() {
				LogovanjeForma lf = new LogovanjeForma();
				lf.setVisible(true);

			}

		});

		lblNewLabel_10.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_10.setForeground(new Color(255, 250, 250));
		lblNewLabel_10.setIcon(
				new ImageIcon(RegistracijaForma.class.getResource("/com/comtrade/view/slike/DugmePosalji.png")));
		lblNewLabel_10.setBounds(158, 436, 120, 41);
		panel.add(lblNewLabel_10);

		JLabel lblNewLabel_12 = new JLabel(
				"<html>\r\n<body>\r\n<b>if you want to register only for list your property\r\n select this comboBox</b>\r\n</body>\r\n</html>");
		lblNewLabel_12.setForeground(new Color(255, 250, 250));
		lblNewLabel_12.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		lblNewLabel_12.setBounds(155, 369, 212, 41);
		panel.add(lblNewLabel_12);

		JLabel lblSlika = new JLabel("");
		lblSlika.setForeground(new Color(230, 230, 250));
		lblSlika.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSlika.setBorder(null);
		lblSlika.setIcon(new ImageIcon(RegistracijaForma.class.getResource("/com/comtrade/view/slike/11.png")));
		lblSlika.setBounds(30, 0, 441, 489);
		panel.add(lblSlika);
	}

	public void ocistiPolja() {
		tfEmail.setText("");
		tfImePrezime.setText("");
		tfUsername.setText("");
		pfPassword.setText("");
		pfPassword1.setText("");
	}

	public void proslediKorisnika(User user) {

		try {
			TransferKlasa transferKlasa = KontrolerKI.getInstanca().sacuvajKorisnika(user);
			String poruka = transferKlasa.getPoruka_response();
			JOptionPane.showMessageDialog(null, poruka);
			ocistiPolja();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void dodeli(String username, String password, String email, String fullName) {
		user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		user.setFullName(fullName);
	}
}