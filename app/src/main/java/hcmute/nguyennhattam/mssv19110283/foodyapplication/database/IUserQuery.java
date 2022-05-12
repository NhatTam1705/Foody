package hcmute.nguyennhattam.mssv19110283.foodyapplication.database;

import hcmute.nguyennhattam.mssv19110283.foodyapplication.signup.User;

public interface IUserQuery extends GenericQuery<User> {
    Long insert(User user);

    Integer updatePassword(User user);

    Integer updateUser(User user);

    Integer updateName(User user);

    User findById(Integer id);

    User findByEmail(String email);

    User findByPhone(String phone);

    User findByUserEmailAndPassword(String email, String password);
}
