package com.model.events.rest.wrappers;

import com.model.events.entities.Preferencias;

import java.util.List;

/**
 * Created by Junior on 13/09/2016.
 */
public class UsuarioPreferencia  {
    private List<Preferencias> mPreferenciasList;
    private String idUsuario;

    public UsuarioPreferencia(List<Preferencias> mPreferenciasList, String idUsuario) {
        this.mPreferenciasList = mPreferenciasList;
        this.idUsuario = idUsuario;
    }

    public List<Preferencias> getmPreferenciasList() {
        return mPreferenciasList;
    }

    public void setmPreferenciasList(List<Preferencias> mPreferenciasList) {
        this.mPreferenciasList = mPreferenciasList;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
