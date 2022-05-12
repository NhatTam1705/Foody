/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 11:32 PM
 * Filename : OrderFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;

public class OrderFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
}
