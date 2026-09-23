package br.edu.ifspcjo.ads.web2.model;

public class ComissionedAndSalariedEmployee extends ComissionedEmployee {

    private double salary;

    public ComissionedAndSalariedEmployee(String name, String cpf,
                                          double salesValue, double comissionPercentage,
                                          double salary) {
        super(name, cpf, salesValue, comissionPercentage);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo.");
        }
        this.salary = salary;
    }

    @Override
    public double calculateIncome() {
        // Comissão (do pai) + salário fixo
        return super.calculateIncome() + salary;
    }

    @Override
    public String toString() {
        return "ComissionedAndSalariedEmployee [" +
                "name=" + getName() +
                ", cpf=" + getCpf() +
                ", salesValue=" + getSalesValue() +
                ", comissionPercentage=" + getComissionPercentage() +
                ", salary=" + salary +
                "]";
    }
}