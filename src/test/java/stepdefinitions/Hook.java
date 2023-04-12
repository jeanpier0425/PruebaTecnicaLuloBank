package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.lulobank.utils.constans.GeneralConstant.DEFAULT_USER;
import static co.com.lulobank.utils.constans.GeneralConstant.END_POINT;
import static co.com.lulobank.utils.properties.ServicesProperties.getProperties;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hook {

    @Before
    public static void inicializar(){
        setTheStage(new OnlineCast());
        theActorCalled(DEFAULT_USER);
    }

    @Given("^the endpoint is prepared with (.*)$")
    public void theEndPointIsPreparedWith(String path) throws Exception {
        theActorCalled(DEFAULT_USER).whoCan(CallAnApi.at(String.format(getProperties(END_POINT),path)));
    }

}
