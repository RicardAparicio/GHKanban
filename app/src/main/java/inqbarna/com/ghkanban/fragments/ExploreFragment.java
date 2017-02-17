package inqbarna.com.ghkanban.fragments;/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inqbarna.com.ghkanban.R;
import inqbarna.com.ghkanban.databinding.RecyclerviewBinding;
import inqbarna.com.ghkanban.viewmodel.ExploreVM;

public class ExploreFragment extends Fragment {
    public static ExploreFragment newInstance() {
        ExploreFragment frag = new ExploreFragment();
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerviewBinding binding = DataBindingUtil.inflate(inflater, R.layout.recyclerview, container, false);
        binding.setModel(new ExploreVM(getActivity()));
        return binding.getRoot();
    }
}
