package ra.model.service;

import java.util.List;

public interface ImageService<T,V> extends AppService<T,V>{
    List<T> searchByName(String name);
}
