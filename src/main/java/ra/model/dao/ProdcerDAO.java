package ra.model.dao;

import java.util.List;

public interface ProdcerDAO<T,V> extends AppDAO<T,V> {
    List<T> searchByName(String name);
}
