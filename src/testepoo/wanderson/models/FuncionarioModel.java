package testepoo.wanderson.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import testepoo.wanderson.entities.Funcionario;

public class FuncionarioModel {

    static ArrayList<Funcionario> funcionarios;

    public FuncionarioModel() {
        if (funcionarios == null) {
            funcionarios = new ArrayList<>();
        }
    }

    public double getValorTotalPago(ArrayList<Funcionario> funcionarios, String mesAno) {
        double somaSalBen = 0, salario = 0, extraTempoServico;
        int periodoTrabalho;

        CargoModel cm = new CargoModel();
        DateModel dm = new DateModel();
        VendaModel vm = new VendaModel();

        for (int i = 0; i < funcionarios.size(); i++) {
            periodoTrabalho = dm.getPeriodoTrabalho(funcionarios.get(i).getDataAd());
            extraTempoServico = calcExtraTempoServico(periodoTrabalho, funcionarios.get(i).getCargo().getCargo());

            if (funcionarios.get(i).getCargo().getCargo().equals("vendedor")) {
                salario = cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico + vm.getComissaoVendedor(i, mesAno);
                somaSalBen += salario;
                System.out.println("funcionário:  " + funcionarios.get(i).getNome()
                        + "\n === cargo: " + funcionarios.get(i).getCargo().getCargo()
                        + "\n === salario base: " + funcionarios.get(i).getCargo().getSalario()
                        + "\n === comissao vendedor: " + vm.getComissaoVendedor(i, mesAno)
                        + "\n === tempo de serviço: " + periodoTrabalho + " anos"
                        + "\n === extra tempo de serviço: " + extraTempoServico
                        );
                System.out.println("salário total:  " + salario + "\n========================");
            } else {
                salario = cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico + ((cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico) * cm.getBeneficioByCargo(funcionarios.get(i).getCargo().getCargo()));
                somaSalBen += salario;
                System.out.println("funcionário:  " + funcionarios.get(i).getNome()
                        + "\n === cargo: " + funcionarios.get(i).getCargo().getCargo()
                        + "\n === salario base: " + funcionarios.get(i).getCargo().getSalario()
                        + "\n === beneficio sobre o salario + extra tempo de serviço: " + funcionarios.get(i).getCargo().getBeneficio() + "%"
                        + "\n === tempo de serviço: " + periodoTrabalho + " anos"
                        + "\n === extra tempo de serviço: " + extraTempoServico
                        );
                System.out.println("salário total:  " + salario + "\n========================");

            }

        }
        return somaSalBen;
    }

    public double getValorPagoSalarios(ArrayList<Funcionario> funcionarios, String mesAno) {
        int periodoTrabalho;
        double extraTempoServico, salario = 0, totalSalarios = 0;
        CargoModel cm = new CargoModel();
        DateModel dm = new DateModel();
        VendaModel vm = new VendaModel();
        for (int i = 0; i < funcionarios.size(); i++) {
            periodoTrabalho = dm.getPeriodoTrabalho(funcionarios.get(i).getDataAd());
            extraTempoServico = calcExtraTempoServico(periodoTrabalho, funcionarios.get(i).getCargo().getCargo());
            salario = cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico;
            totalSalarios += salario;
        }
        return totalSalarios;
    }

    public double calcExtraTempoServico(int periodoTrabalho, String cargo) {
        double extraTempoServico = 0;
        switch (cargo.toLowerCase()) {

            case "secretario":
                extraTempoServico = 1000 * periodoTrabalho;
                break;
            case "vendedor":
                extraTempoServico = 1800 * periodoTrabalho;
                break;
            case "gerente":
                extraTempoServico = 3000 * periodoTrabalho;
        }

        return extraTempoServico;
    }

    public Funcionario getVendedorById(int id) {
        Funcionario func = null;
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(id).getCargo().getCargo().equals("vendedor")) {
                func = funcionarios.get(id);
            }

        }
        return func;
    }

    public void adicionar(Funcionario func) {
        funcionarios.add(func);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Funcionario> getFuncionariosComBeneficios() {
        ArrayList<Funcionario> funcs = new ArrayList();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCargo().getBeneficio() != 0) {
                funcs.add(funcionarios.get(i));
            }

        }
        return funcs;
    }

    public double getValorPagoEmBeneficios(ArrayList<Funcionario> funcionarios, String mesAno) {
        CargoModel cm = new CargoModel();
        DateModel dm = new DateModel();
        VendaModel vm = new VendaModel();

        double beneficios = 0, benVend, benOutro;
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCargo().getCargo().equals("vendedor")) {
                benVend = vm.getComissaoVendedor(i, mesAno);
                beneficios += benVend;
            } else {
                benOutro = cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) * funcionarios.get(i).getCargo().getBeneficio();
                beneficios += benOutro;
            }
        }
        return beneficios;
    }

    public Funcionario getFuncMaiorValor(ArrayList<Funcionario> funcionarios, String mesAno) {
        double maiorSal = 0, extraTempoServico;
        int periodoTrabalho;
        Funcionario func = null;

        CargoModel cm = new CargoModel();
        DateModel dm = new DateModel();
        VendaModel vm = new VendaModel();

        double salario = 0;
        for (int i = 0; i < funcionarios.size(); i++) {

            periodoTrabalho = dm.getPeriodoTrabalho(funcionarios.get(i).getDataAd());
            extraTempoServico = calcExtraTempoServico(periodoTrabalho, funcionarios.get(i).getCargo().getCargo());

            if (funcionarios.get(i).getCargo().getCargo().equals("vendedor")) {
                salario = cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico + vm.getComissaoVendedor(i, mesAno);

                if (salario > maiorSal) {

                    maiorSal = salario;
                    func = funcionarios.get(i);
                }

            } else {
                salario = cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico + ((cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico) * cm.getBeneficioByCargo(funcionarios.get(i).getCargo().getCargo()));
                if (salario > maiorSal) {
                    maiorSal = salario;
                    func = funcionarios.get(i);
                }
            }
        }
        return func;

    }
    public Funcionario getFuncionarioMaiorBeneficio(ArrayList<Funcionario> funcionarios, String mesAno){
        Funcionario func = null;

        CargoModel cm = new CargoModel();
        DateModel dm = new DateModel();
        VendaModel vm = new VendaModel();
        
        int periodoTrabalho;
        double extraTempoServico;

        double salario = 0, beneficio, maiorBen=0;
        for (int i = 0; i < funcionarios.size(); i++) {
            
            periodoTrabalho = dm.getPeriodoTrabalho(funcionarios.get(i).getDataAd());
            extraTempoServico = calcExtraTempoServico(periodoTrabalho, funcionarios.get(i).getCargo().getCargo());

            if (funcionarios.get(i).getCargo().getCargo().equals("vendedor")) {
                beneficio = cm.getBeneficioByCargo(funcionarios.get(i).getCargo().getCargo()) * vm.getComissaoVendedor(i, mesAno);

                if (beneficio > maiorBen) {

                    maiorBen = beneficio;
                    func = funcionarios.get(i);
                }

            } else {
                beneficio = cm.getBeneficioByCargo(funcionarios.get(i).getCargo().getCargo()) *  ((cm.getSalarioByCargo(funcionarios.get(i).getCargo().getCargo()) + extraTempoServico ));
                if (beneficio > maiorBen) {
                    maiorBen = beneficio;
                    func = funcionarios.get(i);
                }
            }
        }
        return func;
    }
    public ArrayList<Funcionario> getVendedores(ArrayList<Funcionario> funcionarios){
        ArrayList<Funcionario> vendedores = new ArrayList();
        for (int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getCargo().getCargo().equals("vendedor")){
                vendedores.add(funcionarios.get(i));
            }
        }
        return vendedores;
        
    }
    public Funcionario getFuncMaisVendas(ArrayList<Funcionario> funcionarios, String mesAno){
        Funcionario func = null;
        VendaModel vm = new VendaModel();
        double maiorComissao=0, comissao;
        for (int i = 0; i < funcionarios.size(); i++) {
            comissao = vm.getComissaoVendedor(i, mesAno);
            if(comissao > maiorComissao){
                maiorComissao = comissao;
                func = funcionarios.get(i);
            }
        }
        return func;
    }
        
}
