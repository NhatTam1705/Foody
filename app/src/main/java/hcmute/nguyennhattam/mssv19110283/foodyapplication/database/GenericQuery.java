package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import java.util.List;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper.RowMapper;

public interface GenericQuery<T> {
    List<T> query(String sql, RowMapper<T> rowMapper);

    Long insert(String sql, Object... parameters);

    Integer update(String sql, Object... parameters);

    T findById(String sql, RowMapper<T> rowMapper);

    Integer delete(String sql, Integer id);
}
