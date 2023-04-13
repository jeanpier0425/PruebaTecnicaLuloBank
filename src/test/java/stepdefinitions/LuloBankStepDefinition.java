package stepdefinitions;

import co.com.lulobank.questions.*;
import co.com.lulobank.tasks.DeleteRequest;
import co.com.lulobank.tasks.GetRequest;
import co.com.lulobank.tasks.RequestManage;
import co.com.lulobank.tasks.WrongAppIdKey;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LuloBankStepDefinition {

    @When("^a request type get is executed$")
    public void whenTheServiceIsTypeGet() throws Exception {
        theActorInTheSpotlight().attemptsTo(GetRequest.service());
    }

    @When("^the service is type (.*) with request (.*)")
    public void TheServiceIsType(String typeServices, String request) throws Exception {
        theActorInTheSpotlight().attemptsTo(RequestManage.onServices(typeServices).withRequest(request));
    }

    @When("^the service is type delete$")
    public void whenTheServiceIsTypeDelete() throws Exception {
        theActorInTheSpotlight().attemptsTo(DeleteRequest.onEndPoint());
    }

    @When("^a wrong request (.*)$")
    public void aWrongRequestTypeGetIsExecuted(String typeErrorKey) throws Exception {
        theActorInTheSpotlight().attemptsTo(WrongAppIdKey.onEndPoint(typeErrorKey));
    }

    @Then("^status (.*)$")
    public void status(String statusCode) throws Exception {
        theActorInTheSpotlight().should(seeThat(ValidateTheStatus.code(), equalTo(statusCode)));
    }

    @Then("^validate (.*) and in the response$")
    public void validateFieldAndTheResponse(String field) throws Exception {
        theActorInTheSpotlight().should(seeThat(ValidateField.andTheResponse(field)));
    }

    @Then("^validate user$")
    public void validateUser(List<Map<String,String>> user) {
        theActorInTheSpotlight().should(seeThat(ValidateUser.with(user)));
    }

    @Then("^validate create response type (.*)$")
    public void validateCreateResponseType(String type) {
        theActorInTheSpotlight().should(seeThat(ValidateUserCreation.onService(type)));
    }

    @Then("^validate update response type (.*)$")
    public void validateUpdateResponse(String type) {
        theActorInTheSpotlight().should(seeThat(ValidateUpdateResponse.onService(type)));
    }

    @Then("^validate delete response with (.*)$")
    public void validateDeleteResponse(String id) {
        theActorInTheSpotlight().should(seeThat(ValidateDeleteResponse.onEndPoint(), equalTo(id)));
    }

    @Then("^validate error message with (.*)$")
    public void validateErrorMessage(String messageError) {
        theActorInTheSpotlight().should(seeThat(ValidateErrorMessage.onService(), equalTo(messageError)));
    }
}