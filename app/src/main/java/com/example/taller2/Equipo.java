package com.example.taller2;
import android.os.Parcel;
import android.os.Parcelable;

public class Equipo implements Parcelable {

     String nombre;
     String director;
     String ciudad;
     int campeonatos;

    public Equipo() {
    }

    public Equipo(String nombre, String director, String ciudad, int campeonatos) {
        this.nombre = nombre;
        this.director = director;
        this.ciudad = ciudad;
        this.campeonatos = campeonatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(int campeonatos) {
        this.campeonatos = campeonatos;
    }

    protected Equipo(Parcel in) {
        nombre = in.readString();
        director = in.readString();
        ciudad = in.readString();
        campeonatos = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(director);
        dest.writeString(ciudad);
        dest.writeInt(campeonatos);
    }

    public static Creator<Equipo> getCREATOR() {
        return CREATOR;
    }

 
    @SuppressWarnings("unused")
    public static final Creator<Equipo> CREATOR = new Creator<Equipo>() {
        @Override
        public Equipo createFromParcel(Parcel in) {
            return new Equipo(in);
        }

        @Override
        public Equipo[] newArray(int size) {
            return new Equipo[size];
        }
    };
}