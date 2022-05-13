/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Thu, 5/12/2022
 * Time     : 11:29 PM
 * Filename : ManageFoodFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.manage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;

public class ManageFoodFragment extends Fragment {

    private Button btnAddFood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_manage_food, container, false);
        return root;
    }
}
