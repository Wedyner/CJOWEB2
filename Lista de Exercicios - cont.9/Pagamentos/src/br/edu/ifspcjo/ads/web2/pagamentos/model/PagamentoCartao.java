package br.edu.ifspcjo.ads.web2.pagamentos.model;

public class PagamentoCartao extends Pagamento {

    private static final double TAXA_PERCENTUAL = 0.035;

    private String numeroCartao;
    private int qtdParcelas;

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

}