/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.io.Serializable;
import java.util.ArrayList;
import mum.model.SongEntity;

/**
 *
 * @author Purevsuren
 */
public class Playlist implements Serializable {
    String playlistID;
    String title;
    User user;
    ArrayList<SongEntity> playlist = new ArrayList<SongEntity>();

    public Playlist(String playlistID, String title, User user) {
        this.playlistID = playlistID;
        this.title = title;
        this.user = user;
    }

    public String getPlaylistID() {
        return playlistID;
    }

    public String getTitle() {
        return title;
    }

    public User getUserID() {
        return user;
    }

    public void setPlaylistID(String playlistID) {
        this.playlistID = playlistID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserID(User user) {
        this.user = user;
    }

    public ArrayList<SongEntity> getPlaylist() {
        return playlist;
    }

    public void addPlaylist(SongEntity song) {
        this.playlist.add(song);
    }
}
