package inqbarna.com.ghkanban.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.realm.RealmObject;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner extends RealmObject {
    private String login;
    private int id;

    public Owner() {

    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
