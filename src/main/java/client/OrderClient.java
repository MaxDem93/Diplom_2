package client;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import model.Order;

import static io.restassured.RestAssured.given;

public class OrderClient {
    private final String apiOrd = "/api/orders";

    @Step("Создание заказа")
    public ValidatableResponse createOrder(Order order) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(order)
                .when()
                .post(apiOrd).then();
    }

    @Step("Создание заказа с неправильными ингредиентами")
    public ValidatableResponse createWrongIngreds(Order order) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body("{\"ingredients\": \"rkjdvfhlrkjvhfbkb\"}")
                .when()
                .post(apiOrd)
                .then();
    }
}
