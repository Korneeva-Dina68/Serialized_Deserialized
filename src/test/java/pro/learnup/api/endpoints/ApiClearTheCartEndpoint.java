package pro.learnup.api.endpoints;

import pro.learnup.api.dto.DeleteDto;
import pro.learnup.api.dto.PhoneDto;
import pro.learnup.api.dto.UserDto;

import static io.restassured.RestAssured.given;

@Endpoint("/api/cart")
public class ApiClearTheCartEndpoint extends BaseEndpoint{
    public void clearPhones (UserDto userDto, PhoneDto phoneDto) {

        given()
                .header(userDto.authHeader())
                .delete("api/cart?id=" + phoneDto.getId())
                .then()
                .statusCode(200);
    }
}
