
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pghoo on 18/01/2016.
 */
public class Interpreter implements Observer, Runnable {

    private InputStream in;
    private PrintStream out;
    private String name;
    private History history;
    private Socket sock;
    private Date date;
    

    public Interpreter(Socket s, String name, History history) {
        try {
            this.out = new PrintStream(s.getOutputStream());
            this.in = s.getInputStream();
            this.sock = s;
        } catch (IOException ex) {
            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.name = name;
        history.register(this);
    }
    
    public void subscribe(History history){
        this.history = history;
        System.out.println("A client subscribed to a history");
    }
    
    public void run() {
        // loop until “:quit” is read from input stream and store all lines into history
        // store in history name (String) and inputText (String)
        // “:print” outputs whole history
        Scanner sc = new Scanner(in);
        String input = "";
        out.println("write something");
        
        
        HistoryEntry he = null;
       
        while (true) {
                input = sc.nextLine();
                date = new Date();
                he = new HistoryEntry(sock.getInetAddress().getHostName(), input, new Timestamp(date.getTime()));
                history.addEntry(he);
                System.out.println("\n"+he+"\n");
                if (input.equals(":quit")) {
                    history.deregister(this);
                    break;
                }
                if (input.equals(":print")) {
                    out.println(history);
                }
            
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        out.println("update");
        newEntry((HistoryEntry) arg);
    }
    
    
    // update in observer pattern
    public void newEntry(HistoryEntry he){
        out.println(he+"\n");
    }

}
