package model;

import java.sql.Timestamp;

/**
 * Created by pghoo on 18/01/2016.
 */
public class HistoryEntry {

    private String senderName;
    private String content;
    private Timestamp sentAt;

    public HistoryEntry(String senderName, String content, Timestamp sentAt) {
        this.senderName = senderName;
        this.content = content;
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "'" + senderName + '\'' +
                " said '" + content + '\'' +
                " at " + sentAt;
    }
}
