package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyStepdefsToDo {
    private AppiumDriver driver;
    @Given("Abro la aplicacion Todo")
    public void tengoToDoListAbierto() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","JBMovile");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("hago click en el boton +")
    public void hagoClickEnElBotonAdd() {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
    }

    @And("lleno el formulario con una nueva tarea")
    public void llenoElFormularioDeNuevaTarea(Map<String,String> information) {
        for ( String control: information.keySet()
        ) {
            switch (control){
                case "title":
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(information.get(control));
                    break;
                case "notes":
                    driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(information.get(control));
                    break;
                default:
                    break;
            }
        }
    }

    @And("hago click en el check")
    public void hagoClickEnElBotonCheck() {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
    }

    @Then("la tarea {string} aparece creada en la lista")
    public void laTareaApareceríaCreada(String expectedResult) {
        String actualResult=driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();
        Assertions.assertEquals(expectedResult,actualResult, "ERROR contacto no creado");
    }
}
