/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Thu, 5/12/2022
 * Time     : 6:26 PM
 * Filename : RestaurantMapper
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper;

import android.database.Cursor;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Restaurant;

public class RestaurantMapper implements RowMapper {
    @Override
    public Object mapRow(Cursor cs) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(cs.getInt(0));
        restaurant.setName(cs.getString(1));
        restaurant.setPhone(cs.getString(2));
        restaurant.setAddress(cs.getString(3));
        restaurant.setImagerestaurant(cs.getBlob(4));
        return restaurant;
    }
}
