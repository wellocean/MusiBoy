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
public class Chart implements Serializable {
    String title;
    ArrayList<SongEntity> songs = new ArrayList<SongEntity>();

    public Chart(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SongEntity> getSongs() {
        return songs;
    }

    public void addSongs(SongEntity song) {
        this.songs.add(song);
    }

    public void setSongs(ArrayList<SongEntity> songs) {
        this.songs = songs;
    }
    
    

}
