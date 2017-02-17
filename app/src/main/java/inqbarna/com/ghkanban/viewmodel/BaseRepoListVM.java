package inqbarna.com.ghkanban.viewmodel;

import android.support.v7.widget.RecyclerView;

import inqbarna.com.ghkanban.data.RecyclerViewProvider;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public abstract class BaseRepoListVM implements RecyclerViewProvider {

    public interface RepoHandler {
        void onRepoClicked(RepoVM repoVM);
    }

    public BaseRepoListVM() {

    }
    private RepoHandler mRepoHandler = new RepoHandler() {
        @Override
        public void onRepoClicked(RepoVM repoVM) {
            onRepoVMArrived(repoVM);
        }
    };

    protected abstract void onRepoVMArrived(RepoVM repoVM);

    @Override
    public RecyclerView.Adapter getAdapter() {
        return null;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }
}
