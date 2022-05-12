/**
 * Create by: IntelliJ IDEA
 * User     : NhatTam
 * Date     : Fri, 4/29/2022
 * Time     : 10:28 PM
 * Filename : UserQuery
 */

package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import java.util.List;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.mapper.UserMapper;
import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.User;

public class UserQuery extends AbstractQuery<User> implements IUserQuery {

    private static UserQuery instance = null;

    public static UserQuery getInstance() {
        if (instance == null) {
            instance = new UserQuery();
        }
        return instance;
    }
    @Override
    public Long insert(User user) {
        final String sql = "INSERT INTO user VALUES(null, ?, ?, ?, ?, ?, ?)";
        return insert(sql, user.getName(), user.getEmail(), user.getPhone(), user.getPassword(),user.getAddress(), user.getAvatar());
    }

    @Override
    public Integer updatePassword(User user) {
        final String sql = "UPDATE user SET password = ? WHERE id = ?";
        return update(sql, user.getPassword(), user.getId());
    }

    @Override
    public Integer updateUser(User user) {
        final String sql = "UPDATE user SET name = ?, email = ?, phone = ?, password = ?, address = ?, avatar = ? WHERE id = ?";
        return update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getPassword(), user.getAddress(),user.getAvatar(), user.getId());

    }

    @Override
    public Integer updateName(User user) {
        final String sql = "UPDATE user SET name = ? WHERE id = ?";
        return update(sql, user.getName(), user.getId());
    }


    @Override
    public User findById(Integer id) {
        final String sql = "SELECT * FROM user WHERE id = " + id;
        return findById(sql, new UserMapper());
    }

    @Override
    public User findByEmail(String email) {
        final String sql = "SELECT * FROM user WHERE email = '" + email + "' ";
        List results = query(sql, new UserMapper());
        return results.size() > 0 ? (User) results.get(0) : null;
    }

    @Override
    public User findByPhone(String phone) {
        final String sql = "SELECT * FROM user WHERE phone = '" + phone + "' ";
        List results = query(sql, new UserMapper());
        return results.size() > 0 ? (User) results.get(0) : null;
    }

    @Override
    public User findByUserEmailAndPassword(String email, String password) {
        final String sql = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "' ";
        List results = query(sql, new UserMapper());
        return results.size() > 0 ? (User) results.get(0) : null;
    }
}
