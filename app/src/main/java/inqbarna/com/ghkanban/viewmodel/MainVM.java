package inqbarna.com.ghkanban.viewmodel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import inqbarna.com.ghkanban.fragments.ExploreFragment;
import inqbarna.com.ghkanban.fragments.LocalFragment;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public class MainVM {

    private final MainPageAdapter mMainPageAdapter;

    public MainVM(FragmentManager fragmentManager) {
        mMainPageAdapter = new MainPageAdapter(fragmentManager);
    }

    public MainPageAdapter getMainPageAdapter() {
        return mMainPageAdapter;
    }

    public class MainPageAdapter extends FragmentStatePagerAdapter {
        private int NUM_ITEMS = 2;

        public MainPageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return ExploreFragment.newInstance();
                case 1:
                    return LocalFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Explore";
                case 1:
                    return "Local";
                default:
                    return null;
            }
        }

    }
}
