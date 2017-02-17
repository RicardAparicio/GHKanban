package inqbarna.com.ghkanban.viewmodel;

import com.inqbarna.adapters.TypeMarker;

import inqbarna.com.ghkanban.R;
import inqbarna.com.ghkanban.data.Repository;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public class RepoVM implements TypeMarker{
    private String name;

    public RepoVM(String name) {
        this.name = name;
    }

    public static RepoVM from(Repository repository) {
        return new RepoVM(repository.getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public int getItemType() {
        return R.layout.row_repo;
    }
}
