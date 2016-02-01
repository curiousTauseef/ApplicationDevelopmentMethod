package cdplayer;

public class Song {

    private String title;
    private String singer;

    public Song() {
        this.title = null;
        this.singer = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String toString() {
        return this.title;
    }
}
