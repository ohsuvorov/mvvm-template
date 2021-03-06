package com.duyp.architecture.mvvm.ui.modules.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.duyp.architecture.mvvm.injection.qualifier.ActivityFragmentManager;
import com.duyp.architecture.mvvm.ui.modules.feed.FeedFragment;
import com.duyp.architecture.mvvm.ui.modules.repo.list.RepoListFragment;

import javax.inject.Inject;

/**
 * Created by duypham on 10/25/17.
 *
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    @Inject
    public MainPagerAdapter(@ActivityFragmentManager FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FeedFragment();
            case 1:
                return RepoListFragment.newInstance(null, true);
            case 2:
                return FeedFragment.newInstance("hungpn", true);
            case 3:
                return RepoListFragment.newInstance("hungpn", true);
            default: return new FeedFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
