/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 11:32 PM
 * Filename : FoodFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.adapter.FoodAdapter;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Foods;

public class FoodFragment extends Fragment {
//    private RecyclerView.Adapter adapter;
//    private RecyclerView recyclerViewCategoryList;
//    View myFragment;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        myFragment = LayoutInflater.from(getContext()).inflate(R.layout.fragment_food,container,false);
//        recyclerViewCategory();
//        return myFragment;
//    }
//
//    private void recyclerViewCategory(){
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext()
//                ,LinearLayoutManager.VERTICAL, false);
//        recyclerViewCategoryList = myFragment.findViewById(R.id.recyclerView);
//        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
//
//        ArrayList<Foods> categories = new ArrayList<>();
//        categories.add(new Foods("Bánh Canh","banhcanh","35,000.00đ"));
//        categories.add(new Foods("Cơm","com","25,000.00đ"));
//        categories.add(new Foods("Bún Bò","bunbo","40,000.00đ"));
//        categories.add(new Foods("Bún mắm","bunmam","35,000.00đ"));
//
//        adapter = new FoodAdapter(categories);
//        recyclerViewCategoryList.setAdapter(adapter);
//    }
}
