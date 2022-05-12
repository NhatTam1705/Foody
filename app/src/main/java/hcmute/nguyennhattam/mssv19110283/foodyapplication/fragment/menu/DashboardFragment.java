/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 12:13 PM
 * Filename : DashboardFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.category.ViewPagerAdapter;

public class DashboardFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Activity activity = getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        ViewPager viewPager = root.findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(
               getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        return root;
    }
}
