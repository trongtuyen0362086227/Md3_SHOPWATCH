package ra.model.service;

import java.util.List;

public interface ProducerService<T,V> extends ProductService<T,V>{
    List<T> searchByName(String name);
}
