package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import service.OgrenciBilgiService;
import service.OgrenciBilgiService;
import entity.OgrenciBilgi;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class OgrenciBilgiController implements Serializable {

    private final OgrenciBilgiService ogrenciBilgiService = new OgrenciBilgiService();
    private OgrenciBilgi ogrenciBilgi = new OgrenciBilgi();
    private boolean updateMode = false;

    public void create() {
        ogrenciBilgiService.create(ogrenciBilgi);
        ogrenciBilgi = new OgrenciBilgi();
        updateMode = false;
    }

    public void update() {
        ogrenciBilgiService.update(ogrenciBilgi);
        ogrenciBilgi = new OgrenciBilgi();
        updateMode = false;
    }

    public void deleteConfirm(OgrenciBilgi ogrenciBilgi) {
        this.ogrenciBilgi = ogrenciBilgi;
    }

    public void delete() {
        ogrenciBilgiService.delete(ogrenciBilgi);
        ogrenciBilgi = new OgrenciBilgi();
    }

    public void updateForm(OgrenciBilgi ogr) {
        ogrenciBilgi = ogr;
        updateMode = true;
    }

    public void clearForm() {
        ogrenciBilgi = new OgrenciBilgi();
        updateMode = false;
    }

    public List<OgrenciBilgi> getOgrenciBilgiList() {
        return ogrenciBilgiService.findAll();
    }

    public OgrenciBilgi getOgrenciBilgi() {
        return ogrenciBilgi;
    }

    public void setOgrenciBilgi(OgrenciBilgi ogrenciBilgi) {
        this.ogrenciBilgi = ogrenciBilgi;
    }

    public boolean isUpdateMode() {
        return updateMode;
    }

    public void setUpdateMode(boolean updateMode) {
        this.updateMode = updateMode;
    }
}