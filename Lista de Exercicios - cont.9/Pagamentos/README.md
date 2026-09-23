## Getting Started

Projeto de fixação da disciplina **Desenvolvimento Web 2 (CJOWEB2)** —
Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas.

### Exercício — Conteúdo 09

Sistema que calcula taxas e processa pagamentos por **Pix**, **Cartão de Crédito**
e **Boleto Bancário** usando herança e polimorfismo.

## Folder Structure

- `src`: código-fonte
- `lib`: dependências
- `bin`: saída compilada

## Como executar

Abra a classe `GerenciadorVendas` (pacote `view`) e execute com o botão
**Run Java** do VS Code, ou via terminal:

```bash
javac -d bin $(find src -name "*.java")
java -cp bin br.edu.ifspcjo.ads.web2.pagamentos.view.GerenciadorVendas