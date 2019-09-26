package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Label;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.comtrade.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.proxy.logovanje.IProxy;
import com.comtrade.proxy.logovanje.ProxyLogin;

import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class LogovanjeForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanjeForma frame = new LogovanjeForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogovanjeForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfEmail = new JTextField();
		tfEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfEmail.setText("");

			}
		});
		tfEmail.setText("Enter Email Adress");
		tfEmail.setBackground(new Color(153, 153, 153));
		tfEmail.setForeground(Color.GRAY);
		tfEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfEmail.setBorder(null);
		tfEmail.setOpaque(false);
		tfEmail.setBounds(386, 273, 120, 16);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 215, 0));
		separator_1.setBounds(386, 300, 279, 9);
		contentPane.add(separator_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(389, 321, 123, 14);
		contentPane.add(lblPassword);

		pfPassword = new JPasswordField();
		pfPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pfPassword.setText("");
			}
		});
		pfPassword
				.setText("\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF");
		pfPassword.setForeground(Color.GRAY);
		pfPassword.setBorder(null);
		pfPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		pfPassword.setOpaque(false);
		pfPassword.setBounds(386, 346, 276, 30);
		contentPane.add(pfPassword);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(255, 215, 0));
		separator_2.setBounds(386, 374, 277, 2);
		contentPane.add(separator_2);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(387, 242, 48, 14);
		contentPane.add(lblEmail);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(386, 147, 105, 14);
		contentPane.add(lblUsername);

		tfUsername = new JTextField();
		tfUsername.setText("Enter Username");
		tfUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfUsername.setText("");

			}
		});
		tfUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfUsername.setBackground(new Color(153, 153, 153));
		tfUsername.setForeground(Color.GRAY);
		tfUsername.setBorder(null);
		tfUsername.setOpaque(false);
		tfUsername.setBounds(385, 172, 278, 30);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 215, 0));
		separator.setBounds(386, 200, 276, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_4 = new JLabel("Register");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Berlin Sans FB", Font.ITALIC, 24));
		lblNewLabel_4.setBounds(556, 74, 107, 30);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistracijaForma rf = new RegistracijaForma();
				rf.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2
				.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/com/comtrade/view/slike/registruj se.png")));
		lblNewLabel_2.setBounds(522, 64, 165, 48);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = tfUsername.getText();
				String email = tfEmail.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				User user = new User();
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				IProxy iproxy = new ProxyLogin();

				try {
					iproxy.login(user);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Log in");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
		lblNewLabel_3.setBounds(505, 470, 75, 23);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_1.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/com/comtrade/view/slike/LOGINN.png")));
		lblNewLabel_1.setBounds(476, 453, 132, 60);
		contentPane.add(lblNewLabel_1);

		JLabel lblDodajteSvojObjekat = new JLabel("Dodajte svoj objekat");
		lblDodajteSvojObjekat.setForeground(new Color(255, 250, 250));
		lblDodajteSvojObjekat.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblDodajteSvojObjekat.setBounds(460, 411, 132, 14);
		contentPane.add(lblDodajteSvojObjekat);

		JLabel lblDodajObjekat = new JLabel("");
		lblDodajObjekat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistracijaForma rf = new RegistracijaForma();
				rf.setVisible(true);

			}
		});
		lblDodajObjekat.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/com/comtrade/view/slike/xx.png")));
		lblDodajObjekat.setBounds(419, 387, 279, 60);
		contentPane.add(lblDodajObjekat);

		JLabel label_1 = new JLabel("");
		label_1.setBackground(new Color(51, 153, 255));
		label_1.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/com/comtrade/view/slike/eveeega.png")));
		label_1.setBounds(354, 33, 422, 511);
		contentPane.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/com/comtrade/view/slike/OOO.png")));
		label.setBounds(15, 33, 422, 511);
		contentPane.add(label);
	}
}
