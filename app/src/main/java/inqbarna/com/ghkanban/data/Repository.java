package inqbarna.com.ghkanban.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.realm.RealmObject;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository extends RealmObject {
    private int    id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private Owner  owner;

    public Repository() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
