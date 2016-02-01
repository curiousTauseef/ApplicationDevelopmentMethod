package cdplayer;

import java.util.ArrayList;

public class CD {

    private String CDtitle;
    private String singer; 
    private ArrayList<Song> songs;

    public CD(String cdTitle, String singer) {
        this.CDtitle = cdTitle;
        this.singer = singer;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return CDtitle;
    }

    public void setTitle(String title) {
        this.CDtitle = title;
    }

    public void addSongs(Song song) {
        songs.add(song);
    }

    public ArrayList<Song> getSongs() {
        return songs;   
    }

}
