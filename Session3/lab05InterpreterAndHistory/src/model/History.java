package model;

import java.util.ArrayList;

/**
 * Created by pghoo on 18/01/2016.
 */
public class History {

    private ArrayList<HistoryEntry> history;
    private static History ourInstance = new History();

    public static History getInstance() {
        return ourInstance;
    }

    private History() {
        history = new ArrayList<HistoryEntry>();
    }

    public void addEntry(HistoryEntry e){
        history.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HistoryEntry e:history)
            sb.append(e);
        return sb.toString();
    }
}
