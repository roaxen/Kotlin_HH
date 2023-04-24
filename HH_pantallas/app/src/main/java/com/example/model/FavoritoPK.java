package com.example.model;

public class FavoritoPK  {

    private String email;

    private int idLugar;

    public FavoritoPK() {

    }
    public FavoritoPK(Usuario user) {
        this.email = user.getEmail();

    }
    public FavoritoPK(Usuario user, int idLugar) {
        this.email = user.getEmail();
        this.idLugar = idLugar;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdLugar() {
        return this.idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FavoritoPK)) {
            return false;
        }
        FavoritoPK castOther = (FavoritoPK) other;
        return this.email.equals(castOther.email) && (this.idLugar == castOther.idLugar);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.email.hashCode();
        hash = hash * prime + this.idLugar;

        return hash;
    }

    @Override
    public String toString() {
        return "FavoritoPK [email=" + email + ", idLugar=" + idLugar + "]";
    }

}