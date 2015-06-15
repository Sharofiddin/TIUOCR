import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.tess4j.TesseractException;
import uz.tiu.ReadFromImToFile;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;

public class ReafFileWithGui extends JFrame {

	private JPanel contentPane,contentPane1,contentPane2;
	private JTextField textInUrl;
	private JTextField textOutUrl;

	ReadFromImToFile imToFile = new ReadFromImToFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReafFileWithGui frame = new ReafFileWithGui();
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
	public ReafFileWithGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\workstation\\BMI\\src\\bug1.jpg"));
		final OpenFile of = new OpenFile();
		setTitle("TUIOCR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 829, 500);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane2 = new JPanel();
		
		
		contentPane2.setSize(830, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menyu = new JMenu("Menyu");
		menuBar.add(menyu);
		
		JMenuItem mntmAsosiy = new JMenuItem("Asosiy");
		mntmAsosiy.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				setContentPane(contentPane);
			}
		});
		menyu.add(mntmAsosiy);
		
		//=================================================================================
		JMenuItem mntmYordam = new JMenuItem("Yordam");
//		ImageIcon picture = new ImageIcon( "J.jpg");
	
		mntmYordam.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				contentPane1 = new JPanel();
				
				contentPane1.setBackground(new Color(220, 220, 220));
				contentPane1.setSize(829, 500);
				JTextArea textArea = new JTextArea();
				textArea.setEditable( false );
				textArea.setText("\n\r\n\rUshbu dastur tasvirlardan matnli ma'lumotlarni ajratib olishga mo'ljallangan. Ichidan matn"
						+ "\r\nchiqarib olinishi lozim bo'lgan tasvirni \"tasvir tanlash\" tugmasini bosish orqali tanlanadi."
						+ "\r\nKeyin, \"Chiqubchi fayl turi\" va \"Matn tili\" qatorlaridan chiquvchi matnli ma'lumot formati "
						+ "\r\n(.txt yoki .doc) va tasvir ichidagi matn tili ( ara - arab, rus - rus, eng - ingiliz ) tanlanadi "
						+ "\r\n(orasida \"+\" bo'lgani 2 ta tilning kombinatsiyasidan iborat ya'ni berilgan tasvirda ikkita tildagi "
						+ "\r\nmatnli ma'lumotlar yashiringanini bildiradi ). Shundan so'ng, \"Amalga oshirish\" tugmasini"
						+ " \r\nbosish orqali jarayon ishga tushirib yuboriladi. Jarayon amalga oshirilganini bildirib, dastur "
						+ "\r\nasosiy menyusining pastki qismida \"Amalga oshirildi\" degan yozuv paydo bo'ladi. Shundan keyin"
						+ " \r\nkiruchi fayl joylashgan joyda foydalanuvchining tanloviga muvofiq, matnli fayl paydo bo'ladi"
						+ "\r\n (masalan, agar  Misol.jpg degan fayl tanlangan bo'lsa natija Misolextract.txt yoki"
						+ "\r\nMisolextract.doc bo'lishi mumkin. \"extract\" so'zi avtomatik qo'shiladi, foydalanuvchi buni"
						+ "\r\no'zgartirishi mumkin.    ");
				textArea.setBackground(Color.LIGHT_GRAY);
				textArea.setForeground(Color.BLACK);
				textArea.setFont(new Font("Sylfaen", Font.BOLD, 14));
				textArea.setColumns(50);
				textArea.setRows(40);
				
				contentPane1.add(textArea);
				
			  setContentPane( contentPane1 );
			}
		});
		menyu.add(mntmYordam);
		
		//=================================================================================

		JMenuItem mntmHaqida = new JMenuItem("Dastur haqida");
		JTextArea txtrHaqida = new JTextArea();
		txtrHaqida.setEditable( false );
		txtrHaqida.setText("                                                                      \r\n"
				+ "TIUOCR dasturi tasvirlardan matnlarni tanib olish uchunishlab chiqilgan bo'lib, arab,"
				+ "\r\ningiliz va rus tillaridagi  hamda bu tillar kombinatsiyalaridagi matnlarni tanib olish,"
				+ "\r\nshu bilan birga tanib olingan matnni .txt va .doc formatlarida xotiraga saqlash "
				+ "\r\nimkoniyatiga ega. Dastur java tilida yozilgan va uni tuzishda Tesseract kompaniyasi "
				+ "\r\nkomponentalaridan foydalanilgan.  Ushbu dastur java dasturlashtirish tilining tasvirlarga"
				+ "\r\nraqamli ishlov berish imkoniyatlarini ko'rsatib beruvchi bir namunadir.\r\n                                   "
				+ " \r\n                    ***********************************************************************************"
				+ "\r\n                                     Tuzuvchi: Pardayev Sharofiddin                                      "
				+ "\r\n                             elektron manzil: pardayev.sharofiddin@mail.ru                  "
				+ "\r\n                                                 pardayev.sharofiddin@gmail.com                "
				+ "\r\n                          murojaat uchun telefon:  +998919401027 +998946447365     "
				+ "\r\n                                                                                                                                 "
				+ "\r\n                    ***********************************************************************************");
		txtrHaqida.setBackground(Color.LIGHT_GRAY);
		txtrHaqida.setForeground(Color.BLACK);
		txtrHaqida.setFont(new Font("Sylfaen", Font.BOLD, 14));
		txtrHaqida.setColumns(65);
		txtrHaqida.setRows(40);
		contentPane2.add(txtrHaqida);
		mntmHaqida.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			  setContentPane( contentPane2 );
				
			}
		});
		menyu.add(mntmHaqida);
		
		JMenuItem mntmExit = new JMenuItem("Chiqish");
		mntmExit.addActionListener( new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			
				
			}
		});
		menyu.add(mntmExit);
		
		contentPane.setBackground(new Color(220, 220, 220));
		 
		contentPane.setLayout(null);
		setContentPane(contentPane);
		

		textInUrl = new JTextField();
		textInUrl.setBounds(174, 133, 480, 33);
		contentPane.add(textInUrl);
		textInUrl.setColumns(10);

		textOutUrl = new JTextField();
		textOutUrl.setBounds(174, 229, 480, 33);
		contentPane.add(textOutUrl);
		textOutUrl.setColumns(10);
		// ============================================================================
				final JLabel result = new JLabel("");
				result.setFont(new Font("Sylfaen", Font.BOLD, 15));
				result.setBounds(214, 298, 363, 36);
				contentPane.add(result);
		
		final JComboBox langType = new JComboBox();
		langType.setModel(new DefaultComboBoxModel(new String[] {"ara", "eng", "rus", "ara+rus", "ara+eng", "eng+rus"}));
		langType.setBounds(427, 189, 112, 20);
		contentPane.add(langType);
		// ============================================================================
		// bu yerga qanchonki chiquvchi fayl url idagi turini o'zgartiramiz
		final JComboBox outFileType = new JComboBox();
		outFileType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int indextype = 0;
				indextype = outFileType.getSelectedIndex();

				if (textOutUrl.getText().length() != 0) {

					if (indextype == 0) {
						textOutUrl
								.setText(textOutUrl
										.getText()
										.substring(
												0,
												textOutUrl.getText().length() - 4)
										.concat(".txt"));
						;
					} else if (indextype == 1) {
						textOutUrl
								.setText(textOutUrl
										.getText()
										.substring(
												0,
												textOutUrl.getText().length() - 4)
										.concat(".doc"));
						;
					} else {
						textOutUrl
								.setText(textOutUrl
										.getText()
										.substring(
												0,
												textOutUrl.getText().length() - 4)
										.concat(".pdf"));
						;
					}
				result.setText(" ");
				}
			}
		});
		outFileType.setModel(new DefaultComboBoxModel(new String[] { ".txt",
				".doc" }));
		outFileType.setBounds(174, 189, 213, 20);
		contentPane.add(outFileType);
		// ============================================================================

		JButton btnNewButton = new JButton("Tasvirni tanlash");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				result.setText("");
				OpenFile of = new OpenFile();
				int indextype = 0;
				indextype = outFileType.getSelectedIndex();
				try {
					of.PickMe();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textInUrl.setText(of.sb);
				if (indextype == 0) {
					textOutUrl.setText(of.chiq1);
				} else if (indextype == 1) {
					textOutUrl.setText(of.chiq2);
				} else if (indextype == 2) {
					textOutUrl.setText(of.chiq3);
				}
			}
		});
		btnNewButton.setBounds(664, 133, 136, 33);
		contentPane.add(btnNewButton);
		
		// ============================================================================
		JButton btnNewButton_1 = new JButton("Amalga oshirish");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int indextype = 0;
					indextype = outFileType.getSelectedIndex();
					String lang = langType.getSelectedItem().toString();
					if (indextype == 0) {
						imToFile.readAndWriteFile(textInUrl.getText(),
								textOutUrl.getText(), lang, "txt");
					} else if (indextype == 1) {
						imToFile.readAndWriteFile(textInUrl.getText(),
								textOutUrl.getText(), lang, "doc");
					} else if (indextype == 2) {
						imToFile.readAndWriteFile(textInUrl.getText(),
								textOutUrl.getText(), lang, "pdf");
					}
					result.setText("Amalga oshirildi");
					
				} catch (TesseractException | IOException e)
				{
	e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(5, 22, 154, 30);
		contentPane.add(btnNewButton_1);
		// ============================================================================
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(15, 65, 803, 12);
		contentPane.add(horizontalStrut);
		// ============================================================================
		JButton btnNewButton_2 = new JButton("Chiqish");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(693, 11, 120, 30);
		contentPane.add(btnNewButton_2);
		// ============================================================================
		JLabel lblTasvirJoylashganJoy = new JLabel("Tasvir joylashgan joy:");
		lblTasvirJoylashganJoy.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblTasvirJoylashganJoy.setBounds(15, 134, 149, 33);
		contentPane.add(lblTasvirJoylashganJoy);
		// ============================================================================
		JLabel lblChiquvchiFaylOrni = new JLabel("Chiquvchi fayl o'rni:");
		lblChiquvchiFaylOrni.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblChiquvchiFaylOrni.setBounds(10, 230, 149, 33);
		contentPane.add(lblChiquvchiFaylOrni);
		
		JLabel lblNewLabel = new JLabel("Chiquvchi fayl turi:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 189, 167, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(79, 320, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMatnTili = new JLabel("Matn tili");
		lblMatnTili.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblMatnTili.setBounds(569, 192, 106, 20);
		contentPane.add(lblMatnTili);
		
		
		
		
		// ============================================================================

	}
}
