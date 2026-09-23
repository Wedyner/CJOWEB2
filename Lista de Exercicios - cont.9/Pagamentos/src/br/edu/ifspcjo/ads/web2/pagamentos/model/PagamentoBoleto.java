package br.edu.ifspcjo.ads.web2.pagamentos.model;

public class PagamentoBoleto extends Pagamento {

    private static final double TAXA_FIXA = 2.50;

    private String codigoBarras;
    private int diasParaVencimento;

    public PagamentoBoleto(double valorBruto, String codigoTransacao,
                           String codigoBarras, int diasParaVencimento) {
        super(valorBruto, codigoTransacao);
        this.codigoBarras = codigoBarras;
        this.diasParaVencimento = diasParaVencimento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getDiasParaVencimento() {
        return diasParaVencimento;
    }

    public void setDiasParaVencimento(int diasParaVencimento) {
        this.diasParaVencimento = diasParaVencimento;
    }

    @Override
    public double calcularTaxa() {
        return TAXA_FIXA;
    }

    @Override
    public boolean processarPagamento() {
        System.out.println("Boleto gerado com código " + codigoBarras
                + ". Vencimento em " + diasParaVencimento + " dias.");
        return true;
    }

}