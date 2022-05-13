/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 12:14 PM
 * Filename : NotificationsFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;

public class RestaurantFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);
        return root;
    }
}
