package br.edu.ifspcjo.ads.web2.pagamentos.model.view;

import java.util.ArrayList;

import br.edu.ifspcjo.ads.web2.pagamentos.model.ComprovanteGeravel;
import br.edu.ifspcjo.ads.web2.pagamentos.model.Pagamento;
import br.edu.ifspcjo.ads.web2.pagamentos.model.PagamentoBoleto;
import br.edu.ifspcjo.ads.web2.pagamentos.model.PagamentoCartao;
import br.edu.ifspcjo.ads.web2.pagamentos.model.PagamentoPix;
import br.edu.ifspcjo.ads.web2.pagamentos.model.Reembolsavel;

public class GerenciadorVendas {

    public static void main(String[] args) {

        ArrayList<Pagamento> listaPagamentos = new ArrayList<>();

        listaPagamentos.add(new PagamentoPix(
                250.00, "TXN-001", "juliana@email.com"));

        listaPagamentos.add(new PagamentoCartao(
                250.00, "TXN-002", "1234.5678.9012.3456", 3));

        listaPagamentos.add(new PagamentoBoleto(
                250.00, "TXN-003",
                "00190.00009 01234.567890 12345.678901 1 98760000025000", 7));

        System.out.println("========== PROCESSAMENTO DOS PAGAMENTOS ==========");
        for (Pagamento pagamento : listaPagamentos) {
            System.out.println("----------------------------------------");
            System.out.println("Código da transação: " + pagamento.getCodigoTransacao());
            pagamento.processarPagamento();
            System.out.printf("Valor bruto:   R$ %.2f%n", pagamento.getValorBruto());
            System.out.printf("Taxa:          R$ %.2f%n", pagamento.calcularTaxa());
            System.out.printf("Valor final:   R$ %.2f%n", pagamento.calcularValorFinal());
        }

        System.out.println();
        System.out.println("========== COMPORTAMENTOS ADICIONAIS (instanceof) ==========");
        for (Pagamento p : listaPagamentos) {
            System.out.println("----------------------------------------");
            System.out.println("Transação: " + p.getCodigoTransacao());

            if (p instanceof ComprovanteGeravel) {
                ComprovanteGeravel gerador = (ComprovanteGeravel) p;
                System.out.println(gerador.gerarComprovanteDigital());
            }

            if (p instanceof Reembolsavel) {
                Reembolsavel reembolsavel = (Reembolsavel) p;
                reembolsavel.processarReembolso(p.getValorBruto());
                System.out.println("Status reembolso: " + reembolsavel.consultarStatusReembolso());
            }
        }
        System.out.println("----------------------------------------");
    }

}