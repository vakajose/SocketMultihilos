package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;

import main.Server;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainApp {

	private JFrame frame;
	public Server server;
	JLabel lblEstado;
	JList<Integer> list ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server = new Server(5000,list);
				server.start();
				lblEstado.setText("Iniciado");
				lblEstado.setForeground(Color.GREEN);
			}
		});
		btnIniciar.setBounds(297, 71, 89, 23);
		frame.getContentPane().add(btnIniciar);
		
		JButton btnPara = new JButton("Para");
		btnPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					server.server.close();
					server.interrupt();
					lblEstado.setText("Detenido");
					lblEstado.setForeground(Color.RED);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnPara.setBounds(297, 137, 89, 23);
		frame.getContentPane().add(btnPara);
		
		list = new JList();
		list.setBounds(10, 11, 167, 239);
		frame.getContentPane().add(list);
		
		lblEstado = new JLabel("DETENIDO");
		lblEstado.setForeground(Color.RED);
		lblEstado.setBackground(Color.RED);
		lblEstado.setBounds(302, 203, 84, 14);
		frame.getContentPane().add(lblEstado);
	}
}
