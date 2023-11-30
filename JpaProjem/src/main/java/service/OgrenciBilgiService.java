package service;

import dao.OgrenciBilgiDAO;
import entity.OgrenciBilgi;
import java.util.List;

public class OgrenciBilgiService implements IOgrenciBilgiService {

    private final OgrenciBilgiDAO ogrenciBilgiDAO = new OgrenciBilgiDAO();

    @Override
    public void create(OgrenciBilgi ogrenciBilgi) {
        ogrenciBilgiDAO.insert(ogrenciBilgi);
    }

    @Override
    public void update(OgrenciBilgi ogrenciBilgi) {
        ogrenciBilgiDAO.update(ogrenciBilgi);
    }

    @Override
    public void delete(OgrenciBilgi ogrenciBilgi) {
        ogrenciBilgiDAO.delete(ogrenciBilgi);
    }

    @Override
    public List<OgrenciBilgi> findAll() {
        return ogrenciBilgiDAO.findAll();
    }
}
