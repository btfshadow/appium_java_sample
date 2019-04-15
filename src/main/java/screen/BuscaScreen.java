package screen;

import helper.AppiumDriverHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;


public class BuscaScreen extends BaseScreen{


    @WithTimeout( time = 6,unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "editTextSearchQuery")
    public MobileElement campoPesquisa;
    @WithTimeout( time = 6,unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "buttonSearch")
    public MobileElement btnPesquisa;


     public void buscarProdutoPor(String codigo) {
            campoPesquisa.clear();
            campoPesquisa.sendKeys( codigo );
        }

     public void tocarBtnPesquisa() {
            btnPesquisa.click();
        }

     public void validarLista(){
         AppiumDriverHelper.getDriver().findElements( By.id("textViewProductPrice"));

        }

    }


