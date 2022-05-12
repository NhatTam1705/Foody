/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Sat, 5/7/2022
 * Time     : 12:15 AM
 * Filename : ViewPagerAdapter
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.category;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DrinkFragment();
            case 1:
                return new FoodFragment();
            case 2:
                return new OrderFragment();
            default:
                return new OrderFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Drink";
                break;
            case 1:
                title = "Food";
                break;
            case 2:
                title = "Order";
                break;
        }
        return title;
    }
}
