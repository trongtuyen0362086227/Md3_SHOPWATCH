package ra.model.service;

import ra.model.entity.User;

import java.util.List;

public interface UserService<T,V> extends AppService<T,V> {
    List<T> searchByName(String name);
    User login(String userName,String password);
    boolean unlock(Integer id);
}
