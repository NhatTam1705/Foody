/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 12:10 PM
 * Filename : HomeFragment
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.fragment.menu;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.adapter.FoodAdapter;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.FoodQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IFoodQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Food;

public class HomeFragment extends Fragment {

    private RecyclerView rvFood;
    ArrayList<Food> foodArrayList;
    FoodAdapter foodAdapter;
    View root;
    private final IFoodQuery foodQuery = FoodQuery.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_home, container, false);

        binding();

        foodArrayList = new ArrayList<>();
        foodAdapter = new FoodAdapter(getContext(), R.layout.row_food_item, foodArrayList);

        Cursor cs = (Cursor) foodQuery.findAllFood();
        while(cs.moveToNext()) {
            Food food = new Food();
            food.setId(cs.getInt(0));
            food.setName(cs.getString(1));
            food.setDescription(cs.getString(2));
            food.setPrice(cs.getString(3));
            food.setRestaurant(cs.getInt(4));
            food.setType(cs.getString(5));
            food.setImagefood(cs.getBlob(6));
            foodArrayList.add(food);
        }

        foodAdapter.notifyDataSetChanged();

        return root;
    }

    private void binding() {
        rvFood = root.findViewById(R.id.rv_food);
    }
}
