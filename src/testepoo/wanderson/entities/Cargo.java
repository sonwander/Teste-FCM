
package testepoo.wanderson.entities;

public class Cargo {
    private String cargo;
    private double salario;
    private double beneficio;

    public Cargo(String cargo, double salario, double beneficio) {
        this.cargo = cargo;
        this.salario = salario;
        this.beneficio = beneficio/100;
    }

    public Cargo() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio/100;
    }
    
    
}
