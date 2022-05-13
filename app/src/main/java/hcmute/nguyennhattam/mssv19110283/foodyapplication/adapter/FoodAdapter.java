/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 11:17 PM
 * Filename : FoodAdapter
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.R;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IRestaurantQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.IUserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.RestaurantQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.database.UserQuery;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Food;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Restaurant;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;
    private final IRestaurantQuery restaurantQuery = RestaurantQuery.getInstance();

    public FoodAdapter(Context context, int layout, List<Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        CircleImageView civFoodImage;
        TextView tvFoodName, tvFoodPrice, tvPhone, tvRestaurant;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            viewHolder.civFoodImage = view.findViewById(R.id.civ_food_image);
            viewHolder.tvFoodName = view.findViewById(R.id.tv_food_name);
            viewHolder.tvFoodPrice = view.findViewById(R.id.tv_food_price);
            viewHolder.tvPhone = view.findViewById(R.id.tv_phone);
            viewHolder.tvRestaurant = view.findViewById(R.id.tv_restaurant);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Food food = foodList.get(i);
        Restaurant restaurant = restaurantQuery.findById(food.getRestaurant());

        byte[] foodImage = food.getImagefood();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);

        viewHolder.civFoodImage.setImageBitmap(bitmap);
        viewHolder.tvFoodName.setText(food.getName());
        viewHolder.tvFoodPrice.setText(food.getPrice());
        viewHolder.tvPhone.setText(restaurant.getPhone());
        viewHolder.tvRestaurant.setText(restaurant.getName());
        return view;
    }
}
