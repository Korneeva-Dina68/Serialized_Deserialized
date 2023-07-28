package pro.learnup.api;

import com.github.javafaker.Faker;
import io.restassured.http.Header;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pro.learnup.api.ext.ApiTestExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/user")
public class ApiChangeUserTest {
    static Faker faker = new Faker();
    String userName = faker.name().fullName();
    String token;
    String id;
    @BeforeEach
    void setUp() {
        token = given()
                .body("{\n" +
                        "  \"address\": \"russia\",\n" +
                        "  \"email\": \"sdgrdsg@vas.ru\",\n" +
                        "  \"password\": \""+userName+"\",\n" +
                        "  \"phone\": \"8999999999\",\n" +
                        "  \"username\": \""+userName+"\"\n" +
                        "}")
                .post("/api/auth/register")
                .then()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getString("token");

        id = given()
                .header(new Header("Authorization", "Bearer " + token))
                .get("/api/user")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("id");
    }

    @Test()
    @DisplayName("/api/user: 200: User updated")
    void changeUserTest(){
        given()
                .header(new Header("Authorization", "Bearer " + token))
                .body("{\n" +
                        "  \"address\": \"russia\",\n" +
                        "  \"email\": \"sdgrdsg@vas.ru\",\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"orders\": [],\n" +
                        "  \"password\": \""+userName+"\",\n" +
                        "  \"phone\": \"8999999999\",\n" +
                        "  \"token\": \""+token+"\",\n" +
                        "  \"username\": \""+userName+"\"\n" +
                        "}")
                .put("/api/user")
                .then()
                .statusCode(200)
                .body("message", equalTo("User updated"));
    }
}
