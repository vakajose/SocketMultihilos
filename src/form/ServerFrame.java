package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import main.Server;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerFrame extends JFrame {

	public JPanel contentPane;
	public Server server;
	


	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(9, 10, 204, 240);
		contentPane.add(list);
		
		JButton Iniciar = new JButton("Iniciar");
		Iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server.estaOyendo=true;
			}
		});
		Iniciar.setBounds(335, 10, 89, 65);
		contentPane.add(Iniciar);
		
		JButton Parar = new JButton("Parar");
		Parar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server.estaOyendo=false;
			}
		});
		Parar.setBounds(335, 86, 89, 23);
		contentPane.add(Parar);
	}



	
	

}
