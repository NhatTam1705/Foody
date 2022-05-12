package hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper;

import android.database.Cursor;

public interface RowMapper<T> {
    T mapRow(Cursor cs);
}
