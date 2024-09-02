package com.helidonapps.firstservice;

import io.helidon.config.Config;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class SimpleService implements HttpService {

    // @Override
    // public void routing(HttpRules rules) {
    // rules.get("/welcome", (req, res) -> {
    // res.send("welcome to helidon");
    // });
    // }
    private String greetingMessage;

    SimpleService() {
        Config.global().get("app");
        greetingMessage = Config.global()
                .get("app")
                .get("greeting")
                .asString()
                .orElse(
                        "welcome to helidon SE");
    }

    SimpleService(Config config) {
        greetingMessage = config
                .get("app")
                .get("greeting")
                .asString()
                .orElse(
                        "welcome to helidon SE");
    }

    @Override
    public void routing(HttpRules rules) {
        rules.get("/welcome", this::getResponse);
    }

    private void getResponse(ServerRequest req, ServerResponse res) {
        res.send(greetingMessage);
    }
}
