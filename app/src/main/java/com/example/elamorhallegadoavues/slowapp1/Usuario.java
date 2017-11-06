package com.example.elamorhallegadoavues.slowapp1;

/**
 * Created by elamorhallegadoavues on 18/10/2017.
 */

public class Usuario {
    String nomnre;
    int id;
    String correo;

    public Usuario(String nomnre, int id, String correo) {
        this.nomnre = nomnre;
        this.id = id;
        this.correo = correo;
    }

    public String getNomnre() {
        return nomnre;
    }

    public void setNomnre(String nomnre) {
        this.nomnre = nomnre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
