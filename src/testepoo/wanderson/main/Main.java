package testepoo.wanderson.main;

import java.util.ArrayList;
import testepoo.wanderson.entities.Cargo;
import testepoo.wanderson.entities.Funcionario;
import testepoo.wanderson.entities.Venda;
import testepoo.wanderson.models.CargoModel;
import testepoo.wanderson.models.FuncionarioModel;
import testepoo.wanderson.models.VendaModel;

public class Main {

    public static void main(String[] args) {
        CargoModel cm = new CargoModel();
        FuncionarioModel fm = new FuncionarioModel();
        VendaModel vm = new VendaModel();

        Cargo sec = new Cargo("secretario", 7000, 20);
        Cargo vendedor = new Cargo("vendedor", 12000, 30);
        Cargo gerente = new Cargo("gerente", 20000, 0);

        cm.adicionar(sec);
        cm.adicionar(vendedor);
        cm.adicionar(gerente);

        Funcionario f1 = new Funcionario("Jorge Carvalho", sec, "01/2018");
        Funcionario f2 = new Funcionario("Maria Souza", sec, "12/2015");
        Funcionario f3 = new Funcionario("Ana Silva", vendedor, "12/2021");
        Funcionario f4 = new Funcionario("João Mendes", vendedor, "12/2021");
        Funcionario f5 = new Funcionario("Juliana Alves", gerente, "07/2017");
        Funcionario f6 = new Funcionario("Bento Albino", gerente, "03/2014");

        fm.adicionar(f1);
        fm.adicionar(f2);
        fm.adicionar(f3);
        fm.adicionar(f4);
        fm.adicionar(f5);
        fm.adicionar(f6);

        ArrayList<String> mesAno = new ArrayList();
        mesAno.add("12/2021");
        mesAno.add("01/2022");
        mesAno.add("02/2022");
        mesAno.add("03/2022");
        mesAno.add("04/2022");

        ArrayList<Double> valorVendidoMesVend1 = new ArrayList();
        valorVendidoMesVend1.add(5200.00);
        valorVendidoMesVend1.add(4000.00);
        valorVendidoMesVend1.add(4200.00);
        valorVendidoMesVend1.add(5850.00);
        valorVendidoMesVend1.add(7000.00);

        Venda v1 = new Venda(2, mesAno, valorVendidoMesVend1);

        ArrayList<Double> valorVendidoMesVend2 = new ArrayList();
        valorVendidoMesVend2.add(3400.00);
        valorVendidoMesVend2.add(7700.00);
        valorVendidoMesVend2.add(5000.00);
        valorVendidoMesVend2.add(5900.00);
        valorVendidoMesVend2.add(6500.00);

        Venda v2 = new Venda(3, mesAno, valorVendidoMesVend2);

        vm.adicionar(v1);
        vm.adicionar(v2);

        System.out.println("O valor total pago de salários e benefícios aos funcionários listados abaixo no mês de 04/2022:");
       

        System.out.println("=== Total: " + fm.getValorTotalPago(fm.getFuncionarios(), "04/2022"));

        System.out.println("O valor total pago apenas de salários aos funcionários no mês de 04/2022:");
        System.out.println("=== Total: " + fm.getValorPagoSalarios(fm.getFuncionarios(), "04/2022"));
        System.out.println("O valor total pago apenas em benefícios aos funcionários que possuem benefícios no mês de 04/2022: " + "\n === Total: " + fm.getValorPagoEmBeneficios(fm.getFuncionariosComBeneficios(), "04/2022"));
        System.out.println("O funcionário que recebeu maior valor no mês 04/2022 foi: " + fm.getFuncMaiorValor(fm.getFuncionarios(),"04/2022").getNome());
        System.out.println("O funcionário que recebeu maior benefício no mês 04/2022 foi: " + fm.getFuncionarioMaiorBeneficio(fm.getFuncionariosComBeneficios(), "04/2022").getNome());
        
        System.out.println("O vendedor que realizou mais vendas no mês de 04/2022 foi: " + fm.getFuncMaisVendas(fm.getFuncionarios(), "04/2022").getNome());
    }
    

}
