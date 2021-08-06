/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author yolan
 */
public class Kostumer {
    private String idUser,namaUser,alamatUser,jkUser;
    private String umurUser;
    private String noUser,nikUser;

    public Kostumer(String idUser, String namaUser, String nikUser, String umurUser, String noUser, String almatUser, String jkUser) {
        this.idUser = idUser;
        this.namaUser = namaUser;        
        this.nikUser = nikUser;
        this.umurUser = umurUser;
        this.noUser = noUser;
        this.alamatUser = alamatUser;
        this.jkUser = jkUser;

    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getAlamatUser() {
        return alamatUser;
    }

    public void setAlamatUser(String alamatUser) {
        this.alamatUser = alamatUser;
    }

    public String getJkUser() {
        return jkUser;
    }

    public void setJkUser(String jkUser) {
        this.jkUser = jkUser;
    }

    public String getUmurUser() {
        return umurUser;
    }

    public void setUmurUser(String umurUser) {
        this.umurUser = umurUser;
    }

    public String getNoUser() {
        return noUser;
    }

    public void setNoUser(String noUser) {
        this.noUser = noUser;
    }

    public String getNikUser() {
        return nikUser;
    }

    public void setNikUser(String nikUser) {
        this.nikUser = nikUser;
    }
    
    
}
