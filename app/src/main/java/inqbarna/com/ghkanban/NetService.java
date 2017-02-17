package inqbarna.com.ghkanban;

import java.util.List;

import inqbarna.com.ghkanban.data.Repository;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public interface NetService {
    @GET("/repositories")
    Observable<List<Repository>> getRepositories(@Query("since") int num);

}
