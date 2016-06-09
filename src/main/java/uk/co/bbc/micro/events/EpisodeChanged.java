package uk.co.bbc.micro.events;

/**
 * Created by walked51 on 08/06/2016.
 */
public class EpisodeChanged {

    private String uuid;

    private String newTitle;

    private String pid;

    public EpisodeChanged() {
    }

    public EpisodeChanged(String uuid, String newTitle, String pid) {
        this.uuid = uuid;
        this.newTitle = newTitle;
        this.pid = pid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public String getPid() {
        return pid;
    }
}

