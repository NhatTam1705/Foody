/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Thu, 5/12/2022
 * Time     : 4:00 PM
 * Filename : FoodMapper
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper;

import android.database.Cursor;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Food;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Restaurant;

public class FoodMapper implements RowMapper {
    @Override
    public Object mapRow(Cursor cs) {
        Food food = new Food();
        food.setId(cs.getInt(0));
        food.setName(cs.getString(1));
        food.setDescription(cs.getString(2));
        food.setPrice(cs.getString(3));
        food.setRestaurant(cs.getInt(4));
        food.setType(cs.getString(5));
        food.setImagefood(cs.getBlob(6));
        return food;
    }
}
