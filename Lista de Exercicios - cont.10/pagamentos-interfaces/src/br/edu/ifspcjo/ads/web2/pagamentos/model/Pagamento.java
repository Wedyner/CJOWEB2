package br.edu.ifspcjo.ads.web2.pagamentos.model;

public abstract class Pagamento {

    private double valorBruto;
    private String codigoTransacao;

    public Pagamento(double valorBruto, String codigoTransacao) {
        this.valorBruto = valorBruto;
        this.codigoTransacao = codigoTransacao;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    public double calcularValorFinal() {
        return valorBruto + calcularTaxa();
    }

    public abstract double calcularTaxa();

    public abstract boolean processarPagamento();

}