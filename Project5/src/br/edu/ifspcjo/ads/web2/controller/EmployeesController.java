package br.edu.ifspcjo.ads.web2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifspcjo.ads.web2.model.Employee;

public class EmployeesController {

    private List<Employee> employeesList;

    public EmployeesController() {
        this.employeesList = new ArrayList<>();
    }

    // ---------------------------------------------------------------
    // SALVAR
    // ---------------------------------------------------------------

    public boolean save(Employee employee) {
        // 1) não aceita null
        if (employee == null) {
            return false;
        }

        // 2) não aceita nome ou CPF vazios
        if (isBlank(employee.getName()) || isBlank(employee.getCpf())) {
            return false;
        }

        // 3) não aceita CPF duplicado
        if (search(employee.getCpf()) != null) {
            return false;
        }

        employeesList.add(employee);
        return true;
    }

    // ---------------------------------------------------------------
    // BUSCAR
    // ---------------------------------------------------------------

    /** Retorna o empregado com o CPF informado, ou null se não existir. */
    public Employee search(String cpf) {
        if (isBlank(cpf)) {
            return null;
        }

        for (Employee employee : employeesList) {
            if (employee.getCpf().equals(cpf)) {
                return employee;
            }
        }
        return null;
    }

    /** Verifica se já existe um empregado com o CPF informado. */
    public boolean exists(String cpf) {
        return search(cpf) != null;
    }

    // ---------------------------------------------------------------
    // ATUALIZAR
    // ---------------------------------------------------------------

    /**
     * Atualiza o nome de um empregado a partir do CPF.
     * Retorna true se conseguiu atualizar.
     */
    public boolean updateName(String cpf, String newName) {
        Employee employee = search(cpf);
        if (employee == null || isBlank(newName)) {
            return false;
        }
        employee.setName(newName);
        return true;
    }

    // ---------------------------------------------------------------
    // REMOVER
    // ---------------------------------------------------------------

    public boolean delete(String cpf) {
        Employee employee = search(cpf);
        if (employee == null) {
            return false;
        }
        return employeesList.remove(employee);
    }

    // ---------------------------------------------------------------
    // LISTAGEM / INFORMAÇÕES
    // ---------------------------------------------------------------

    /**
     * Retorna uma visão IMUTÁVEL da lista.
     * Isso impede que o código externo altere a lista interna do controller.
     */
    public List<Employee> getEmployeesList() {
        return Collections.unmodifiableList(employeesList);
    }

    public int size() {
        return employeesList.size();
    }

    public boolean isEmpty() {
        return employeesList.isEmpty();
    }

    /** Remove todos os empregados (útil para testes). */
    public void clear() {
        employeesList.clear();
    }

    // ---------------------------------------------------------------
    // AUXILIAR
    // ---------------------------------------------------------------

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}