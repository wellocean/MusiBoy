/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.io.Serializable;

/**
 *
 * @author Purevsuren
 */
public class Genre implements Serializable {
    String genreID;
    String title;

    public Genre(String genreID, String title) {
        this.genreID = genreID;
        this.title = title;
    }

    public String getGenreID() {
        return genreID;
    }

    public String getTitle() {
        return title;
    }

    public void setGenreID(String genreID) {
        this.genreID = genreID;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
