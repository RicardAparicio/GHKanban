package inqbarna.com.ghkanban.data;

import android.support.v7.widget.RecyclerView;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public interface RecyclerViewProvider {
    RecyclerView.Adapter getAdapter();
    RecyclerView.LayoutManager getLayoutManager();
}
