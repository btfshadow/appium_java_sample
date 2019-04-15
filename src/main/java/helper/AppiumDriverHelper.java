package helper;

import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumDriverHelper {


    private static AppiumDriver<MobileElement> appiumDriver;


    public static AppiumDriver<MobileElement> createDriver() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(DEVICE_NAME, "J7 Pro");
            cap.setCapability("automationName", "uiautomator2");
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
            cap.setCapability(MobileCapabilityType.VERSION, "7.0");
            cap.setCapability("platformName", "Android");
            cap.setCapability("app", new File("artifacts/app-ViaMais.apk"));
            cap.setCapability("unicodeKeyboard", true);
            cap.setCapability("resetKeyboard", true);
            cap.setCapability( "newCommandTimeout", 180 );
            appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        }catch (MalformedURLException e){
            System.out.println( e.getMessage() );

        }

        return appiumDriver;
    }


    public static void closeDriver(){
        appiumDriver.quit();

    }

    public static AppiumDriver<MobileElement> getDriver()  {
        if (appiumDriver == null){
                return createDriver();
            }
        return  appiumDriver;
    }

    public static void relaunchApp(){
        appiumDriver.launchApp();
    }


}
