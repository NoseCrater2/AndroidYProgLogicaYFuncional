package net.ivanvega.recursoscontrolesdatos;

import java.io.Serializable;

/**
 * Created by Ángel on 07/09/2017.
 */

public class ObjContacto implements Serializable {
    private static final long serialVersionUID=1L;

    private String _nombre;
    private String _email;
    private String _twit;
    private String _tel;
    private String _fecha;

    ObjContacto(String nombre, String email, String twit, String tel, String fecha){
        this._nombre = nombre;
        this._email = email;
        this._twit = twit;
        this._tel = tel;
        this._fecha = fecha;
    }

    public void setNombre(String nombre){
        this._nombre = nombre;
    }

    public String getNombre(){
        return _nombre;
    }

    public void setEmail(String email){
        this._email = email;
    }

    public String getEmail(){
        return _email;
    }

    public void setTwit(String twit){
        this._twit = twit;
    }

    public String getTwit(){
        return _twit;
    }

    public void setTel(String tel){
        this._tel = tel;
    }

    public String getTel(){
        return _tel;
    }

    public void setFecha(String fecha){
        this._fecha = fecha;
    }

    public String getFecha(){
        return _fecha;
    }

}
