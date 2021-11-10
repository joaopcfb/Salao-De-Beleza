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
public class FuncionarioFuncao {
    int id;
    String Descricao;

    public FuncionarioFuncao(int id, String Descricao) {
        this.id = id;
        this.Descricao = Descricao;
    }

    public FuncionarioFuncao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FuncionarioFuncao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public String toString() {
        return Descricao;
    }


}
