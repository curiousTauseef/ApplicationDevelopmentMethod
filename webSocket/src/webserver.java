import model.History;
import model.Interpreter;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pghoo on 19/01/2016.
 */
public class webserver {


    public void main(String args[]) {
        ServerSocket ss = null;
        Socket s = null;
        Interpreter i = null;
        History history = History.getInstance();
        PrintStream ps = null;
        try {
            ss = new ServerSocket(0, 5);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("port" + ss.getLocalPort() + " IP " + ss.getInetAddress());
        try {
            s = ss.accept();
            ps = new PrintStream(s.getOutputStream());
            i = new Interpreter(ps, s.getInputStream(), "interpreter", history);
            i.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
