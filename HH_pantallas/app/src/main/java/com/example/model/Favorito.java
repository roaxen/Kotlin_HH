package com.example.model;

public class Favorito {

    private FavoritoPK id;

    @Override
    public String toString() {
        return "Favorito [id=" + id + "]";
    }

    public Favorito() {
    }

    public Favorito(Usuario user, int idLugar) {
        this.id = new FavoritoPK(user, idLugar);
    }
    public FavoritoPK getId() {
        return this.id;
    }

    public void setId(FavoritoPK id) {
        this.id = id;
    }
}