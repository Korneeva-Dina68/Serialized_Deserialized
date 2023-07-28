package pro.learnup.api.endpoints;

import pro.learnup.api.dto.UserDto;

import static io.restassured.RestAssured.given;

@Endpoint("/api/auth/register")
public class ApiAuthRegisterEndpoint extends BaseEndpoint{
    public UserDto registerNewUser(UserDto userDto) {
        return given()
                .body(userDto)
                .post(getEndpoint())
                .then()
                .statusCode(201)
                .extract()
                .as(UserDto.class);
    }
}
