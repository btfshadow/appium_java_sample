package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import screen.NavigationScreen;

import static org.junit.Assert.assertTrue;

public class NavigationSteps {

    NavigationScreen screen;


    @Dado("^tocar no carrinho na navigation$")
    public void tocar_no_carrinho_na_navigation() {
        screen = new NavigationScreen();
        screen.tocarCarrinho();
    }

    @Quando("^tocar na área do cliente na navigation$")
    public void tocar_na_área_do_cliente_na_navigation() {
        screen = new NavigationScreen();
        screen.tocarCliente();
    }

    @Quando("^tocar na lupa na navigation$")
    public void tocar_na_lupa_na_navigation() {
        screen = new NavigationScreen();
        screen.tocarBusca();
    }


    @Então("^devo ver a tela do carrinho$")
    public void posso_ver_a_tela_do_carrinho(){
       assertTrue(screen.verTelaCarrinho());
    }

    @Então("^devo ver a tela de área do cliente$")
    public void posso_ver_a_tela_de_área_do_cliente(){
        assertTrue(screen.verTelaAreaCliente());
    }
}
