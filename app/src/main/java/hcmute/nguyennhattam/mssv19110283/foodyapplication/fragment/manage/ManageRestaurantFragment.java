/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Thu, 5/12/2022
 * Time     : 11:30 PM
 * Filename : ManageRestaurantFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.manage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.activity.AddRestaurantActivity;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.activity.SplashActivity;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.RegisterActivity;

public class ManageRestaurantFragment extends Fragment {

    private Button btnAddRestaurant;
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_manage_restaurant, container, false);

        binding();

        btnAddRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddRestaurantActivity.class));
            }
        });

        return root;
    }

    private void binding() {
        btnAddRestaurant = root.findViewById(R.id.btn_add);
    }
}
