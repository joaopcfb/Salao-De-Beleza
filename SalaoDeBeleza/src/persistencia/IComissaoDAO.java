/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Comissao;

/**
 *
 * @author joaos
 */
public interface IComissaoDAO {
     public void adiciona(Comissao comissao);
     public void SetCalcular(Integer idcomissao);
     public List<Comissao> listarComFiltro(Integer IdFuncionario);
}
