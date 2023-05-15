package testepoo.wanderson.models;

import java.util.ArrayList;
import testepoo.wanderson.entities.Cargo;

public class CargoModel {

    static ArrayList<Cargo> cargos;

    public CargoModel() {
        if (cargos == null) {
            cargos = new ArrayList<>();
        }
    }

    public double getSalarioByCargo(String cargo) {
        double salario = 0;
        for (int i = 0; i < cargos.size(); i++) {
            if (cargo.equals(cargos.get(i).getCargo())) {
                salario = cargos.get(i).getSalario();
            }
        }
        return salario;
    }
    public double getBeneficioByCargo(String cargo){
        double beneficio=0;
        for (int i = 0; i < cargos.size(); i++) {
            if(cargo.equals(cargos.get(i).getCargo())){
                beneficio = cargos.get(i).getBeneficio();
            }
        }
        return beneficio;
    }

    public double getSalarioBenByCargo(String cargo) {
        double salBen = 0;
        double salario, beneficio;
        for (int i = 0; i < cargos.size(); i++) {
            if (cargo.equals(cargos.get(i).getCargo())) {
                salario = cargos.get(i).getSalario();
                beneficio = cargos.get(i).getBeneficio();
                salBen = salario + (salario * beneficio);
            }
        }
        return salBen;
    }
    
    public void adicionar(Cargo cargo){
        cargos.add(cargo);
    }
}
