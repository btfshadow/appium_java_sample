package stepDefinition;

import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import screen.BuscaScreen;
import screen.NavigationScreen;


public class BuscaSteps {

    BuscaScreen screen;
    NavigationScreen navScreen;



    @Quando("^realizar a busca por \"([^\"]*)\"$")
    public void realizar_a_busca_por(String codigo)  {
        screen = new BuscaScreen();
        screen.buscarProdutoPor( codigo );
        screen.tocarBtnPesquisa();
    }

    @Quando("^tocar em busca$")
    public void tocar_em_busca()  {
        navScreen = new NavigationScreen();
        navScreen.tocarBusca();
    }
    @Então("^devo ver a lista de resultado da busca$")
    public void devo_ver_a_lista_de_resultado_da_busca()  {
        screen.validarLista();
    }

}
