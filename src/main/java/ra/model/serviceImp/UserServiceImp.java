package ra.model.serviceImp;

import ra.model.dao.UserDAO;
import ra.model.daoImp.UserDAOImp;
import ra.model.entity.User;
import ra.model.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService<User,Integer> {
    private static UserDAO<User,Integer> userDAO = new UserDAOImp();
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    public boolean save(User user) {
        return userDAO.save(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return userDAO.delete(id);
    }

    @Override
    public List<User> searchByName(String name) {
        return userDAO.searchByName(name);
    }

    @Override
    public User login(String userName, String password) {
        return userDAO.login(userName,password);
    }
    public boolean unlock(Integer id){
        return userDAO.unlock(id);
    }
}
