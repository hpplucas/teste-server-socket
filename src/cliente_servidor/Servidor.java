package cliente_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    
    public static void main(String[] args) {
        
        ServerSocket servidor = null;
        Socket socket = null;
        DataInputStream input;
        DataOutputStream output;
            
        final int PORTA = 5000;
            
        try {
            
            servidor = new ServerSocket(PORTA);
            System.out.println("Servidor iniciado");
            
            while (true) {// Servidor sempre atento
                socket = servidor.accept();
                
                System.out.println("Cliente conectado");
                
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
                
                String mensagem = input.readUTF();
                
                System.out.println(mensagem);
                
                output.writeUTF("Olá mundo (servidor) ");
                
                socket.close();
                System.out.println("Cliente desconectado");
                
            }
            
            
            
        } catch (IOException ex) {
            
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
