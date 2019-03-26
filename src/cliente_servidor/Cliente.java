package cliente_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        final String HOST = "127.0.0.1";
        final int PORTA = 5000;
        DataInputStream input;
        DataOutputStream output;

        try {
            Socket socket = new Socket(HOST, PORTA);
            
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            
            output.writeUTF("Olá mundo do cliente");
            
            String mensagem = input.readUTF();
            
            System.out.println(mensagem);
            
            socket.close();
            
            System.out.println("Conexão encerrada");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
