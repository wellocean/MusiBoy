/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import mum.model.SongEntity;
import types.*;

/**
 *
 * @author Purevsuren
 */
@Named(value = "appManager")
@ManagedBean
@ViewScoped
public class AppManager implements Serializable {

    App app;
    String searchText;
    ArrayList<SongEntity> searchResult = new ArrayList<SongEntity>();
    private boolean isSearchRendered;
    private boolean isChartRendered;
    private boolean isBrowseRendered;

    /**
     * Creates a new instance of AppManager
     */
    public AppManager() {
        this.isBrowseRendered = false;
        this.isSearchRendered = false;
        this.isChartRendered = true;
        app = new App();
    }

    public ArrayList<Chart> getCharts() {
        return app.getCharts();
    }

    public ArrayList<SongEntity> getSongs() {
        return app.getSongs();
    }

    public boolean isIsChartRendered() {
        return isChartRendered;
    }

    public void setIsChartRendered(boolean isChartRendered) {
        this.isChartRendered = isChartRendered;
    }

    public boolean isIsBrowseRendered() {
        return isBrowseRendered;
    }

    public void setIsBrowsRendered(boolean isBrowseRendered) {
        this.isBrowseRendered = isBrowseRendered;
    }

    public boolean isIsSearchRendered() {
        return isSearchRendered;
    }

    public void setIsSearchRendered(boolean isSearchRendered) {
        this.isSearchRendered = isSearchRendered;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public ArrayList<SongEntity> getSearchResult() {
        return searchResult;
    }

    public void addSearchResult(SongEntity searchResult) {
        this.searchResult.add(searchResult);
    }

    public void browse() {
        this.setIsChartRendered(false);
        this.setIsBrowsRendered(true);
        this.setIsSearchRendered(false);
    }

    public void charts() {
        this.setIsChartRendered(true);
        this.setIsBrowsRendered(false);
        this.setIsSearchRendered(false);
    }

    public void search() {
        System.out.println(this.searchText);
        for (SongEntity s : app.songs) {
            if (s.getTitle().toLowerCase().contains(searchText.toLowerCase())) {
                this.addSearchResult(s);
            }
        }
        this.setIsChartRendered(false);
        this.setIsBrowsRendered(false);
        this.setIsSearchRendered(true);
    }

    // Aithour Wellocean
    @EJB //this annotation causes the container to inject this dependency
    private mum.db.SongEntityFacade ejbSongFacade;

    @PostConstruct  //this annotation causes this method to run after the constructor completes
    public void init() { //create a few tea products, place in database, and load into the teaEntities list


        ejbSongFacade.create(new SongEntity("song001", "Gorilla", "resources/img/album/BrunoMars-Gorilla.png", "resources/songs/BrunoMars-Gorilla.mp3", app.authors.get(3), app.genres.get(0)));
        ejbSongFacade.create(new SongEntity("song002", "Uptown Funk", "resources/img/album/BrunoMars-UptownFunk.jpg", "resources/songs/BrunoMars-UptownFunk.mp3", app.authors.get(3), app.genres.get(0)));
        ejbSongFacade.create(new SongEntity("song003", "Every Teardrop is a Waterfall", "resources/img/album/Coldplay-EveryTeardropIsaWaterfall.jpg", "resources/songs/Coldplay-EveryTeardropIsAWaterfall.mp3", app.authors.get(4), app.genres.get(1)));
        ejbSongFacade.create(new SongEntity("song004", "Paradise", "resources/img/album/paradise.jpg", "resources/songs/Coldplay-Paradise.mp3", app.authors.get(4), app.genres.get(1)));
        ejbSongFacade.create(new SongEntity("song005", "No Love", "resources/img/album/Eminem-No-Love.png", "resources/songs/Eminem-NoLove.mp3", app.authors.get(1), app.genres.get(2)));
        ejbSongFacade.create(new SongEntity("song006", "Lips of an Angel", "resources/img/album/hinder-lipsOfAngel.jpg", "resources/songs/Hinder-LipsOfAnAngel.mp3", app.authors.get(0), app.genres.get(3)));
        ejbSongFacade.create(new SongEntity("song007", "Use Me", "resources/img/album/hinder-lipsOfAngel.jpg", "resources/songs/Hinder-UseMe.mp3", app.authors.get(0), app.genres.get(3)));
        ejbSongFacade.create(new SongEntity("song008", "La La La", "resources/img/album/La_La_La_cover.png", "resources/songs/NaughtyBoy-LaLaLa.mp3", app.authors.get(2), app.genres.get(0)));
        ejbSongFacade.create(new SongEntity("song009", "Use Me", "resources/img/album/sonreal-onelongday.jpg", "resources/songs/SonReal-LA.mp3", app.authors.get(5), app.genres.get(2)));

        List<SongEntity> SongEntities = ejbSongFacade.findAll();

        for (SongEntity songEnt : SongEntities) {
            app.songs.add(songEnt);
        };

        app.charts.add(new Chart("Global Top 10"));
        app.charts.add(new Chart("USA Top 10"));

        app.charts.get(0).setSongs(app.songs);
        app.charts.get(1).setSongs(app.songs);

        app.users.add(new User("user001", "Puujee", "password"));

        app.playlists.add(new Playlist("list001", "Favourites", app.users.get(0)));

        app.playlists.get(0).addPlaylist(app.songs.get(5));
        app.playlists.get(0).addPlaylist(app.songs.get(6));
        app.playlists.get(0).addPlaylist(app.songs.get(2));
        app.playlists.get(0).addPlaylist(app.songs.get(0));
//      Stored Data Implementation

    }

}
