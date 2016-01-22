import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by pghoo on 18/01/2016.
 */
public class History extends Observable {

    private ArrayList<HistoryEntry> history;
    private ArrayList<Observer> subscribers;
            
    private static History ourInstance = new History();

    public static History getInstance() {
        return ourInstance;
    }

    private History() {
        history = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        System.out.println("addObserver");
        register(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        System.out.println("deleteObserver");
        deregister(o);
    }
    
    
    
    public void register(Observer ho) {
        subscribers.add(ho);
        System.out.println("A client added to subscribers");
        Interpreter interpreter = (Interpreter) ho;
        interpreter.subscribe(this);
    }
    
    public void deregister(Observer ho) {
        subscribers.remove(ho);
        System.out.println("A unsubscribed");
    }

    @Override
    public void notifyObservers(Object arg) {
        System.out.println("notify");
        addEntry((HistoryEntry)arg); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    // he synchronized keyword is all about different threads reading and writing to the same variables, objects and resources. This is not a trivial topic in Java, but here is a quote from Sun:
    // Synchronized methods enable a simple strategy for preventing thread interference and memory consistency errors: if an object is visible to more than one thread, all reads or writes to that object's variables are done through synchronized methods.
    // notify in observer
    public synchronized void addEntry(HistoryEntry he){
        history.add(he);
        Object hisEn = (Object) he;
        for (Observer ho:subscribers) {
            ho.update(this, hisEn);
        }
    }

   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HistoryEntry e:history)
            sb.append(e);
        return sb.toString();
    }
}
