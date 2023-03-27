package ra.model.serviceImp;

import ra.model.dao.ImageDAO;
import ra.model.daoImp.ImageDAOImp;
import ra.model.entity.Image;
import ra.model.service.ImageService;

import java.util.List;

public class ImageServiceImp implements ImageService<Image,Integer> {
    private static ImageDAO<Image,Integer> imageDAO = new  ImageDAOImp();
    @Override
    public List<Image> findAll() {
        return imageDAO.findAll();
    }

    @Override
    public Image findById(Integer id) {
        return imageDAO.findById(id);
    }

    @Override
    public boolean save(Image image) {
        return imageDAO.save(image);
    }

    @Override
    public boolean update(Image image) {
        return imageDAO.update(image);
    }

    @Override
    public boolean delete(Integer id) {
        return imageDAO.delete(id);
    }

    @Override
    public List<Image> searchByName(String name) {
        return imageDAO.searchByName(name);
    }
}
