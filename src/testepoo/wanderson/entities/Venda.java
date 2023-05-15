
package testepoo.wanderson.entities;

import java.util.ArrayList;

public class Venda {
    private int idVendedor;
    private ArrayList<String> mesAno;
    private ArrayList<Double> valorVendidoMes;

    public Venda(int idVendedor, ArrayList<String> mesAno, ArrayList<Double> valorVendidoMes) {
        this.idVendedor = idVendedor;
        this.mesAno = mesAno;
        this.valorVendidoMes = valorVendidoMes;
    }

    

    public Venda() {
    }

    public ArrayList<Double> getValorVendidoMes() {
        return valorVendidoMes;
    }

    public void setValorVendidoMes(ArrayList<Double> valorVendidoMes) {
        this.valorVendidoMes = valorVendidoMes;
    }
    
    

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public ArrayList<String> getMesAno() {
        return mesAno;
    }

    public void setMesAno(ArrayList<String> mesAno) {
        this.mesAno = mesAno;
    }
    
    
    
}
