
package testepoo.wanderson.models;

import java.util.ArrayList;
import testepoo.wanderson.entities.Funcionario;
import testepoo.wanderson.entities.Venda;

public class VendaModel {
    static ArrayList<Venda> vendas;
    
    public VendaModel(){
        if(vendas == null){
            vendas = new ArrayList<>();
        }
    }

    
    public double getComissaoVendedor(int idVendedor, String mesAno){
        FuncionarioModel fm = new FuncionarioModel();
        Funcionario vendedor = fm.getVendedorById(idVendedor);
        
        double comissao=0;
        for (int i = 0; i < vendas.size(); i++) {
            if(vendas.get(i).getIdVendedor() == idVendedor){
                for (int j = 0; j < vendas.get(i).getMesAno().size(); j++) {
                    if (vendas.get(i).getMesAno().get(j).equals(mesAno)) {
                        comissao = vendas.get(i).getValorVendidoMes().get(j) * vendedor.getCargo().getBeneficio();
                    }
                }
            }
        }
        return comissao;
    }
    public void adicionar(Venda venda){
       vendas.add(venda);
        
    }
    
}
