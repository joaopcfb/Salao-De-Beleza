/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author joaos
 */
public class Usuario {
    private Integer Id;
    private String usuario;
    private String senha;
    private String TipoUsuario;

    public Usuario(String usuario, String senha, String TipoUsuario) {
        this.usuario = usuario;
        this.senha = senha;
        this.TipoUsuario = TipoUsuario;
    }
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(Integer Id, String usuario,  String TipoUsuario) {
        this.Id = Id;
        this.usuario = usuario;
        this.TipoUsuario = TipoUsuario;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }
    
    public Usuario() {

    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
