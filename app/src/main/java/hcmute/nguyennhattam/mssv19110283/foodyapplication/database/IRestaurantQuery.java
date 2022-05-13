package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.domain.Restaurant;

public interface IRestaurantQuery extends GenericQuery<Restaurant> {
    Long insert(Restaurant restaurant);

    Integer update(Restaurant restaurant);

    Integer delete(Integer id);

    Restaurant findById(Integer id);

    Restaurant findByName(String name);
}
