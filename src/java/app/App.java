/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import mum.model.SongEntity;
import types.*;

/**
 *
 * @author Purevsuren
 */
public class App {
//    Stored Datas

    ArrayList<Author> authors = new ArrayList<Author>();
    ArrayList<Genre> genres = new ArrayList<Genre>();
    ArrayList<SongEntity> songs = new ArrayList<SongEntity>();
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Playlist> playlists = new ArrayList<Playlist>();
    ArrayList<Chart> charts = new ArrayList<Chart>();
//    Stored Datas

    //Wellocean
    @EJB //this annotation causes the container to inject this dependency
    private mum.db.SongEntityFacade ejbSongFacade;

//    App needed datas
    ArrayList<SongEntity> currentPlayList = new ArrayList<SongEntity>();
//    App needed datas

    public App() {
        //      Stored Data Implementation

        authors.add(new Author("aut001", "Hinder"));
        authors.add(new Author("aut002", "Eminem"));
        authors.add(new Author("aut003", "Naughty Boy"));
        authors.add(new Author("aut004", "Bruno Mars"));
        authors.add(new Author("aut005", "Coldplay"));
        authors.add(new Author("aut006", "Sonreal"));

        genres.add(new Genre("gen001", "Pop"));
        genres.add(new Genre("gen001", "Pop-Rock"));
        genres.add(new Genre("gen002", "Rap"));
        genres.add(new Genre("gen003", "Rock"));

    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<SongEntity> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<SongEntity> songs) {
        this.songs = songs;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Chart> getCharts() {
        return charts;
    }

    public void setCharts(ArrayList<Chart> charts) {
        this.charts = charts;
    }

    public ArrayList<SongEntity> getCurrentPlayList() {
        return currentPlayList;
    }

    public void setCurrentPlayList(ArrayList<SongEntity> currentPlayList) {
        this.currentPlayList = currentPlayList;
    }

}
