package model;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.is;

public class Assertions {
    public String successIsTrue200(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(200)
                .and().body("success", is(true))
                .extract().path("accessToken");
    }

    public String successIsFalse403(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(403)
                .and().body("success", is(false))
                .extract().path("accessToken");
    }

    public String successIsFalse401(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(401)
                .and().body("success", is(false))
                .extract().path("accessToken");
    }

    public String successIsFalse400(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(400)
                .and().body("success", is(false))
                .extract().path("accessToken");
    }

    public ValidatableResponse status500(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(500);
    }
}
