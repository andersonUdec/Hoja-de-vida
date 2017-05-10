/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadevida;

/**
 *
 * @author Andres Chila
 */
public class Persona {
     private String cedula;
     private String correo;
     private String nombre;
     private String apellido;
     private String fechaNac;
     private Profesion profesion;
     private String genero;

    public Persona(String cedula, String correo, String nombre, String apellido, String fechaNac, Profesion profesion, String genero) {
        this.cedula = cedula;
        this.correo = correo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.profesion = profesion;
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public String toString(){
        return this.cedula +","+ this.correo+","+this.nombre+","+this.apellido+","+this.fechaNac+","+profesion.toString()+","+this.genero+";";
    }
}
