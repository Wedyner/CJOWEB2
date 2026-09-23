package br.edu.ifspcjo.ads.web2.pagamentos.model;

public interface Reembolsavel {

    boolean processarReembolso(double valorReembolso);

    String consultarStatusReembolso();

}