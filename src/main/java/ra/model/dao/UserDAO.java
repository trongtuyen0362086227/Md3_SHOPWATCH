package ra.model.dao;

import ra.model.entity.User;

import java.util.List;

public interface UserDAO<T,V> extends AppDAO<T,V> {
    List<T> searchByName(String name);
    User login(String userName, String password);
    boolean unlock(Integer id);
}
