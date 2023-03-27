package ra.model.serviceImp;

import ra.model.dao.ProdcerDAO;
import ra.model.daoImp.ProducerDAOImp;
import ra.model.entity.Producer;
import ra.model.service.ProducerService;

import java.util.List;

public class ProducerServiceImp implements ProducerService<Producer,Integer> {
    private ProdcerDAO<Producer,Integer> prodcerDAO = new ProducerDAOImp();
    @Override
    public List<Producer> findAll() {
        return prodcerDAO.findAll();
    }

    @Override
    public Producer findById(Integer id) {
        return prodcerDAO.findById(id);
    }

    @Override
    public boolean save(Producer producer) {
        return prodcerDAO.save(producer);
    }

    @Override
    public boolean update(Producer producer) {
        return prodcerDAO.update(producer);
    }

    @Override
    public boolean delete(Integer id) {
        return prodcerDAO.delete(id);
    }

    @Override
    public List<Producer> searchByName(String name) {
        return prodcerDAO.searchByName(name);
    }
}
