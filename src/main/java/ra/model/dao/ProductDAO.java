package ra.model.dao;

import java.util.List;

public interface ProductDAO<T,V> extends AppDAO<T,V>{
    List<T> searchByName(String name);
}
