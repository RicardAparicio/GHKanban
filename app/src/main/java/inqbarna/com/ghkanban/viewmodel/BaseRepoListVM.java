package inqbarna.com.ghkanban.viewmodel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.databinding.library.baseAdapters.BR;
import com.inqbarna.adapters.BasicBindingAdapter;
import com.inqbarna.adapters.BindingAdapter;
import com.inqbarna.adapters.TypeMarker;
import com.inqbarna.adapters.VariableBinding;

import java.util.List;

import inqbarna.com.ghkanban.data.RecyclerViewProvider;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public abstract class BaseRepoListVM implements RecyclerViewProvider {

    private final BasicBindingAdapter mAdapter;
    private final LinearLayoutManager mLinearLayoutManager;

    public interface RepoHandler {
        void onRepoClicked(RepoVM repoVM);
    }

    public BaseRepoListVM(Context context) {
        mAdapter = new BasicBindingAdapter(new BindingAdapter.ItemBinder() {
            @Override
            public void bindVariables(VariableBinding variableBinding, int pos, TypeMarker dataAtPos) {
                variableBinding.bindValue(BR.model, dataAtPos);
                variableBinding.bindValue(BR.handler, mRepoHandler);
            }
        });
        mLinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
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
        return mAdapter;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return mLinearLayoutManager;
    }

    public void setData(List<RepoVM> list) {
        mAdapter.setItems(list);
    }
}
