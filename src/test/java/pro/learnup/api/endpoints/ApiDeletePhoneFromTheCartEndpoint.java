package pro.learnup.api.endpoints;

import org.hamcrest.Matchers;
import pro.learnup.api.dto.DeleteDto;
import pro.learnup.api.dto.PhoneDto;
import pro.learnup.api.dto.UserDto;

import static io.restassured.RestAssured.given;

@Endpoint("/api/cart")
public class ApiDeletePhoneFromTheCartEndpoint extends BaseEndpoint{
    public void deletePhones (UserDto userDto, PhoneDto phoneDto) {

        String id = given()
                .header(userDto.authHeader())
                .get(getEndpoint())
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("_id");

        given()
                .header(userDto.authHeader())
                .body(DeleteDto.builder()
                        .cartId(id)
                        .itemId(phoneDto.getId())
                        .build())
                .put(getEndpoint())
                .then()
                .statusCode(200);
    }
}
