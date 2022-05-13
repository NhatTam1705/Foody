/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 5/13/2022
 * Time     : 8:51 AM
 * Filename : FoodQuery
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Food;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper.FoodMapper;

public class FoodQuery extends AbstractQuery<Food> implements IFoodQuery {

    private static FoodQuery instance = null;

    public static FoodQuery getInstance() {
        if (instance == null) {
            instance = new FoodQuery();
        }
        return instance;
    }

    @Override
    public Long insert(Food food) {
        final String sql = "INSERT INTO food VALUES(null, ?, ?, ?, ?, ?, ?)";
        return insert(sql, food.getName(), food.getDescription(), food.getPrice(), food.getRestaurant(), food.getType(), food.getImagefood());
    }

    @Override
    public Integer update(Food food) {
        final String sql = "UPDATE food SET name = ?, description = ?, price = ?, restaurant = ?, type = ?, imagefood = ? WHERE id = ?";
        return update(sql, food.getName(), food.getDescription(), food.getPrice(), food.getRestaurant(), food.getType(), food.getImagefood(), food.getId());
    }

    @Override
    public Integer delete(Integer id) {
        final String sql = "DELETE FROM food WHERE id = ?";
        return delete(sql, id);
    }

    @Override
    public Food findById(Integer id) {
        final String sql = "SELECT * FROM food WHERE id = " + id;
        return findById(sql, new FoodMapper());
    }

    @Override
    public Food findByName(String name) {
        final String sql = "SELECT * FROM food WHERE name = '" + name + "' ";
        return findById(sql, new FoodMapper());
    }

    @Override
    public Food findByRestaurant(String restaurant) {
        final String sql = "SELECT * FROM food WHERE restaurant = '" + restaurant + "' ";
        return findById(sql, new FoodMapper());
    }

    @Override
    public Food findAllFood() {
        final String sql = "SELECT * FROM food";
        return findById(sql, new FoodMapper());
    }
}
