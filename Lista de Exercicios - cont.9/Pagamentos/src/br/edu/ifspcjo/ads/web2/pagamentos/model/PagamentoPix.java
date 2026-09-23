package br.edu.ifspcjo.ads.web2.pagamentos.model;

public class PagamentoPix extends Pagamento {

    private String chavePix;

    public PagamentoPix(double valorBruto, String codigoTransacao, String chavePix) {
        super(valorBruto, codigoTransacao);
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public double calcularTaxa() {
        return 0.0;
    }

    @Override
    public boolean processarPagamento() {
        System.out.println("Pagamento Pix processado instantaneamente para a chave: " + chavePix);
        return true;
    }

}