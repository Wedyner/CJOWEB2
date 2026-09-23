## Getting Started

Projeto de fixação da disciplina **Desenvolvimento Web 2 (CJOWEB2)** —
Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas.

### Exercício — Conteúdo 10

Extensão do exercício do Conteúdo 09 aplicando **interfaces** para representar
comportamentos específicos que **nem todos** os pagamentos compartilham:

- `Reembolsavel` → estorno automático de valores (Pix e Cartão).
- `ComprovanteGeravel` → emissão de comprovante digital (Pix e Boleto).

## Folder Structure

- `src`: código-fonte
- `lib`: dependências
- `bin`: saída compilada

## Como executar

Abra `GerenciadorVendas` (pacote `view`) e clique em **Run Java**, ou via terminal:

```bash
javac -d bin $(find src -name "*.java")
java -cp bin br.edu.ifspcjo.ads.web2.pagamentos.view.GerenciadorVendas