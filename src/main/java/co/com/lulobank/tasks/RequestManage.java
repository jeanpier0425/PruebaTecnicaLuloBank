package co.com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;

public class RequestManage implements Task {

    private String methodType;
    private String request;

    public RequestManage(String methodType) {
        this.methodType = methodType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(methodType.equalsIgnoreCase("POST"))
                        .andIfSo(PostRequest.onTheEndPoint(request))
                        .otherwise(PutRequest.onEndPoint(request))
        );
    }

    public static RequestManage onServices(String methodType){
        return Tasks.instrumented(RequestManage.class,methodType);
    }

    public RequestManage withRequest(String request){
        this.request = request;
        return this;
    }
}
