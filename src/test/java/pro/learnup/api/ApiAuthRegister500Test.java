package pro.learnup.api;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pro.learnup.api.ext.ApiTestExtension;

import static io.restassured.RestAssured.given;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/auth/login")
public class ApiAuthRegister500Test {
    static Faker faker = new Faker();
    String userName = faker.name().fullName();
    String token;
    @Test()
    @DisplayName("/api/auth/register: 500: Error: Internal Server Error")
    void registerUserError() {
        given()
                .body("{\n" +
                        "  \"address\": \"russia\",\n" +
                        "  \"email\": \"sdgrdsg@vas.ru\",\n" +
                        "  \"phone\": \"8999999999\",\n" +
                        "  \"username\": \""+userName+"\"\n" +
                        "}")
                .post("/api/auth/register")
                .then()
                .statusCode(500);
    }

}
