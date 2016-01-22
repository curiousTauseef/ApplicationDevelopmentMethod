
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        Interpreter i = null;
        History history = History.getInstance();
        PrintStream ps = null;
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ss = new ServerSocket(0, 5);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("port " + ss.getLocalPort() + " IP " + ss.getInetAddress());
        System.out.println("port " + ss.getLocalPort() + " IP " + ip);
        while (true) {
            try {
                s = ss.accept();
                ps = new PrintStream(s.getOutputStream());
                i = new Interpreter(s, "interpreter", history);
                Thread t = new Thread(i);
                t.start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
