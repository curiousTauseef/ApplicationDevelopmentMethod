import java.util.ArrayList;

/**
 * Created by pghoo on 18/01/2016.
 */
public class History {

    private ArrayList<HistoryEntry> history;
    private ArrayList<HistoryObserver> subscribers;
            
    private static History ourInstance = new History();

    public static History getInstance() {
        return ourInstance;
    }

    private History() {
        history = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public void register(HistoryObserver ho) {
        subscribers.add(ho);
        System.out.println("A client added to subscribers");
        ho.subscribe(this);
    }
    
    public void deregister(HistoryObserver ho) {
        subscribers.remove(ho);
        System.out.println("A unsubscribed");
    }
    
    // he synchronized keyword is all about different threads reading and writing to the same variables, objects and resources. This is not a trivial topic in Java, but here is a quote from Sun:
    // Synchronized methods enable a simple strategy for preventing thread interference and memory consistency errors: if an object is visible to more than one thread, all reads or writes to that object's variables are done through synchronized methods.
    // notify in observer
    public synchronized void addEntry(HistoryEntry he){
        history.add(he);
        for (HistoryObserver ho:subscribers) {
            ho.newEntry(he);
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
