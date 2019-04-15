package screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

import java.util.concurrent.TimeUnit;

public class NavigationScreen extends BaseScreen {


    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy( id = "itemMainNavSearch")
    public MobileElement tabbarBusca;

    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy( id = "itemMainNavCart")
    public MobileElement tabbarCarrinho;

    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    @AndroidFindBy( id = "itemMainNavCustomer")
    public MobileElement tabbarCliente;

    @WithTimeout(time = 5,unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "viewFlipperCart")
    public MobileElement telaCarrinho;

    @WithTimeout(time = 5,unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "textViewCustomerAreaTitle")
    public MobileElement telaAreaCliente;

    public void tocarBusca(){
        tabbarBusca.click();

    }

    public void tocarCarrinho(){
        tabbarCarrinho.click();
    }

    public void tocarCliente(){
        tabbarCliente.click();
    }

    public boolean verTelaCarrinho(){
        telaCarrinho.isDisplayed();
        return true;
    }

    public boolean verTelaAreaCliente(){
        telaAreaCliente.isDisplayed();
        return true;
    }
}

//cardViewCustomer
