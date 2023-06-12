package client;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import model.Credentials;
import model.User;
import model.UserNewData;

import static io.restassured.RestAssured.given;

public class UserClient {
    private final String API_REGISTER = "/api/auth/register";
    private final String API_USER = "/api/auth/user";
    private final String API_LOGIN = "/api/auth/login";
    private String accessToken;

    @Step("Создание пользователя")
    public ValidatableResponse create(User user) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .when()
                .post(API_REGISTER)
                .then().log().all();
    }

    @Step("Залогиниться")
    public ValidatableResponse login(User user) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .when()
                .post(API_LOGIN)
                .then().log().all();
    }

    @Step("Залогиниться под существующим пользователем")
    public ValidatableResponse loginWithCreds(Credentials creds) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(creds)
                .when()
                .post(API_LOGIN)
                .then().log().all();
    }

    @Step("Обновляем данные")
    public ValidatableResponse updateData(UserNewData userNewData) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(userNewData)
                .when()
                .patch(API_USER)
                .then().log().all();
    }

    @Step("Создать пользователя, который уже зарегистрирован")
    public ValidatableResponse createWithCreds(Credentials creds) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(creds)
                .when()
                .post(API_LOGIN)
                .then().log().all();
    }

    public String createWithToken(User user) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .when()
                .post(API_REGISTER)
                .then().statusCode(200)
                .extract().path("accessToken");
    }


}
