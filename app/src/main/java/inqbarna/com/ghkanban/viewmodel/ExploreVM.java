package inqbarna.com.ghkanban.viewmodel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import inqbarna.com.ghkanban.App;
import inqbarna.com.ghkanban.NetService;
import inqbarna.com.ghkanban.data.Repository;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public class ExploreVM extends BaseRepoListVM {

    private final List<RepoVM> mRepoVMs;
    private       Context      mContext;

    public ExploreVM(Context context) {
        super(context);
        mContext = context;
        mRepoVMs = new ArrayList<>();
        NetService netService = App.globals(context).getNetService();
        netService.getRepositories(1)
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Action1<List<Repository>>() { // // TODO: 17/02/17 missing pagination
            @Override
            public void call(List<Repository> repositories) {
                for (Repository repository : repositories) {
                    RepoVM from = RepoVM.from(repository);
                    mRepoVMs.add(from);
                }
                setData(mRepoVMs);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("BORRAME", "error with repositories", throwable);
            }
        });
    }

    @Override
    protected void onRepoVMArrived(RepoVM repoVM) {
        Toast.makeText(mContext, "Repo clicked: " + repoVM.getName(), Toast.LENGTH_SHORT).show();
    }
}
