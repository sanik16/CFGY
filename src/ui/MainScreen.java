package ui;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;
import RUN.Project;

import javax.swing.JScrollPane;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTextField menoField;
	private JTextField priezviskoField;
	private JTextField ageField;
	private JTextField emailField;
	private JTextField emailAdressField;
	private JTextField passwdField;
	private JTextField textWeight;
	private JTextField textHeigh;
	private JTextField textBench;
	private JTextField textBack;
	private JTextField textFront;
	private JTextField textClean;
	private JTextField textSnatch;
	private JTextField textPull;
	private JTable tableProfil;
	private JTable tableShop;

	
	public static void ui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	Connection conn = null;    //inicializacia pripojenia na sql
	private JPasswordField passwordField;
	private JTable tableHistory_shop;
	private JTable tableHistory_train;
	private JTable tableHistory_perm;
	private JTable tableShopping_card;
	
	public void refreshTable(){									////funkcia na refresh tabulky.....
		try{
			String query = "select weight, heigh, bench, back, front, clean, snatch, pull from profil where id_user = 1  "; 
			
    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
    		ResultSet rs = pst.executeQuery();
    		
    		tableProfil.setModel(DbUtils.resultSetToTableModel(rs));
			
    		rs.close();
	    	pst.close();
    		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public MainScreen() throws Exception {
		
		getContentPane().setLayout(new CardLayout(0, 0));
		conn = Project.getConnection();  						//pripojenie na MySQL.......
		
		JPanel panelHome = new JPanel();
		getContentPane().add(panelHome, "name_94569231393008");
		panelHome.setLayout(null);
		
		JLabel lblHome = new JLabel("Crossfit Bratislava");
		lblHome.setBackground(Color.BLACK);
		lblHome.setForeground(Color.RED);
		lblHome.setFont(new Font("DilleniaUPC", Font.BOLD | Font.ITALIC, 56));
		lblHome.setBounds(144, 190, 312, 79);
		panelHome.add(lblHome);
	
		JButton btnSignUp = new JButton("Sign In!");
		btnSignUp.setForeground(Color.BLUE);
		Image img1 = new ImageIcon(this.getClass().getResource("/cinka.png")).getImage();    //vytlacenie uvodneho obrazku
		btnSignUp.setIcon(new ImageIcon(img1));	
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnSignUp.setBounds(227, 387, 139, 37);
		panelHome.add(btnSignUp);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmail.setBounds(163, 268, 70, 28);
		panelHome.add(lblEmail);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(163, 309, 84, 28);
		panelHome.add(lblPassword);
		
		emailField = new JTextField();
		emailField.setBounds(245, 269, 168, 28);
		panelHome.add(emailField);
		emailField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnRegister.setBounds(475, 396, 91, 28);
		panelHome.add(btnRegister);
		
		JLabel labelObrazok1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/uvod.png")).getImage();    //vytlacenie uvodneho obrazku
		labelObrazok1.setIcon(new ImageIcon(img));
		labelObrazok1.setBounds(144, 26, 296, 151);
		panelHome.add(labelObrazok1);
		
		JCheckBox chckbxRemember = new JCheckBox("Remember?");
		chckbxRemember.setFont(new Font("Times New Roman", Font.BOLD, 13));
		chckbxRemember.setBounds(163, 353, 113, 25);
		panelHome.add(chckbxRemember);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setBounds(142, 26, 151, 24);
		panelHome.add(mntmNewMenuItem);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(245, 309, 168, 28);
		panelHome.add(passwordField);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 521);
		
		JPanel panelHistory_perma = new JPanel();
		getContentPane().add(panelHistory_perma, "name_274286657908574");
		panelHistory_perma.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("History of perms");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_2.setBounds(164, 13, 276, 47);
		panelHistory_perma.add(lblNewLabel_2);
		
		JScrollPane scrollPaneHistoryPerm = new JScrollPane();
		scrollPaneHistoryPerm.setBounds(167, 92, 407, 343);
		panelHistory_perma.add(scrollPaneHistoryPerm);
		
		tableHistory_perm = new JTable();
		scrollPaneHistoryPerm.setViewportView(tableHistory_perm);
		
		JButton btnShowHistoryPerm = new JButton("Show history");
		btnShowHistoryPerm.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnShowHistoryPerm.setBounds(12, 92, 143, 36);
		panelHistory_perma.add(btnShowHistoryPerm);
		
		JButton btnPocetPerm = new JButton("Pocet permanentiek");
		btnPocetPerm.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnPocetPerm.setBounds(12, 141, 143, 38);
		panelHistory_perma.add(btnPocetPerm);
		
		JPanel panelTrainings = new JPanel();
		getContentPane().add(panelTrainings, "name_93354104734993");
		panelTrainings.setLayout(null);
		
		JButton btnOpenGym = new JButton("Open Gym");
		btnOpenGym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOpenGym.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnOpenGym.setBounds(27, 49, 120, 29);
		panelTrainings.add(btnOpenGym);
		
		JButton btnCrossfit = new JButton("Crossfit");
		btnCrossfit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnCrossfit.setBounds(27, 116, 120, 29);
		panelTrainings.add(btnCrossfit);
		
		JButton btnLifting = new JButton("Lifting");
		btnLifting.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLifting.setBounds(27, 183, 120, 29);
		panelTrainings.add(btnLifting);
		
		JButton btnYoga = new JButton("Yoga");
		btnYoga.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnYoga.setBounds(27, 251, 120, 29);
		panelTrainings.add(btnYoga);
		
		JButton btnBeginners = new JButton("Beginners");
		btnBeginners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBeginners.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBeginners.setBounds(27, 321, 120, 29);
		panelTrainings.add(btnBeginners);
		
		JButton btnCompetitor = new JButton("Competitors");
		btnCompetitor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCompetitor.setBounds(27, 386, 120, 29);
		panelTrainings.add(btnCompetitor);
		
		JPanel panelBegginers = new JPanel();
		panelBegginers.setBounds(176, 0, 398, 448);
		panelTrainings.add(panelBegginers);
		panelBegginers.setLayout(null);
		
		JLabel lblBeginners = new JLabel("Beginners");
		lblBeginners.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblBeginners.setBounds(113, 13, 198, 56);
		panelBegginers.add(lblBeginners);
		
		JButton btnBeginners_join = new JButton("Join me!");
		btnBeginners_join.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnBeginners_join.setBounds(131, 384, 129, 37);
		panelBegginers.add(btnBeginners_join);
		
		JTextPane txtpnNaKurzeSa = new JTextPane();
		txtpnNaKurzeSa.setEditable(false);
		txtpnNaKurzeSa.setBackground(SystemColor.menu);
		txtpnNaKurzeSa.setText("Na kurze sa venujeme hlavne technike cvikov, postupne sa zoznamujeme s intenzitou a princ\u00EDpami CrossFitu. CrossFit je okrem cvi\u010Denia a pos\u00FAvania svojich hran\u00EDc aj o komunite. Je pre n\u00E1s ve\u013Emi d\u00F4le\u017Eit\u00E9, aby ste sa u n\u00E1s po\u010Das kurzu c\u00EDtili ako doma, zozn\u00E1mili sa s ostatn\u00FDmi cvi\u010Dencami. Cena 4 Eur");
		txtpnNaKurzeSa.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnNaKurzeSa.setBounds(50, 246, 311, 125);
		panelBegginers.add(txtpnNaKurzeSa);
		
		JLabel lblBeginners_obr = new JLabel("");
		Image img_cx = new ImageIcon(this.getClass().getResource("/Beginn.jpg")).getImage();    //vytlacenie uvodneho obrazku
		lblBeginners_obr.setIcon(new ImageIcon(img_cx));
		lblBeginners_obr.setBounds(104, 94, 207, 125);
		panelBegginers.add(lblBeginners_obr);
		
		JPanel panelLifting = new JPanel();
		panelLifting.setBounds(176, 0, 406, 448);
		panelTrainings.add(panelLifting);
		panelLifting.setLayout(null);
		
		JLabel lblLifting = new JLabel("Lifting");
		lblLifting.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblLifting.setBounds(148, 13, 140, 58);
		panelLifting.add(lblLifting);
		
		JTextPane textLifting = new JTextPane();
		textLifting.setText("Vzpieranie je alfa omega v\u0161etk\u00E9ho silov\u00E9ho tr\u00E9ningu. Obsahuje v\u0161etko od flexibility cez v\u00FDbu\u0161nos\u0165 a\u017E po silu. Napriek tomuto k\u013E\u00FA\u010Dov\u00E9mu postaveniu je len mal\u00E1 h\u0155stka \u013Eud\u00ED, ktor\u00E1 vzpieraniu prepadla a objavila jeho \u010Daro. CrossFit t\u00FAto skuto\u010Dnos\u0165 na\u0161\u0165astie men\u00ED a vzpieranie rob\u00ED znovu popul\u00E1rnym.  Cena 4 Eur");
		textLifting.setBackground(SystemColor.menu);
		textLifting.setEditable(false);
		textLifting.setFont(new Font("Tahoma", Font.BOLD, 12));
		textLifting.setBounds(50, 258, 325, 108);
		panelLifting.add(textLifting);
		
		JButton btnLifting_join = new JButton("Join me!");
		btnLifting_join.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnLifting_join.setBounds(138, 379, 150, 39);
		panelLifting.add(btnLifting_join);
		
		JLabel lblLifting_obr = new JLabel("");
		Image img_dz = new ImageIcon(this.getClass().getResource("/Lifting.jpg")).getImage();    //vytlacenie uvodneho obrazku
		lblLifting_obr.setIcon(new ImageIcon(img_dz));
		lblLifting_obr.setBounds(108, 71, 188, 174);
		panelLifting.add(lblLifting_obr);
		
		JPanel panelOpenGym = new JPanel();
		panelOpenGym.setBounds(176, 0, 410, 448);
		panelTrainings.add(panelOpenGym);
		panelOpenGym.setLayout(null);
		
		JLabel lblOpenGym = new JLabel("Open Gym");
		lblOpenGym.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblOpenGym.setBounds(118, 13, 192, 60);
		panelOpenGym.add(lblOpenGym);
		
		JButton btnOpenGym_prihlas = new JButton("Join me!");
		btnOpenGym_prihlas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnOpenGym_prihlas.setBounds(118, 373, 154, 44);
		panelOpenGym.add(btnOpenGym_prihlas);
		
		JTextPane textOpenGym = new JTextPane();
		textOpenGym.setBackground(SystemColor.menu);
		textOpenGym.setEditable(false);
		textOpenGym.setFont(new Font("Tahoma", Font.BOLD, 14));
		textOpenGym.setText("M\u00F4\u017Ee\u0161 sa pr\u00EDs\u0165 vybl\u00E1zni\u0165 v \u013Eubovo\u013Enom \u010Dase po\u010Das otv\u00E1rac\u00EDch hod\u00EDn gymu. Cena 3 Eur");
		textOpenGym.setBounds(57, 280, 315, 69);
		panelOpenGym.add(textOpenGym);
		
		JLabel labelOpenGym_obr = new JLabel("");
		Image img_dd = new ImageIcon(this.getClass().getResource("/Open_zena.jpg")).getImage();    //vytlacenie uvodneho obrazku
		labelOpenGym_obr.setIcon(new ImageIcon(img_dd));
		labelOpenGym_obr.setBounds(85, 108, 225, 148);
		panelOpenGym.add(labelOpenGym_obr);
		
		JPanel panelCrossfit = new JPanel();
		panelCrossfit.setBounds(176, 0, 410, 448);
		panelTrainings.add(panelCrossfit);
		panelCrossfit.setLayout(null);
		
		JButton btnCrossfit_prihlas = new JButton("Add me!");
		btnCrossfit_prihlas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCrossfit_prihlas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnCrossfit_prihlas.setBounds(108, 386, 161, 49);
		panelCrossfit.add(btnCrossfit_prihlas);
		
		JLabel lblCrossfit_nazov = new JLabel("Crossfit");
		lblCrossfit_nazov.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblCrossfit_nazov.setBounds(108, 13, 161, 61);
		panelCrossfit.add(lblCrossfit_nazov);
		
		JTextPane txtpnCrossfit_sub = new JTextPane();
		txtpnCrossfit_sub.setBackground(SystemColor.menu);
		txtpnCrossfit_sub.setEditable(false);
		txtpnCrossfit_sub.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnCrossfit_sub.setText("Inform\u00E1cie o tr\u00E9ningu\r\n\r\n\u010Cak\u00E1 na V\u00E1s pln\u00FD tr\u00E9ningov\u00FD re\u017Eim, venujeme sa tu technik\u00E1m cvikov, rozvoju sily, aer\u00F3bnej zdatnosti, obratnosti. Nikdy neviete na \u010Do sa te\u0161i\u0165, a\u017E k\u00FDm WOD neuvid\u00EDte na tabuli. Tr\u00E9ningy pripravujeme dopredu a programovo na seba nadv\u00E4zuj\u00FA. Cena 4 Eur");
		txtpnCrossfit_sub.setBounds(30, 221, 348, 138);
		panelCrossfit.add(txtpnCrossfit_sub);
		
		JLabel lblCrossfit_pic = new JLabel("");
		Image img_1 = new ImageIcon(this.getClass().getResource("/Crossfit.jpg")).getImage();    //vytlacenie uvodneho obrazku
		lblCrossfit_pic.setIcon(new ImageIcon(img_1));
		lblCrossfit_pic.setBounds(51, 87, 285, 121);
		panelCrossfit.add(lblCrossfit_pic);
		
		
		JPanel panelRegister = new JPanel();
		panelRegister.setForeground(Color.BLACK);
		getContentPane().add(panelRegister, "name_346286455676864");
		panelRegister.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setBounds(200, 24, 191, 43);
		panelRegister.add(lblNewLabel);

		JLabel lblMeno = new JLabel("*Name:");
		lblMeno.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblMeno.setBounds(44, 92, 72, 16);
		panelRegister.add(lblMeno);

		JLabel lblPriezvisko = new JLabel("*Surname:");
		lblPriezvisko.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPriezvisko.setBounds(44, 135, 88, 16);
		panelRegister.add(lblPriezvisko);

		JLabel lblSkill = new JLabel("Skill:");
		lblSkill.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblSkill.setBounds(44, 320, 72, 16);
		panelRegister.add(lblSkill);

		JLabel lblAge = new JLabel("Date of birth:");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAge.setBounds(44, 270, 100, 16);
		panelRegister.add(lblAge);

		JButton btnVytvor = new JButton("Register");
		btnVytvor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVytvor.setForeground(Color.BLUE);
		btnVytvor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnVytvor.setBounds(432, 388, 105, 36);
		panelRegister.add(btnVytvor);

		menoField = new JTextField();
		menoField.setFont(new Font("Tahoma", Font.BOLD, 15));
		menoField.setBounds(166, 89, 116, 22);
		panelRegister.add(menoField);
		menoField.setColumns(10);

		priezviskoField = new JTextField();
		priezviskoField.setFont(new Font("Tahoma", Font.BOLD, 15));
		priezviskoField.setBounds(166, 132, 116, 22);
		panelRegister.add(priezviskoField);
		priezviskoField.setColumns(10);

		ageField = new JTextField();
		ageField.setFont(new Font("Tahoma", Font.BOLD, 15));
		ageField.setBounds(166, 267, 116, 22);
		panelRegister.add(ageField);
		ageField.setColumns(10);

		Choice poziciaMenu = new Choice();
		poziciaMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		poziciaMenu.setBounds(166, 311, 116, 22);
		poziciaMenu.insert("Begginer", 0);
		poziciaMenu.insert("Average", 1);
		poziciaMenu.insert("Advanced", 2);
		panelRegister.add(poziciaMenu);
		
		JLabel lblNewLabel_1 = new JLabel("*e-mail adress:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(44, 218, 121, 22);
		panelRegister.add(lblNewLabel_1);
		
		emailAdressField = new JTextField();
		emailAdressField.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailAdressField.setBounds(166, 219, 116, 22);
		panelRegister.add(emailAdressField);
		emailAdressField.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("*Password:");
		lblPassword_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword_1.setBounds(44, 177, 100, 16);
		panelRegister.add(lblPassword_1);
		
		passwdField = new JTextField();
		passwdField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwdField.setBounds(166, 175, 116, 22);
		panelRegister.add(passwdField);
		passwdField.setColumns(10);
	
		JPanel panelPermanentky = new JPanel();
		getContentPane().add(panelPermanentky, "name_70600146606884");
		panelPermanentky.setLayout(null);
		
		JPanel panelTyzdnova = new JPanel();
		panelTyzdnova.setBounds(226, 0, 360, 448);
		panelPermanentky.add(panelTyzdnova);
		panelTyzdnova.setLayout(null);
		
		JLabel lblTyzdnova = new JLabel("Tyzdnova");
		lblTyzdnova.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblTyzdnova.setBounds(110, 25, 171, 47);
		panelTyzdnova.add(lblTyzdnova);
		
		JLabel lblTyzdnova_obr = new JLabel("");
		Image img_bbb = new ImageIcon(this.getClass().getResource("/tyzden.png")).getImage();    //vytlacenie uvodneho obrazku
		lblTyzdnova_obr.setIcon(new ImageIcon(img_bbb));
		lblTyzdnova_obr.setBounds(154, 125, 84, 68);
		panelTyzdnova.add(lblTyzdnova_obr);
		
		JTextPane txtTzydnova = new JTextPane();
		txtTzydnova.setBackground(SystemColor.menu);
		txtTzydnova.setEditable(false);
		txtTzydnova.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTzydnova.setText("Pri k\u00FApe t\u00FD\u017Ed\u0148ovej permanentky je mo\u017En\u00E9 vyu\u017E\u00EDva\u0165 slu\u017Eby gymu \u013Eubovo\u013Ene po\u010Das cel\u00E9ho t\u00FD\u017Ed\u0148a. Cena 20 Eur");
		txtTzydnova.setBounds(45, 250, 291, 68);
		panelTyzdnova.add(txtTzydnova);
		
		JButton btnBuyTyzdnova = new JButton("Buy!");
		btnBuyTyzdnova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuyTyzdnova.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnBuyTyzdnova.setBounds(122, 360, 137, 36);
		panelTyzdnova.add(btnBuyTyzdnova);
		
		JPanel panelVstupova = new JPanel();
		panelVstupova.setBounds(226, 0, 360, 448);
		panelPermanentky.add(panelVstupova);
		panelVstupova.setLayout(null);
		
		JLabel lblVstupova = new JLabel("Jednovstupova");
		lblVstupova.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblVstupova.setBounds(63, 25, 255, 39);
		panelVstupova.add(lblVstupova);
		
		JLabel lblJednov_obr = new JLabel("");
		Image img_aaa = new ImageIcon(this.getClass().getResource("/day.png")).getImage();    //vytlacenie uvodneho obrazku
		lblJednov_obr.setIcon(new ImageIcon(img_aaa));
		lblJednov_obr.setBounds(143, 101, 81, 72);
		panelVstupova.add(lblJednov_obr);
		
		JTextPane textPaneVstup = new JTextPane();
		textPaneVstup.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPaneVstup.setText("Pri zak\u00FApen\u00FD jedn\u00E9ho vstupu m\u00F4\u017Eete vyu\u017E\u00EDva\u0165 slu\u017Eby gymu po cel\u00FD de\u0148. Cena 4 Eur");
		textPaneVstup.setBackground(SystemColor.menu);
		textPaneVstup.setEditable(false);
		textPaneVstup.setBounds(30, 237, 299, 99);
		panelVstupova.add(textPaneVstup);
		
		JButton btnBuyVstup = new JButton("Buy!");
		btnBuyVstup.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnBuyVstup.setBounds(113, 376, 142, 47);
		panelVstupova.add(btnBuyVstup);
		
		JPanel panelMesacna = new JPanel();
		panelMesacna.setBounds(226, 0, 360, 448);
		panelPermanentky.add(panelMesacna);
		panelMesacna.setLayout(null);
		
		JLabel lblMesacna = new JLabel("Mesa\u010Dn\u00E1");
		lblMesacna.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblMesacna.setBounds(92, 31, 160, 47);
		panelMesacna.add(lblMesacna);
		
		JButton btnBuy_mesacna = new JButton("Buy");
		btnBuy_mesacna.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnBuy_mesacna.setBounds(92, 372, 160, 38);
		panelMesacna.add(btnBuy_mesacna);
		
		JTextPane textMesacna_opis = new JTextPane();
		textMesacna_opis.setText("Pri k\u00FApe mesa\u010Dnej permanentky, z\u00EDskate mno\u017Estvo benefitov ako napr\u00EDklad neobmedzen\u00FD vstup do gymu v trvan\u00ED 30 dn\u00ED...");
		textMesacna_opis.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textMesacna_opis.setBounds(26, 256, 310, 103);
		panelMesacna.add(textMesacna_opis);
		
		JLabel lblMesacna_obrazok = new JLabel("");
		Image img_11 = new ImageIcon(this.getClass().getResource("/kalendar.png")).getImage();    //vytlacenie uvodneho obrazku
		lblMesacna_obrazok.setIcon(new ImageIcon(img_11));
		lblMesacna_obrazok.setBounds(102, 109, 132, 87);
		panelMesacna.add(lblMesacna_obrazok);
		
		JButton btnVstup = new JButton("Vstup");
		btnVstup.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnVstup.setBounds(52, 62, 109, 36);
		panelPermanentky.add(btnVstup);
		
		JButton btnTyzdnova = new JButton("Tyzdnova");
		btnTyzdnova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTyzdnova.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnTyzdnova.setBounds(52, 144, 109, 36);
		panelPermanentky.add(btnTyzdnova);
		
		JButton btnMesacna = new JButton("Mesacna");
		btnMesacna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMesacna.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnMesacna.setBounds(52, 233, 109, 36);
		panelPermanentky.add(btnMesacna);
		
		JButton btnCelorocna = new JButton("Celorocna");
		btnCelorocna.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCelorocna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCelorocna.setBounds(52, 323, 109, 36);
		panelPermanentky.add(btnCelorocna);
		
		JPanel panelShirts = new JPanel();
		getContentPane().add(panelShirts, "name_73041653225185");
		panelShirts.setLayout(null);
		
		JButton btnShirt1 = new JButton("ADD");
		btnShirt1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShirt1.setBounds(25, 115, 97, 25);
		panelShirts.add(btnShirt1);
		
		JButton btnShirt2 = new JButton("ADD");
		btnShirt2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShirt2.setBounds(167, 115, 97, 25);
		panelShirts.add(btnShirt2);
		
		JButton btnShirt3 = new JButton("ADD");
		btnShirt3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShirt3.setBounds(307, 115, 97, 25);
		panelShirts.add(btnShirt3);
		
		JButton btnShirt4 = new JButton("ADD");
		btnShirt4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShirt4.setBounds(445, 115, 97, 25);
		panelShirts.add(btnShirt4);
		
		JButton btnShirt5 = new JButton("ADD");
		btnShirt5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShirt5.setBounds(25, 300, 97, 25);
		panelShirts.add(btnShirt5);
		
		JButton btnShirt7 = new JButton("ADD");
		btnShirt7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShirt7.setBounds(167, 300, 97, 25);
		panelShirts.add(btnShirt7);
		
		JLabel lblShirt1 = new JLabel("");
		Image imga = new ImageIcon(this.getClass().getResource("/Tricko1.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShirt1.setIcon(new ImageIcon(imga));
		lblShirt1.setBounds(39, 13, 72, 89);
		panelShirts.add(lblShirt1);
		
		JLabel lblShirt2 = new JLabel("");
		Image imgb = new ImageIcon(this.getClass().getResource("/Tricko2.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShirt2.setIcon(new ImageIcon(imgb));
		lblShirt2.setBounds(184, 13, 72, 89);
		panelShirts.add(lblShirt2);
		
		JLabel lblShirt3 = new JLabel("");
		Image imgc = new ImageIcon(this.getClass().getResource("/Tricko3.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShirt3.setIcon(new ImageIcon(imgc));
		lblShirt3.setBounds(317, 13, 72, 89);
		panelShirts.add(lblShirt3);
		
		JLabel lblShirt4 = new JLabel("");
		Image imgd = new ImageIcon(this.getClass().getResource("/Tricko4.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShirt4.setIcon(new ImageIcon(imgd));
		lblShirt4.setBounds(459, 13, 72, 89);
		panelShirts.add(lblShirt4);
		
		JLabel lblShirt5 = new JLabel("");
		Image imge = new ImageIcon(this.getClass().getResource("/Shirt6.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShirt5.setIcon(new ImageIcon(imge));
		lblShirt5.setBounds(39, 194, 72, 89);
		panelShirts.add(lblShirt5);
		
		JLabel lblShirt6 = new JLabel("");
		Image imgf = new ImageIcon(this.getClass().getResource("/Tricko7.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShirt6.setIcon(new ImageIcon(imgf));
		lblShirt6.setBounds(184, 194, 72, 89);
		panelShirts.add(lblShirt6);
		
		JButton btnShoppingCard1 = new JButton("Shopping card");
		Image img2 = new ImageIcon(this.getClass().getResource("/vozik.png")).getImage();    //vytlacenie uvodneho obrazku
		btnShoppingCard1.setIcon(new ImageIcon(img2));
		btnShoppingCard1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnShoppingCard1.setBounds(371, 378, 171, 40);
		panelShirts.add(btnShoppingCard1);
		
		JPanel panelHistory_shop = new JPanel();
		getContentPane().add(panelHistory_shop, "name_11190883263066");
		panelHistory_shop.setLayout(null);
		
		JLabel lblHistoryOfShopping = new JLabel("History of shopping");
		lblHistoryOfShopping.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblHistoryOfShopping.setBounds(131, 13, 310, 44);
		panelHistory_shop.add(lblHistoryOfShopping);
		
		JButton btnUkaz_historiu = new JButton("Ukaz historiu");
		btnUkaz_historiu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnUkaz_historiu.setBounds(12, 88, 147, 33);
		panelHistory_shop.add(btnUkaz_historiu);
		
		JScrollPane scrollPaneHistoryShop = new JScrollPane();
		scrollPaneHistoryShop.setBounds(184, 88, 390, 347);
		panelHistory_shop.add(scrollPaneHistoryShop);
		
		tableHistory_shop = new JTable();
		scrollPaneHistoryShop.setViewportView(tableHistory_shop);
		
		JButton btnHistorySHop2015 = new JButton("Average 2015");
		btnHistorySHop2015.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnHistorySHop2015.setBounds(12, 139, 147, 33);
		panelHistory_shop.add(btnHistorySHop2015);
		
		JPanel panelShoes = new JPanel();
		getContentPane().add(panelShoes, "name_73096922870768");
		panelShoes.setLayout(null);
		
		JButton btnShoes1 = new JButton("ADD");
		btnShoes1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShoes1.setBounds(25, 115, 97, 25);
		panelShoes.add(btnShoes1);
		
		JButton btnShoes2 = new JButton("ADD");
		btnShoes2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShoes2.setBounds(164, 115, 97, 25);
		panelShoes.add(btnShoes2);
		
		JButton btnShoes3 = new JButton("ADD");
		btnShoes3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShoes3.setBounds(305, 115, 97, 25);
		panelShoes.add(btnShoes3);
		
		JButton btnShoes4 = new JButton("ADD");
		btnShoes4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShoes4.setBounds(448, 115, 97, 25);
		panelShoes.add(btnShoes4);
		
		JButton btnShoes5 = new JButton("ADD");
		btnShoes5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShoes5.setBounds(25, 259, 97, 25);
		panelShoes.add(btnShoes5);
		
		JButton btnShoes6 = new JButton("ADD");
		btnShoes6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShoes6.setBounds(164, 259, 97, 25);
		panelShoes.add(btnShoes6);
		
		JButton btnShoes7 = new JButton("ADD");
		btnShoes7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShoes7.setBounds(305, 259, 97, 25);
		panelShoes.add(btnShoes7);
		
		JLabel lblShoes1 = new JLabel("");
		Image imgj = new ImageIcon(this.getClass().getResource("/Shoes1.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShoes1.setIcon(new ImageIcon(imgj));
		lblShoes1.setBounds(37, 13, 72, 89);
		panelShoes.add(lblShoes1);
		
		JLabel lblShoes2 = new JLabel("");
		Image imgk = new ImageIcon(this.getClass().getResource("/Shoes2.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShoes2.setIcon(new ImageIcon(imgk));
		lblShoes2.setBounds(175, 13, 72, 89);
		panelShoes.add(lblShoes2);
		
		JLabel lblShoes3 = new JLabel("");
		Image imgl = new ImageIcon(this.getClass().getResource("/Shoes3.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShoes3.setIcon(new ImageIcon(imgl));
		lblShoes3.setBounds(316, 13, 72, 89);
		panelShoes.add(lblShoes3);
		
		JLabel lblShoes4 = new JLabel("");
		Image imgm = new ImageIcon(this.getClass().getResource("/Shoes4.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShoes4.setIcon(new ImageIcon(imgm));
		lblShoes4.setBounds(459, 13, 72, 89);
		panelShoes.add(lblShoes4);
		
		JLabel lblShoes5 = new JLabel("");
		Image imgn = new ImageIcon(this.getClass().getResource("/Shoes5.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShoes5.setIcon(new ImageIcon(imgn));
		lblShoes5.setBounds(37, 170, 72, 76);
		panelShoes.add(lblShoes5);
		
		JLabel lblShoes6 = new JLabel("");
		Image imgo = new ImageIcon(this.getClass().getResource("/Shoes6.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShoes6.setIcon(new ImageIcon(imgo));
		lblShoes6.setBounds(175, 170, 72, 76);
		panelShoes.add(lblShoes6);
		
		JLabel lblShoes7 = new JLabel("");
		Image imgp = new ImageIcon(this.getClass().getResource("/Shoes7.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShoes7.setIcon(new ImageIcon(imgp));
		lblShoes7.setBounds(316, 170, 72, 76);
		panelShoes.add(lblShoes7);
		
		JButton btnShoppingCard3 = new JButton("Shopping card ");
		Image img3 = new ImageIcon(this.getClass().getResource("/vozik.png")).getImage();    //vytlacenie uvodneho obrazku
		btnShoppingCard3.setIcon(new ImageIcon(img3));
		btnShoppingCard3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnShoppingCard3.setBounds(369, 361, 176, 43);
		panelShoes.add(btnShoppingCard3);
		
		JPanel panelShorts = new JPanel();
		getContentPane().add(panelShorts, "name_73061588967011");
		panelShorts.setLayout(null);
		
		JButton btnShoppingCard2 = new JButton("Shopping card");
		btnShoppingCard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/vozik.png")).getImage();    //vytlacenie uvodneho obrazku
		btnShoppingCard2.setIcon(new ImageIcon(img4));
		btnShoppingCard2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnShoppingCard2.setBounds(382, 362, 172, 42);
		panelShorts.add(btnShoppingCard2);
		
		JButton btnShorts1 = new JButton("ADD");
		btnShorts1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShorts1.setBounds(24, 116, 97, 25);
		panelShorts.add(btnShorts1);
		
		JButton btnShorts2 = new JButton("ADD");
		btnShorts2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShorts2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnShorts2.setBounds(167, 116, 97, 25);
		panelShorts.add(btnShorts2);
		
		JButton btnShorts3 = new JButton("ADD");
		btnShorts3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnShorts3.setBounds(309, 116, 97, 25);
		panelShorts.add(btnShorts3);
		
		JLabel lblShorts1 = new JLabel("");
		Image imgg = new ImageIcon(this.getClass().getResource("/Shorts1.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShorts1.setIcon(new ImageIcon(imgg));
		lblShorts1.setBounds(38, 16, 72, 90);
		panelShorts.add(lblShorts1);
		
		JLabel lblShorts2 = new JLabel("");
		Image imgh = new ImageIcon(this.getClass().getResource("/Short2.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShorts2.setIcon(new ImageIcon(imgh));
		lblShorts2.setBounds(178, 16, 72, 87);
		panelShorts.add(lblShorts2);
		
		JLabel lblShorts3 = new JLabel("");
		Image imgi = new ImageIcon(this.getClass().getResource("/Shots3.png")).getImage();    //vytlacenie uvodneho obrazku
		lblShorts3.setIcon(new ImageIcon(imgi));
		lblShorts3.setBounds(321, 16, 72, 87);
		panelShorts.add(lblShorts3);
		
		JPanel panelUpdate = new JPanel();
		getContentPane().add(panelUpdate, "name_128244578246196");
		panelUpdate.setLayout(null);
		
		JLabel lblUpdating = new JLabel("Updating");
		lblUpdating.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblUpdating.setBounds(208, 13, 148, 57);
		panelUpdate.add(lblUpdating);
		
		JPanel panelCheck = new JPanel();
		getContentPane().add(panelCheck, "name_128301134838384");
		panelCheck.setLayout(null);
		
		JLabel lblYourProfil = new JLabel("Your profile");
		lblYourProfil.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblYourProfil.setBounds(183, 30, 187, 43);
		panelCheck.add(lblYourProfil);
		
		JButton btnYourProfil = new JButton("Update");
		Image imgx = new ImageIcon(this.getClass().getResource("/Update.png")).getImage();    //vytlacenie uvodneho obrazku
		btnYourProfil.setIcon(new ImageIcon(imgx));
		btnYourProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnYourProfil.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnYourProfil.setBounds(417, 384, 121, 35);
		panelCheck.add(btnYourProfil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 102, 496, 269);
		panelCheck.add(scrollPane);
		
		tableProfil = new JTable();
		scrollPane.setViewportView(tableProfil);
		
		JButton btnShowMates = new JButton("Show mates");
		btnShowMates.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnShowMates.setBounds(284, 384, 121, 35);
		panelCheck.add(btnShowMates);
		
		JButton btnShowHeigh = new JButton("Show height");
		btnShowHeigh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnShowHeigh.setBounds(42, 384, 121, 35);
		panelCheck.add(btnShowHeigh);
		
		JButton btnPermaAktualna = new JButton("Perma");
		btnPermaAktualna.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnPermaAktualna.setBounds(175, 384, 97, 35);
		panelCheck.add(btnPermaAktualna);
		
		JLabel lblIdUser = new JLabel("");
		lblIdUser.setVisible(false);
		lblIdUser.setBounds(22, 13, 68, 25);
		panelCheck.add(lblIdUser);
		

		JButton btnUpdating = new JButton("Update");
		Image imgu = new ImageIcon(this.getClass().getResource("/Update.png")).getImage();    //vytlacenie uvodneho obrazku
		btnUpdating.setIcon(new ImageIcon(imgu));
		btnUpdating.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnUpdating.setBounds(417, 384, 121, 35);
		panelUpdate.add(btnUpdating);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblWeight.setBounds(39, 92, 67, 27);
		panelUpdate.add(lblWeight);
		
		JLabel lblHeigh = new JLabel("Heigh");
		lblHeigh.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblHeigh.setBounds(38, 148, 56, 19);
		panelUpdate.add(lblHeigh);
		
		JLabel lblBench = new JLabel("Bench press");
		lblBench.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblBench.setBounds(39, 195, 97, 28);
		panelUpdate.add(lblBench);
		
		JLabel lblBackSquat = new JLabel("Back Squat");
		lblBackSquat.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblBackSquat.setBounds(39, 246, 97, 38);
		panelUpdate.add(lblBackSquat);
		
		JLabel lblFrontSquat = new JLabel("Front Squat");
		lblFrontSquat.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblFrontSquat.setBounds(38, 310, 97, 35);
		panelUpdate.add(lblFrontSquat);
		
		JLabel lblClean = new JLabel("Clean&Jerk");
		lblClean.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblClean.setBounds(300, 97, 102, 22);
		panelUpdate.add(lblClean);
		
		JLabel lblSnatch = new JLabel("Snatch");
		lblSnatch.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblSnatch.setBounds(300, 144, 67, 27);
		panelUpdate.add(lblSnatch);
		
		JLabel lblPull = new JLabel("Pull ups");
		lblPull.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPull.setBounds(300, 202, 67, 16);
		panelUpdate.add(lblPull);
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("Tahoma", Font.BOLD, 13));
		textWeight.setBounds(142, 95, 116, 22);
		panelUpdate.add(textWeight);
		textWeight.setColumns(10);
		
		textHeigh = new JTextField();
		textHeigh.setFont(new Font("Tahoma", Font.BOLD, 13));
		textHeigh.setBounds(142, 147, 116, 22);
		panelUpdate.add(textHeigh);
		textHeigh.setColumns(10);
		
		textBench = new JTextField();
		textBench.setFont(new Font("Tahoma", Font.BOLD, 13));
		textBench.setText("");
		textBench.setBounds(142, 199, 116, 22);
		panelUpdate.add(textBench);
		textBench.setColumns(10);
		
		textBack = new JTextField();
		textBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		textBack.setBounds(142, 255, 116, 22);
		panelUpdate.add(textBack);
		textBack.setColumns(10);
		
		textFront = new JTextField();
		textFront.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFront.setBounds(142, 317, 116, 22);
		panelUpdate.add(textFront);
		textFront.setColumns(10);
		
		textClean = new JTextField();
		textClean.setFont(new Font("Tahoma", Font.BOLD, 13));
		textClean.setBounds(422, 95, 116, 22);
		panelUpdate.add(textClean);
		textClean.setColumns(10);
		
		textSnatch = new JTextField();
		textSnatch.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSnatch.setBounds(422, 147, 116, 22);
		panelUpdate.add(textSnatch);
		textSnatch.setColumns(10);
		
		textPull = new JTextField();
		textPull.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPull.setText("");
		textPull.setBounds(422, 199, 116, 22);
		panelUpdate.add(textPull);
		textPull.setColumns(10);
		
		JButton btnVytvorUpdate = new JButton("Create");
		btnVytvorUpdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnVytvorUpdate.setBounds(417, 336, 121, 35);
		panelUpdate.add(btnVytvorUpdate);
		
		JPanel panelShoppingCard = new JPanel();
		getContentPane().add(panelShoppingCard, "name_128351661114802");
		panelShoppingCard.setLayout(null);
		
		JLabel lblShopping = new JLabel("Shopping card");
		lblShopping.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblShopping.setBounds(178, 23, 207, 44);
		panelShoppingCard.add(lblShopping);
		
		JButton btnOrder = new JButton("Order");
		Image imgz = new ImageIcon(this.getClass().getResource("/Ok.png")).getImage();    //vytlacenie uvodneho obrazku
		btnOrder.setIcon(new ImageIcon(imgz));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrder.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnOrder.setBounds(431, 397, 117, 38);
		panelShoppingCard.add(btnOrder);
		
		JScrollPane scrollShoppingCard = new JScrollPane();
		scrollShoppingCard.setBounds(25, 71, 549, 311);
		panelShoppingCard.add(scrollShoppingCard);
		
		tableShopping_card = new JTable();
		scrollShoppingCard.setViewportView(tableShopping_card);
		
		JPanel panelHistory_train = new JPanel();
		getContentPane().add(panelHistory_train, "name_11603030144481");
		panelHistory_train.setLayout(null);
		
		JLabel lblHistory_training = new JLabel("History of trainings");
		lblHistory_training.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblHistory_training.setBounds(151, 13, 289, 53);
		panelHistory_train.add(lblHistory_training);
		
		JButton btnHistory_train = new JButton("Show history");
		btnHistory_train.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnHistory_train.setBounds(25, 102, 130, 35);
		panelHistory_train.add(btnHistory_train);
		
		JScrollPane scrollPaneHistoryTrain = new JScrollPane();
		scrollPaneHistoryTrain.setBounds(179, 102, 379, 333);
		panelHistory_train.add(scrollPaneHistoryTrain);
		
		tableHistory_train = new JTable();
		scrollPaneHistoryTrain.setViewportView(tableHistory_train);
		
		JButton btnPriemerCviciacich = new JButton("Priemerny pocet \r\ncvicencov");
		btnPriemerCviciacich.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnPriemerCviciacich.setBounds(25, 150, 130, 35);
		panelHistory_train.add(btnPriemerCviciacich);
		
		JPanel panelAbout = new JPanel();
		getContentPane().add(panelAbout, "name_358762986423512");
		panelAbout.setLayout(null);
		
		JTextPane textAbout = new JTextPane();
		textAbout.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textAbout.setText("CrossFit sa vo ve\u013Emi \u0161irokom zmysle d\u00E1 op\u00EDsa\u0165 ako neust\u00E1le sa meniaci funk\u010Dn\u00FD pohyb vykon\u00E1van\u00FD vo vysokej intenzite. Cielom CrossFitu je budovanie programu, ktor\u00FD cvi\u010Denca najlep\u0161ie priprav\u00ED na ak\u00FAko\u013Evek fyzick\u00FA v\u00FDzvu \u2013 ktor\u00FD ho priprav\u00ED nielen na nepoznan\u00E9 ale aj na nepoznate\u013En\u00E9. Pri CrossFite sa teda nejedn\u00E1 sa o \u0161pecializovan\u00FD fitness program, sna\u017E\u00ED sa o vytvorenie a optimalizovanie fyzick\u00FDch schopnost\u00ED v ka\u017Edej z desiatich sf\u00E9r fitnessu \u2013 kardiovaskul\u00E1rna a respirat\u00F3rna vytrvalos\u0165, v\u00FDdr\u017E, sila, flexibilita, v\u00FDkon, r\u00FDchlos\u0165, koordin\u00E1cia, obratnos\u0165, balans, presnost.");
		textAbout.setBackground(SystemColor.menu);
		textAbout.setBounds(12, 25, 562, 398);
		panelAbout.add(textAbout);
		
		JPanel panelProfil = new JPanel();
		getContentPane().add(panelProfil, "name_71033341045703");
		panelProfil.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menuBar.add(mnHome);

		JMenu mnProfil = new JMenu("Profil");
		mnProfil.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menuBar.add(mnProfil);
		
		JMenu mnMyInfo = new JMenu("My profil");
		mnMyInfo.setForeground(Color.GRAY);
		mnMyInfo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnProfil.add(mnMyInfo);
		
		JMenuItem mntmCheck = new JMenuItem("Check");
		mntmCheck.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmCheck.setForeground(Color.GRAY);
		mnMyInfo.add(mntmCheck);
		
		JMenuItem mntmUpdate = new JMenuItem("Udpate");
		mntmUpdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmUpdate.setForeground(Color.GRAY);
		mnMyInfo.add(mntmUpdate);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setForeground(Color.GRAY);
		mntmLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnProfil.add(mntmLogout);
		
		JMenu mnPerm = new JMenu("Permanentky");
		mnPerm.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menuBar.add(mnPerm);
		
		JMenuItem mntmHistoryPerms = new JMenuItem("History of perms");
		mntmHistoryPerms.setForeground(Color.GRAY);
		mntmHistoryPerms.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnPerm.add(mntmHistoryPerms);
		
		JMenu mnTreningy = new JMenu("Trainings");
		mnTreningy.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menuBar.add(mnTreningy);
		
		JMenuItem mntmHistory_train = new JMenuItem("History of trainings");
		mntmHistory_train.setForeground(Color.GRAY);
		mntmHistory_train.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnTreningy.add(mntmHistory_train);
		
		JMenu mnShop = new JMenu("Shop");
		mnShop.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menuBar.add(mnShop);
		
		JMenuItem mntmShirts = new JMenuItem("Shirts");
		mntmShirts.setForeground(Color.GRAY);
		mntmShirts.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnShop.add(mntmShirts);
		
		JMenuItem mntmShorts = new JMenuItem("Shorts");
		mntmShorts.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmShorts.setForeground(Color.GRAY);
		mnShop.add(mntmShorts);
		
		JMenuItem mntmShoes = new JMenuItem("Shoes");
		mntmShoes.setForeground(Color.GRAY);
		mntmShoes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnShop.add(mntmShoes);
		
		JMenuItem mntmShoppingCard = new JMenuItem("Shopping card");
		mntmShoppingCard.setForeground(Color.GRAY);
		mntmShoppingCard.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnShop.add(mntmShoppingCard);
		
		JMenuItem mntmHistory_shop = new JMenuItem("Shop history");
		mntmHistory_shop.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmHistory_shop.setForeground(Color.GRAY);
		mnShop.add(mntmHistory_shop);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menuBar.add(mnAbout);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//panels		
		
		mnHome.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(true);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
				

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mntmCheck.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(true);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mnTreningy.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(true);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mnPerm.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(true);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		
		mntmHistory_train.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(true);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mntmHistoryPerms.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mntmHistory_shop.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelHistory_shop.setVisible(true);
				panelHistory_train.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		
		mntmUpdate.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(true);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		
		mntmLogout.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(true);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mntmShirts.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(true);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		
		mntmShorts.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(true);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mntmShoes.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(true);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		
		
		mntmShoppingCard.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(true);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(true);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mntmHistory_train.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(true);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(true);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		mnAbout.addMouseListener(new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {			
		}

					@Override
					public void mousePressed(MouseEvent e) {
						panelRegister.setVisible(false);
						panelShirts.setVisible(false);
						panelShorts.setVisible(false);
						panelShoes.setVisible(false);
						panelAbout.setVisible(true);
						panelHome.setVisible(false);
						panelPermanentky.setVisible(false);
						panelTrainings.setVisible(false);
						panelShoppingCard.setVisible(false);
						panelUpdate.setVisible(false);
						panelCheck.setVisible(false);
						panelOpenGym.setVisible(false);
						panelCrossfit.setVisible(false);
						panelMesacna.setVisible(false);
						panelLifting.setVisible(false);
						panelBegginers.setVisible(false);
						panelHistory_shop.setVisible(false);
						panelHistory_train.setVisible(false);
						panelVstupova.setVisible(false);
						panelTyzdnova.setVisible(false);
						panelHistory_perma.setVisible(false);

					}

					@Override
					public void mouseExited(MouseEvent e) {
						

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						

					}

					@Override
					public void mouseClicked(MouseEvent e) {

					}
				});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Buttons		

		
		btnRegister.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				panelRegister.setVisible(true);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnShoppingCard1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(true);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnShoppingCard2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(true);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnShoppingCard3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(true);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		
		btnYourProfil.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(true);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnOpenGym.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(true);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(true);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnCrossfit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(true);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(true);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		
		btnLifting.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(true);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(true);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnBeginners.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(false);
				panelTrainings.setVisible(true);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(true);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		

		
		
		btnMesacna.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(true);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(true);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnVstup.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(true);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(true);
				panelTyzdnova.setVisible(false);
				panelHistory_perma.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		btnTyzdnova.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelRegister.setVisible(false);
				panelShirts.setVisible(false);
				panelShorts.setVisible(false);
				panelShoes.setVisible(false);
				panelAbout.setVisible(false);
				panelHome.setVisible(false);
				panelProfil.setVisible(false);
				panelPermanentky.setVisible(true);
				panelTrainings.setVisible(false);
				panelShoppingCard.setVisible(false);
				panelUpdate.setVisible(false);
				panelCheck.setVisible(false);
				panelOpenGym.setVisible(false);
				panelCrossfit.setVisible(false);
				panelMesacna.setVisible(false);
				panelLifting.setVisible(false);
				panelBegginers.setVisible(false);
				panelHistory_shop.setVisible(false);
				panelHistory_train.setVisible(false);
				panelVstupova.setVisible(false);
				panelTyzdnova.setVisible(true);
				panelHistory_perma.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Functions button
		
		
		btnVytvor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "insert into users(name, surname, pass, email) values (?, ?, ?, ?)"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		pst.setString(1, menoField.getText());
		    		pst.setString(2, priezviskoField.getText());
		    		pst.setString(3, passwdField.getText());
		    		pst.setString(4, emailAdressField.getText());
		    		//pst.setString(5, ageField.getText());
		    		
		    		pst.execute();
		    		
		    		panelRegister.setVisible(false);
					panelShirts.setVisible(false);
					panelShorts.setVisible(false);
					panelShoes.setVisible(false);
					panelAbout.setVisible(false);
					panelHome.setVisible(true);
					panelProfil.setVisible(false);
					panelPermanentky.setVisible(false);
					panelTrainings.setVisible(false);
					panelShoppingCard.setVisible(false);
					panelUpdate.setVisible(false);
					panelCheck.setVisible(false);
					panelOpenGym.setVisible(false);
					panelCrossfit.setVisible(false);
					panelMesacna.setVisible(false);
					panelLifting.setVisible(false);
					panelBegginers.setVisible(false);
					panelHistory_shop.setVisible(false);
					panelHistory_train.setVisible(false);
					panelVstupova.setVisible(false);
					panelTyzdnova.setVisible(false);
					panelHistory_perma.setVisible(false);
					
					JOptionPane.showMessageDialog(panelHome, "Registration successfull");
					
			    	pst.close();
		    		
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//refreshTable();
			}
		});
		
		btnSignUp.addActionListener(new ActionListener() { 					//button overenie prihlasenia....
			public void actionPerformed(ActionEvent arg0) {
				try{
					
		    		String query = "select id_user from users where email = ? and pass = ?"; 
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		pst.setString(1, emailField.getText());
		    		pst.setString(2, passwordField.getText());
		    		
		    		ResultSet rs = pst.executeQuery();
		    		
		    		int count = 0;
		    		while(rs.next()){
		    			lblIdUser.setText(rs.getString(1));
		    			count = count + 1;
		    		}
		    		if(count == 1){
		    			panelRegister.setVisible(false);
						panelShirts.setVisible(false);
						panelShorts.setVisible(false);
						panelShoes.setVisible(false);
						panelAbout.setVisible(false);
						panelHome.setVisible(false);
						panelProfil.setVisible(false);
						panelPermanentky.setVisible(false);
						panelTrainings.setVisible(false);
						panelShoppingCard.setVisible(false);
						panelUpdate.setVisible(false);
						panelCheck.setVisible(true);
						panelOpenGym.setVisible(false);
						panelCrossfit.setVisible(false);
						panelMesacna.setVisible(false);
						panelLifting.setVisible(false);
						panelBegginers.setVisible(false);
						panelHistory_shop.setVisible(false);
						panelHistory_train.setVisible(false);
						panelVstupova.setVisible(false);
						panelTyzdnova.setVisible(false);
						panelHistory_perma.setVisible(false);
		    		}
		    		else if(count > 1){
		    			JOptionPane.showMessageDialog(panelHome,
								"Duplicate login and password!!!",
								"Inane error",
		    		    JOptionPane.ERROR_MESSAGE);
		    		}
		    		else{
		    			JOptionPane.showMessageDialog(panelHome,
								"Incorrect login or password!!!",
								"Inane error",
		    		    JOptionPane.ERROR_MESSAGE);
		    		}
		    		
		    	rs.close();
		    	pst.close();
		    	
		    	} catch(Exception e) {Component okno = null;
						JOptionPane.showMessageDialog(okno,
								"Incorrect login or password!!!",
								"Inane error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	}
			}
		});
		
		btnShowMates.addActionListener(new ActionListener() {			//vypis vsetkych registrovanych....
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select name,surname,date_of_birth from users "; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableProfil.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		mntmCheck.addActionListener(new ActionListener() {			//zobrazenie aktualneho profilu......
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select weight, heigh, bench, back, front, clean, snatch, pull from profil where id_user = '"+lblIdUser.getText()+"'"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableProfil.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		btnShowHeigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select name, surname, heigh from users u join profil p on u.id_user = p.id_user group by name having heigh > (select avg(heigh) from profil)"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableProfil.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		btnPermaAktualna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select name, surname, kupena, platna_do, perma_meno from users u join aktualna_perma a on u.id_user = a.id_user join perma p on a.id_perma = p.id_perma where u.id_user = '"+lblIdUser.getText()+"'"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableProfil.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		
		
		btnVytvorUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String query = "insert into profil(id_user, weight, heigh, bench, back, front, clean, snatch, pull) values ('"+lblIdUser.getText()+"', ?, ?, ?, ?, ?, ?, ?, ?) "; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		pst.setString(1, textWeight.getText());
		    		pst.setString(2, textHeigh.getText());
		    		pst.setString(3, textBench.getText());
		    		pst.setString(4, textBack.getText());
		    		pst.setString(5, textFront.getText());
		    		pst.setString(6, textClean.getText());
		    		pst.setString(7, textSnatch.getText());
		    		pst.setString(8, textPull.getText());
		    		
		    		pst.execute();
		    		
		    		panelRegister.setVisible(false);
					panelShirts.setVisible(false);
					panelShorts.setVisible(false);
					panelShoes.setVisible(false);
					panelAbout.setVisible(false);
					panelHome.setVisible(false);
					panelProfil.setVisible(false);
					panelPermanentky.setVisible(false);
					panelTrainings.setVisible(false);
					panelShoppingCard.setVisible(false);
					panelUpdate.setVisible(false);
					panelCheck.setVisible(true);
					panelOpenGym.setVisible(false);
					panelCrossfit.setVisible(false);
					panelMesacna.setVisible(false);
					panelLifting.setVisible(false);
					panelBegginers.setVisible(false);
					panelHistory_shop.setVisible(false);
					panelHistory_train.setVisible(false);
					panelVstupova.setVisible(false);
					panelTyzdnova.setVisible(false);
					panelHistory_perma.setVisible(false);
					
					JOptionPane.showMessageDialog(panelUpdate, "Data registred");
					
			    	pst.close();
		    		
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
			
		btnUpdating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query = "update profil set weight = '"+textWeight.getText()+"', heigh = '"+textHeigh.getText()+"', bench = '"+textBench.getText()+"', back = '"+textBack.getText()+"', front = '"+textFront.getText()+"', clean = '"+textClean.getText()+"', snatch = '"+textSnatch.getText()+"', pull = '"+textPull.getText()+"' where id_user = '"+lblIdUser.getText()+"' "; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		
		    		pst.execute();
		    		
		    		panelRegister.setVisible(false);
					panelShirts.setVisible(false);
					panelShorts.setVisible(false);
					panelShoes.setVisible(false);
					panelAbout.setVisible(false);
					panelHome.setVisible(false);
					panelProfil.setVisible(false);
					panelPermanentky.setVisible(false);
					panelTrainings.setVisible(false);
					panelShoppingCard.setVisible(false);
					panelUpdate.setVisible(false);
					panelCheck.setVisible(true);
					panelOpenGym.setVisible(false);
					panelCrossfit.setVisible(false);
					panelMesacna.setVisible(false);
					panelLifting.setVisible(false);
					panelBegginers.setVisible(false);
					panelHistory_shop.setVisible(false);
					panelHistory_train.setVisible(false);
					panelVstupova.setVisible(false);
					panelTyzdnova.setVisible(false);
					panelHistory_perma.setVisible(false);
					
					JOptionPane.showMessageDialog(panelUpdate, "Data updated");
					
					refreshTable();
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		
		btnShoes1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "insert into polozka (id_objednavka, id_produkt, pocet_kusov) values (129, 1, 5) "; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		
		    		pst.execute();
		    		
		    		
		    		JOptionPane.showMessageDialog(panelShoes, "Pridane do kosika!");
			    	pst.close();
			    	
			    	
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		mntmShoppingCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "SELECT * FROM objednavka where id_user = '"+lblIdUser.getText()+"' having extract(year from datum_objednavky) = 2015 and extract(month from datum_objednavky) = 1 "; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableShopping_card.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnUkaz_historiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select name, surname, nazov_produktu, cena, datum_objednavky from users u join objednavka o on u.id_user = o.id_user join polozka p on o.id_objednavka = p.id_objednavka join produkt pr on p.id_produkt = pr.id_produkt where extract(year from datum_objednavky) = 2015 and u.id_user = '"+lblIdUser.getText()+"' "; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableHistory_shop.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnHistorySHop2015.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select name, surname, avg(cena) from users u join objednavka o on u.id_user = o.id_user join polozka p on o.id_objednavka = p.id_objednavka join produkt pr on p.id_produkt = pr.id_produkt where extract(year from datum_objednavky) = 2015 group by name"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableHistory_shop.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnCrossfit_prihlas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "insert treningy (id_typ_treningu, pocet_cvicencov, pocet_akt) values ('1', '20', '18')"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    				    		
		    		pst.execute();
		    		pst.close();
		    		
		    		 
		    		query = "insert vazba_trening (id_user, id_trening) values ('"+lblIdUser.getText()+"', last_insert_id())";
		    		pst = conn.prepareStatement(query);
		    	    pst.execute();
		    		
		    		JOptionPane.showMessageDialog(panelTrainings, "Ste prihlaseny!");
		    		
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnLifting_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "insert treningy (id_typ_treningu, pocet_cvicencov, pocet_akt) values ('4', '20', '6')"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    				    		
		    		pst.execute();
		    		pst.close();
		    		
		    		 
		    		query = "insert vazba_trening (id_user, id_trening) values ('"+lblIdUser.getText()+"', last_insert_id())";
		    		pst = conn.prepareStatement(query);
		    	    pst.execute();
		    		
		    		JOptionPane.showMessageDialog(panelTrainings, "Ste prihlaseny!");
		    		
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		
		
		
		btnOpenGym_prihlas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "insert treningy (id_typ_treningu, pocet_cvicencov, pocet_akt) values ('2', '20', '2')"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    				    		
		    		pst.execute();
		    		pst.close();
		    		
		    		 
		    		query = "insert vazba_trening (id_user, id_trening) values ('"+lblIdUser.getText()+"', last_insert_id())";
		    		pst = conn.prepareStatement(query);
		    	    pst.execute();
		    		
		    		JOptionPane.showMessageDialog(panelTrainings, "Ste prihlaseny!");
		    		
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnHistory_train.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select name, surname, pocet_cvicencov, pocet_akt, nazov_treningu from users u join vazba_trening v on u.id_user = v.id_user join treningy t on v.id_trening = t.id_trening join typ_treningu ty on t.id_typ_treningu = ty.id_typ_treningu where u.id_user = '"+lblIdUser.getText()+"'"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableHistory_train.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnPriemerCviciacich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select avg(pocet_cvicencov)from users u join vazba_trening v on u.id_user = v.id_user join treningy t on v.id_trening = t.id_trening join typ_treningu ty on t.id_typ_treningu = ty.id_typ_treningu"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableHistory_train.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnShowHistoryPerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					conn.setAutoCommit(false);
					conn.commit();
					
					String query = "select name, surname, perma_meno, zaplatena from users u join platba_permy p on u.id_user = p.id_user join perma pe on p.id_perma = pe.id_perma where u.id_user = '"+lblIdUser.getText()+"'"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableHistory_perm.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		rs.close();
			    	pst.close();
			    	
			    	try{
			    		if(conn != null)
			    			conn.rollback();
			    	}catch(SQLException se2){
			    		se2.printStackTrace();
			    	}
		    		
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnPocetPerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					conn.setAutoCommit(false);
					conn.commit();
					String query = "select name, surname, count(perma_meno) from users u join platba_permy p on u.id_user = p.id_user join perma pe on p.id_perma = pe.id_perma where u.id_user = '"+lblIdUser.getText()+"'"; 
					
		    		java.sql.PreparedStatement pst = conn.prepareStatement(query); 
		    		ResultSet rs = pst.executeQuery();
		    		
		    		tableHistory_perm.setModel(DbUtils.resultSetToTableModel(rs));
					
		    		
		    		
		    		rs.close();
			    	pst.close();
			    	
			    	
			    	try{
			    		if(conn != null)
			    			conn.rollback();
			    	}catch(SQLException se2){
			    		se2.printStackTrace();
			    	}
		    		
				}catch(Exception ex){
					ex.printStackTrace();
					
					
				}
			}
		});
	}
}

