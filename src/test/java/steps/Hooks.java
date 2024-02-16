package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
     byte[] pic;
        if(scenario.isFailed()){
             pic=takeScreenshot("failed"+scenario.getName());
        }
        else {
            pic=takeScreenshot("passed"+scenario.getName());
        }
//the byte which is the screenshot
//        we mention media type
//        we mention the name of the scenario
scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }
}
