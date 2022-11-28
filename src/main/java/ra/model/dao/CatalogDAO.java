package ra.model.dao;

import ra.model.entity.CatalogCombobox;

import java.util.List;

public interface CatalogDAO<T,V> extends AppDAO<T,V>{
    List<T> searchByName(String name);
    public List<CatalogCombobox> findCatalogCombobox();
}
