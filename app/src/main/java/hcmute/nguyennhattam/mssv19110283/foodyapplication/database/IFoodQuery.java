package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Food;

public interface IFoodQuery extends GenericQuery<Food> {
    Long insert(Food food);

    Integer update(Food food);

    Integer delete(Integer id);

    Food findById(Integer id);

    Food findByName(String name);

    Food findByRestaurant(String restaurant);

    Food findAllFood();
}
