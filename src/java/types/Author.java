/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Purevsuren
 */
public class Author implements Serializable {
    String authorID;
    String name;

    public Author(String authorID, String fullname) {
        this.authorID = authorID;
        this.name = fullname;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getName() {
        return name;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
}
