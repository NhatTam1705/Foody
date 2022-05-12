/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 11:27 PM
 * Filename : SectionPaperAdapter
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPaperAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public SectionPaperAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        titleList.add(title);

    }
}
