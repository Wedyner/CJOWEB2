package br.edu.ifspcjo.ads.web2.pagamentos.model;

public class PagamentoCartao extends Pagamento implements Reembolsavel {

    private static final double TAXA_PERCENTUAL = 0.035;

    private String numeroCartao;
    private int qtdParcelas;
    private String statusReembolso = "Nenhum reembolso solicitado";

    public PagamentoCartao(double valorBruto, String codigoTransacao,
                           String numeroCartao, int qtdParcelas) {
        super(valorBruto, codigoTransacao);
        this.numeroCartao = numeroCartao;
        this.qtdParcelas = qtdParcelas;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    @Override
    public double calcularTaxa() {
        return getValorBruto() * TAXA_PERCENTUAL;
    }

    @Override
    public boolean processarPagamento() {
        System.out.println("Pagamento em " + qtdParcelas + "x no cartão "
                + numeroCartao + " autorizado com sucesso!");
        return true;
    }

    @Override
    public boolean processarReembolso(double valorReembolso) {
        statusReembolso = "Estorno de R$ " + String.format("%.2f", valorReembolso)
                + " solicitado junto à operadora do cartão " + numeroCartao + ".";
        System.out.println(statusReembolso);
        return true;
    }

    @Override
    public String consultarStatusReembolso() {
        return statusReembolso;
    }

}