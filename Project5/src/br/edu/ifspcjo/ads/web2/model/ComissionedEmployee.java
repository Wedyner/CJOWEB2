package br.edu.ifspcjo.ads.web2.model;

public class ComissionedEmployee extends Employee {

    protected double salesValue;
    protected double commissionPercentage;

    public ComissionedEmployee(String name, String cpf,
                               double salesValue, double commissionPercentage) {
        super(name, cpf);
        setSalesValue(salesValue);
        setCommissionPercentage(commissionPercentage);
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        if (salesValue < 0) {
            throw new IllegalArgumentException("O valor das vendas não pode ser negativo.");
        }
        this.salesValue = salesValue;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(double commissionPercentage) {
        if (commissionPercentage < 0 || commissionPercentage > 100) {
            throw new IllegalArgumentException(
                "O percentual de comissão deve estar entre 0 e 100.");
        }
        this.commissionPercentage = commissionPercentage;
    }

    @Override
    public double calculateIncome() {
        return salesValue * commissionPercentage / 100;
    }

    @Override
    public String toString() {
        return "ComissionedEmployee [" +
                "name=" + getName() +
                ", cpf=" + getCpf() +
                ", salesValue=" + salesValue +
                ", commissionPercentage=" + commissionPercentage +
                "]";
    }
}