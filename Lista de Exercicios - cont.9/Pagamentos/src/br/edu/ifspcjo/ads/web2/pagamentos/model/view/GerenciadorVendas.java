package br.edu.ifspcjo.ads.web2.pagamentos.model.view;

import java.util.ArrayList;

import br.edu.ifspcjo.ads.web2.pagamentos.model.Pagamento;
import br.edu.ifspcjo.ads.web2.pagamentos.model.PagamentoBoleto;
import br.edu.ifspcjo.ads.web2.pagamentos.model.PagamentoCartao;
import br.edu.ifspcjo.ads.web2.pagamentos.model.PagamentoPix;

public class GerenciadorVendas {

    public static void main(String[] args) {

        ArrayList<Pagamento> pagamentos = new ArrayList<>();

        pagamentos.add(new PagamentoPix(
                250.00, "TXN-001", "juliana@email.com"));

        pagamentos.add(new PagamentoCartao(
                250.00, "TXN-002", "1234.5678.9012.3456", 3));

        pagamentos.add(new PagamentoBoleto(
                250.00, "TXN-003", "00190.00009 01234.567890 12345.678901 1 98760000025000", 7));

        for (Pagamento pagamento : pagamentos) {
            System.out.println("----------------------------------------");
            System.out.println("Código da transação: " + pagamento.getCodigoTransacao());
            pagamento.processarPagamento();
            System.out.printf("Valor bruto:   R$ %.2f%n", pagamento.getValorBruto());
            System.out.printf("Taxa:          R$ %.2f%n", pagamento.calcularTaxa());
            System.out.printf("Valor final:   R$ %.2f%n", pagamento.calcularValorFinal());
        }
        System.out.println("----------------------------------------");
    }

}