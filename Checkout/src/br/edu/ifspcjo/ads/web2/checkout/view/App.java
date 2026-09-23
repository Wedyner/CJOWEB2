package br.edu.ifspcjo.ads.web2.checkout.view;

import br.edu.ifspcjo.ads.web2.checkout.model.Buy;
import br.edu.ifspcjo.ads.web2.checkout.model.Card;
import br.edu.ifspcjo.ads.web2.checkout.model.Checkout;
import br.edu.ifspcjo.ads.web2.checkout.model.CieloOperator;
import br.edu.ifspcjo.ads.web2.checkout.model.EpsonPrinter;
import br.edu.ifspcjo.ads.web2.checkout.model.Operator;
import br.edu.ifspcjo.ads.web2.checkout.model.Printer;
import br.edu.ifspcjo.ads.web2.checkout.model.RedecardOperator;
import br.edu.ifspcjo.ads.web2.checkout.model.XinglingPrinter;

public class App {
    public static void main(String[] args) throws Exception {
        Operator operator = new RedecardOperator();
        Printer printer = new XinglingPrinter();
        Card card = new Card("JULIANA SILVA",
             "5678.1234");
        Buy buy = new Buy("Juliana Silva", 
            40, "Hamburger Especial");
        Checkout checkout = new Checkout(printer, operator);
        checkout.closeBuy(buy, card);
    }
}
