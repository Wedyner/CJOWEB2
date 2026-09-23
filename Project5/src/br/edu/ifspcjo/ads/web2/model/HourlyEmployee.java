package br.edu.ifspcjo.ads.web2.model;

public class HourlyEmployee extends Employee {

    private int numberOfHoursWorked;
    private double valueOfHoursWorked;

    public HourlyEmployee(String name, String cpf,
                          int numberOfHoursWorked, double valueOfHoursWorked) {
        super(name, cpf);
        setNumberOfHoursWorked(numberOfHoursWorked);
        setValueOfHoursWorked(valueOfHoursWorked);
    }

    public int getNumberOfHoursWorked() {
        return numberOfHoursWorked;
    }

    public void setNumberOfHoursWorked(int numberOfHoursWorked) {
        if (numberOfHoursWorked < 0) {
            throw new IllegalArgumentException("O número de horas não pode ser negativo.");
        }
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    public double getValueOfHoursWorked() {
        return valueOfHoursWorked;
    }

    public void setValueOfHoursWorked(double valueOfHoursWorked) {
        if (valueOfHoursWorked < 0) {
            throw new IllegalArgumentException("O valor da hora não pode ser negativo.");
        }
        this.valueOfHoursWorked = valueOfHoursWorked;
    }

    @Override
    public double calculateIncome() {
        return numberOfHoursWorked * valueOfHoursWorked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee [" +
                "name=" + getName() +
                ", cpf=" + getCpf() +
                ", numberOfHoursWorked=" + numberOfHoursWorked +
                ", valueOfHoursWorked=" + valueOfHoursWorked +
                "]";
    }
}