package br.edu.ifspcjo.ads.web2.view;

import javax.swing.JOptionPane;

import br.edu.ifspcjo.ads.web2.controller.EmployeesController;
import br.edu.ifspcjo.ads.web2.model.ComissionedAndSalariedEmployee;
import br.edu.ifspcjo.ads.web2.model.ComissionedEmployee;
import br.edu.ifspcjo.ads.web2.model.Employee;
import br.edu.ifspcjo.ads.web2.model.HourlyEmployee;
import br.edu.ifspcjo.ads.web2.model.SalariedEmployee;

public class App {

    private static final EmployeesController employeesController = new EmployeesController();

    // ===============================================================
    // MENUS
    // ===============================================================

    private static int menu() {
        String input = JOptionPane.showInputDialog(null,
                "Escolha uma opção:" +
                        "\n1- Cadastrar um empregado" +
                        "\n2- Gerar Folha de Pagamento" +
                        "\n3- Sair");

        if (input == null) {
            return 3; // cancelar = sair
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
            return -1;
        }
    }

    private static int submenu() {
        String input = JOptionPane.showInputDialog(null,
                "Escolha um tipo de empregado:" +
                        "\n1- Empregado Assalariado" +
                        "\n2- Empregado Horista" +
                        "\n3- Empregado Comissionado" +
                        "\n4- Empregado Comissionado e Assalariado" +
                        "\n5- Voltar");

        if (input == null) {
            return 5; // cancelar = voltar
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
            return -1;
        }
    }

    // ===============================================================
    // MAIN
    // ===============================================================

    public static void main(String[] args) {
        int option;

        do {
            option = menu();

            switch (option) {
                case 1:
                    registerEmployee();
                    break;

                case 2:
                    generatePayroll();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                    break;

                default:
                    if (option != 3) {
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!");
                    }
                    break;
            }

        } while (option != 3);
    }

    // ===============================================================
    // SUBMENU DE CADASTRO
    // ===============================================================

    private static void registerEmployee() {
        int employeeType;

        do {
            employeeType = submenu();

            switch (employeeType) {
                case 1:
                    addSalariedEmployee();
                    break;

                case 2:
                    addHourlyEmployee();
                    break;

                case 3:
                    addComissionedEmployee();
                    break;

                case 4:
                    addComissionedAndSalariedEmployee();
                    break;

                case 5:
                    // voltar ao menu principal
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Tipo de empregado inválido. Tente novamente.");
                    break;
            }

        } while (employeeType != 5);
    }

    // ===============================================================
    // FOLHA DE PAGAMENTO
    // ===============================================================

    private static void generatePayroll() {
        if (employeesController.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum empregado cadastrado.");
            return;
        }

        StringBuilder message = new StringBuilder();
        double totalPayroll = 0;

        for (Employee employee : employeesController.getEmployeesList()) {
            double income = employee.calculateIncome();
            totalPayroll += income;

            message.append(employee)
                    .append("\nRendimentos: R$ ")
                    .append(String.format("%.2f", income))
                    .append("\n-------------------------------------------\n");
        }

        message.append("TOTAL DA FOLHA: R$ ")
                .append(String.format("%.2f", totalPayroll));

        JOptionPane.showMessageDialog(null, message.toString());
    }

    // ===============================================================
    // CADASTROS INDIVIDUAIS
    // ===============================================================

    private static void addSalariedEmployee() {
        String name = readString("Informe o nome:");
        if (name == null) return;

        String cpf = readCpf();
        if (cpf == null) return;

        Double salary = readDouble("Informe o salário:");
        if (salary == null) return;

        try {
            Employee employee = new SalariedEmployee(name, cpf, salary);
            saveEmployee(employee, "Empregado assalariado");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    private static void addHourlyEmployee() {
        String name = readString("Informe o nome:");
        if (name == null) return;

        String cpf = readCpf();
        if (cpf == null) return;

        Integer hours = readInt("Informe o número de horas trabalhadas:");
        if (hours == null) return;

        Double valueHour = readDouble("Informe o valor da hora trabalhada:");
        if (valueHour == null) return;

        try {
            Employee employee = new HourlyEmployee(name, cpf, hours, valueHour);
            saveEmployee(employee, "Empregado horista");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    private static void addComissionedEmployee() {
        String name = readString("Informe o nome:");
        if (name == null) return;

        String cpf = readCpf();
        if (cpf == null) return;

        Double salesValue = readDouble("Informe o valor das vendas:");
        if (salesValue == null) return;

        Double percentage = readDouble("Informe o percentual de comissão (%):");
        if (percentage == null) return;

        try {
            Employee employee = new ComissionedEmployee(name, cpf, salesValue, percentage);
            saveEmployee(employee, "Empregado comissionado");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    private static void addComissionedAndSalariedEmployee() {
        String name = readString("Informe o nome:");
        if (name == null) return;

        String cpf = readCpf();
        if (cpf == null) return;

        Double salesValue = readDouble("Informe o valor das vendas:");
        if (salesValue == null) return;

        Double percentage = readDouble("Informe o percentual de comissão (%):");
        if (percentage == null) return;

        Double salary = readDouble("Informe o salário fixo:");
        if (salary == null) return;

        try {
            Employee employee = new ComissionedAndSalariedEmployee(name, cpf, salesValue, percentage, salary);
            saveEmployee(employee, "Empregado comissionado e assalariado");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    // ===============================================================
    // MÉTODOS AUXILIARES — PERSISTÊNCIA
    // ===============================================================

    /**
     * Tenta salvar um empregado no controller.
     * Exibe mensagem de sucesso ou erro.
     */
    private static void saveEmployee(Employee employee, String tipoDescricao) {
        if (employeesController.save(employee)) {
            JOptionPane.showMessageDialog(null,
                    tipoDescricao + " cadastrado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao cadastrar. Verifique se o CPF já não está cadastrado.");
        }
    }

    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, "Erro: " + message);
    }

    // ===============================================================
    // MÉTODOS AUXILIARES — LEITURA
    // ===============================================================

    /** Lê uma String não vazia. Retorna null se cancelar ou ficar vazio. */
    private static String readString(String message) {
        String input = JOptionPane.showInputDialog(message);

        if (input == null) return null;

        if (input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo não pode ficar vazio!");
            return null;
        }

        return input.trim();
    }

    /**
     * Lê um CPF e verifica duplicidade no controller.
     * Retorna null se cancelar, ficar vazio ou já existir.
     */
    private static String readCpf() {
        String cpf = readString("Informe o CPF:");
        if (cpf == null) return null;

        if (employeesController.exists(cpf)) {
            JOptionPane.showMessageDialog(null,
                    "Já existe um empregado cadastrado com esse CPF!");
            return null;
        }

        return cpf;
    }

    /** Lê um double não negativo. Retorna null se cancelar ou for inválido. */
    private static Double readDouble(String message) {
        String input = JOptionPane.showInputDialog(message);
        if (input == null) return null;

        try {
            double value = Double.parseDouble(input.trim().replace(",", "."));

            if (value < 0) {
                JOptionPane.showMessageDialog(null, "O valor não pode ser negativo!");
                return null;
            }

            return value;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido! Digite apenas números.");
            return null;
        }
    }

    /** Lê um int não negativo. Retorna null se cancelar ou for inválido. */
    private static Integer readInt(String message) {
        String input = JOptionPane.showInputDialog(message);
        if (input == null) return null;

        try {
            int value = Integer.parseInt(input.trim());

            if (value < 0) {
                JOptionPane.showMessageDialog(null, "O valor não pode ser negativo!");
                return null;
            }

            return value;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido! Digite apenas números inteiros.");
            return null;
        }
    }
}