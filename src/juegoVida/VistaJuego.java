package juegoVida;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JRadioButton;

public class VistaJuego extends JFrame {

	private JPanel contentPane;
	private boolean valorRun;
	private boolean esAleatorio;

 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaJuego frame = new VistaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaJuego() throws InterruptedException {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 0, 1320, 770);
		this.setResizable(false);
		this.setUndecorated(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1300, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		 
		PanelJuego panelJuego= new PanelJuego(20, 10000);		
		contentPane.add(panelJuego);
		
		JButton btnNewButton = new JButton("INICIAR");
		btnNewButton.setIcon(new ImageIcon("juegoVida/play.png"));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 24));
		btnNewButton.setBounds(1068, 12, 220, 60);
		btnNewButton.setBackground(Color.GRAY);
		panel.add(btnNewButton);
		
		JLabel lblCreadoPorHugo = new JLabel("Creado por:");
		lblCreadoPorHugo.setFont(new Font("Droid Sans Mono Dotted for Powerline", Font.BOLD, 18));
		lblCreadoPorHugo.setBounds(232, 12, 122, 36);
		panel.add(lblCreadoPorHugo);
		
		JLabel youtube = new JLabel("");
		youtube.setIcon(new ImageIcon("juegoVida/youtube.png"));
		youtube.setBounds(426, 12, 64, 60);
		panel.add(youtube);
		
		JLabel youtube_1 = new JLabel("");
		youtube_1.setIcon(new ImageIcon("juegoVida/linkedin.png"));
		youtube_1.setBounds(597, 12, 64, 60);
		panel.add(youtube_1);
		
		JLabel youtube_1_1 = new JLabel("");
		youtube_1_1.setIcon(new ImageIcon("uegoVida/gitHub.png"));
		youtube_1_1.setBounds(510, 12, 64, 60);
		panel.add(youtube_1_1);
		
		JRadioButton rdbtnAleatoriedad = new JRadioButton("Aleatoriedad");
		rdbtnAleatoriedad.setFont(new Font("Droid Sans Mono for Powerline", Font.BOLD, 18));
		rdbtnAleatoriedad.setBounds(871, 30, 175, 31);
		
		rdbtnAleatoriedad.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				esAleatorio = !esAleatorio;
			}
		});
		
		panel.add(rdbtnAleatoriedad);
		
		JLabel lblHugoVeraS = new JLabel("Hugo Vera S.");
		lblHugoVeraS.setFont(new Font("Droid Sans Mono Slashed for Powerline", Font.BOLD | Font.ITALIC, 19));
		lblHugoVeraS.setBounds(232, 36, 142, 36);
		panel.add(lblHugoVeraS);
		
		JLabel youtube_2 = new JLabel("");
		youtube_2.setIcon(new ImageIcon("juegoVida/juegoVida.png"));
		youtube_2.setBounds(22, 12, 153, 60);
		panel.add(youtube_2);
		
		valorRun= false;
		esAleatorio= false;
		
		Thread hilo= new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {

						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					while(valorRun) {

						panelJuego.definirColores(esAleatorio);	
						try {

							Thread.sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		});
		
		hilo.start();
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {					
				

				if(btnNewButton.getBackground().equals(Color.GRAY)) {
					
					valorRun=true; 
					
					btnNewButton.setText("DETENER");
					btnNewButton.setIcon(new ImageIcon("juegoVida/pause.png"));
					btnNewButton.setBackground(new Color(255,255,255));
						
				}else {	
					
					valorRun=false; 
					
					btnNewButton.setText("INICIAR");
					btnNewButton.setIcon(new ImageIcon("juegoVida/play.png"));
					btnNewButton.setBackground(Color.GRAY);	
				}
				
				
								
			}
		});
			
	}
}
