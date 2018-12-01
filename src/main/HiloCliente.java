package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread {
	
	public Socket socket;
	public int id;
	
	public HiloCliente(Socket socket, int id) {
		super();
		this.id=id;
		this.socket = socket;
	}
	public void run() {
		MYSQLAccess.iniciar();
		try {	
			String clientAddress = socket.getInetAddress().getHostAddress();
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Conectado exitosamente hilo: " + id);
			String mensaje;
			int i=1;
			while(true) {
				DataInputStream in= new DataInputStream(socket.getInputStream());
				while((mensaje = in.readUTF())!=null) {
					System.out.println("From: " + clientAddress + " | HILO : "+id +" | "+mensaje);
					out.writeUTF("Enviado mensaje: "+i);
					i++;
					Integer num = Integer.parseInt(mensaje.substring(0, 1));
					if( num != null) {
						String[] s = mensaje.split(",");
						MYSQLAccess.insert(num, s[1], s[2]);
					}
				}
			}
		} catch (Exception e) {

		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
