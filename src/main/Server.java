package main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;


public class Server extends Thread {
	public DefaultListModel<Integer> model;
	public JList<Integer> list;
	public int puerto = 5000;
	public ServerSocket server;
	public Map<Integer, HiloCliente> hilos;
	public boolean estaOyendo = true;
//	public DataInputStream in;
//	public DataOutputStream out;
//	
	public Server(int puerto, JList list) {
		this.puerto = puerto;
		this.list = list;
	}
	public void run() {
		try {
			server = new ServerSocket(puerto);
			System.out.println("Hilo de servidor escuchando en puerto: " + puerto);
			hilos = new LinkedHashMap<>();
			int i=0;
			while(estaOyendo) {
				Socket socket = server.accept();
				System.out.println("Exitoso: " + socket.getInetAddress().getHostAddress());
				HiloCliente hilo = new HiloCliente(socket,i);
				hilo.start();
				hilos.put(i, hilo);
				i++;
//				model.addElement(i);
//				list.setModel(model);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
