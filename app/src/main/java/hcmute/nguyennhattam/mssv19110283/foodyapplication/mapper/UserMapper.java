/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 12:46 PM
 * Filename : UserMapper
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper;

import android.database.Cursor;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.User;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(Cursor cs) {
        User user = new User();
        user.setId(cs.getInt(0));
        user.setName(cs.getString(1));
        user.setEmail(cs.getString(2));
        user.setPhone(cs.getString(3));
        user.setPassword(cs.getString(4));
        user.setAddress(cs.getString(5));
        user.setAvatar(cs.getBlob(6));
        return user;
    }
}
