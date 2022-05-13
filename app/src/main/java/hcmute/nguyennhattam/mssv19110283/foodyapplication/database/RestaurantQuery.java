/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 5/13/2022
 * Time     : 9:01 AM
 * Filename : RestaurantQuery
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Restaurant;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper.RestaurantMapper;

public class RestaurantQuery extends AbstractQuery<Restaurant> implements IRestaurantQuery {

    private static RestaurantQuery instance = null;

    public static RestaurantQuery getInstance() {
        if (instance == null) {
            instance = new RestaurantQuery();
        }
        return instance;
    }

    @Override
    public Long insert(Restaurant restaurant) {
        final String sql = "INSERT INTO restaurant VALUES(null, ?, ?, ?, ?)";
        return insert(sql, restaurant.getName(), restaurant.getAddress(), restaurant.getPhone(), restaurant.getImagerestaurant());
    }

    @Override
    public Integer update(Restaurant restaurant) {
        final String sql = "UPDATE restaurant SET name = ?, address = ?, phone = ?, imagerestaurant = ? WHERE id = ?";
        return update(sql, restaurant.getName(), restaurant.getAddress(), restaurant.getPhone(), restaurant.getImagerestaurant(), restaurant.getId());
    }

    @Override
    public Integer delete(Integer id) {
        final String sql = "DELETE FROM restaurant WHERE id = ?";
        return delete(sql, id);
    }

    @Override
    public Restaurant findById(Integer id) {
        final String sql = "SELECT * FROM restaurant WHERE id = " + id;
        return findById(sql, new RestaurantMapper());
    }

    @Override
    public Restaurant findByName(String name) {
        final String sql = "SELECT * FROM restaurant WHERE name = '" + name + "' ";
        return findById(sql, new RestaurantMapper());
    }
}
