package br.edu.ifspcjo.ads.web2.pagamentos.model;

public class PagamentoPix extends Pagamento
        implements Reembolsavel, ComprovanteGeravel {

    private String chavePix;
    private String statusReembolso = "Nenhum reembolso solicitado";

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

    @Override
    public boolean processarReembolso(double valorReembolso) {
        if (valorReembolso <= getValorBruto()) {
            statusReembolso = "Reembolso Pix de R$ "
                    + String.format("%.2f", valorReembolso)
                    + " efetuado com sucesso.";
            System.out.println(statusReembolso);
            return true;
        }
        statusReembolso = "Reembolso negado: valor solicitado superior ao valor bruto.";
        System.out.println(statusReembolso);
        return false;
    }

    @Override
    public String consultarStatusReembolso() {
        return statusReembolso;
    }

    @Override
    public String gerarComprovanteDigital() {
        return "[COMPROVANTE PIX] Transação: " + getCodigoTransacao()
                + " | Chave: " + chavePix
                + " | Valor Final: R$ " + String.format("%.2f", calcularValorFinal());
    }

}