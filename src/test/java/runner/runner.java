package runner;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class runner {
    //Hooks
    @Before
    public void hookSetup ()
    {
        System.out.println("Antes del scenario");
    }

    @After
    public void  hookCleanup()
    {
        System.out.println("Después del scenario");
    }
}
