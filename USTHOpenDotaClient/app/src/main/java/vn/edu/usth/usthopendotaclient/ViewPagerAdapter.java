package vn.edu.usth.usthopendotaclient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.edu.usth.usthopendotaclient.searchplayerfragment.Matches_History_Fragment;
import vn.edu.usth.usthopendotaclient.searchplayerfragment.OverviewFragment;
import vn.edu.usth.usthopendotaclient.searchplayerfragment.PlayerHeroesFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private String titles[]=new String[]{"Overview","Matches","Heroes"};
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm,behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int page) {
        switch (page){
            case 0: return new OverviewFragment();
            case 1: return new Matches_History_Fragment();
            case 2: return new PlayerHeroesFragment();
            default: return new OverviewFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int page) {

        return titles[page];
    }
}


