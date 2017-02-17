package inqbarna.com.ghkanban.data;

import io.realm.RealmObject;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public class Repository extends RealmObject {
    private int id;
    private String name;
    private String full_name;
    private Owner owner;

    public Repository() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }
}
