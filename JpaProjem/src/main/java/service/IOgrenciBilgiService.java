package service;

import entity.OgrenciBilgi;
import java.util.List;

public interface IOgrenciBilgiService {
    void create(OgrenciBilgi ogrenciBilgi);
    void update(OgrenciBilgi ogrenciBilgi);
    void delete(OgrenciBilgi ogrenciBilgi);
    List<OgrenciBilgi> findAll();
}