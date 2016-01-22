import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pghoo on 19/01/2016.
 */
public class webserver {


    public void main(String args[]) {
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(0, 5);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("port" + ss.getLocalPort() + " IP " + ss.getInetAddress());
        try {
            s = ss.accept();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
