package screen;

import helper.AppiumDriverHelper;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseScreen {

    public BaseScreen(){
        PageFactory.initElements( new AppiumFieldDecorator(AppiumDriverHelper.getDriver(),15, TimeUnit.SECONDS ), this );
    }

    public static void swipe( int pressX,int pressY,int moveX,int moveY){
        new TouchAction(AppiumDriverHelper.getDriver()).press(pressX,pressY).waitAction().moveTo(moveX,moveY).release().perform();

    }
    public void  esperaExplicita(By by,int time){
        WebDriverWait wait = new WebDriverWait(AppiumDriverHelper.getDriver(), time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void swipePorTexto(String texto){

        boolean isPresent = AppiumDriverHelper.getDriver().findElements(By.xpath("//*[@text=\"" + texto + "\"]")).size() > 0;
        while(!isPresent){
            AppiumDriverHelper.getDriver().swipe(89,1521,54,236, 0);
            isPresent = AppiumDriverHelper.getDriver().findElements(By.xpath("//*[@text=\"" + texto + "\"]")).size() > 0;
        }

    }
    public void esperarSerClicavel(By by,int time){
        WebDriverWait wait = new WebDriverWait(AppiumDriverHelper.getDriver(), time);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }
}
