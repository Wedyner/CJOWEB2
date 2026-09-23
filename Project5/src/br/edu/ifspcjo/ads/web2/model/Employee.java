package br.edu.ifspcjo.ads.web2.model;

import java.util.Objects;

public abstract class Employee {

    protected String name;
    protected String cpf;

    public Employee(String name, String cpf) {
        setName(name);
        setCpf(cpf);
    }

    // ---------------------------------------------------------------
    // GETTERS / SETTERS
    // ---------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.name = name.trim();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio.");
        }
        // Remove pontos e traços, mantém apenas dígitos
        String digits = cpf.replaceAll("\\D", "");
        if (digits.length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos.");
        }
        this.cpf = digits;
    }

    // ---------------------------------------------------------------
    // MÉTODO ABSTRATO
    // ---------------------------------------------------------------

    /** Calcula o rendimento (salário/comissão/horas) do empregado. */
    public abstract double calculateIncome();

    // ---------------------------------------------------------------
    // EQUALS / HASHCODE (baseado no CPF)
    // ---------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee other = (Employee) o;
        return Objects.equals(cpf, other.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    // ---------------------------------------------------------------
    // TOSTRING
    // ---------------------------------------------------------------

    @Override
    public String toString() {
        return "Employee [name=" + getName() + ", cpf=" + getCpf() + "]";
    }
}