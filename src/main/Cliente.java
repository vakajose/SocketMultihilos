package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1",5000);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			for (int i = 0; i < 5; i++) {
				out.writeUTF("Mensaje: " + i);
				out.writeUTF("1,-17.787898, -63.179442");
				DataInputStream in = new DataInputStream(socket.getInputStream());
				System.out.println(in.readUTF());
				Thread.sleep(1000);
			}
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
