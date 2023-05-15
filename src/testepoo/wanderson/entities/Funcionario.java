
package testepoo.wanderson.entities;

public class Funcionario {
    private String nome;
    private Cargo cargo;
    private String dataAd;

    public Funcionario(String nome, Cargo cargo, String dataAd) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataAd = dataAd;
    }

    public Funcionario() {
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getDataAd() {
        return dataAd;
    }

    public void setDataAd(String dataAd) {
        this.dataAd = dataAd;
    }
    
    
}
