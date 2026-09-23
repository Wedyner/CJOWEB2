package br.edu.ifspcjo.ads.web2.model;

public class SalariedEmployee extends Employee {

    private double salary;

    public SalariedEmployee(String name, String cpf, double salary) {
        super(name, cpf);
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
        return salary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee [" +
                "name=" + getName() +
                ", cpf=" + getCpf() +
                ", salary=" + salary +
                "]";
    }
}