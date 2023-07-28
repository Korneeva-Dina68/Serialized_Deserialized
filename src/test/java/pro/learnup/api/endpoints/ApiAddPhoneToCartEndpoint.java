package pro.learnup.api.endpoints;

import pro.learnup.api.dto.CartDto;
import pro.learnup.api.dto.PhoneDto;
import pro.learnup.api.dto.UserDto;

import static io.restassured.RestAssured.given;

@Endpoint("/api/cart")
public class ApiAddPhoneToCartEndpoint extends BaseEndpoint{
    public void addPhone (UserDto userDto, PhoneDto phoneDto) {
        given()
                .header(userDto.authHeader())
                .body(CartDto.builder()
                        .product(phoneDto.getId())
                        .quantity(1)
                        .user(userDto.getId())
                        .build())
                .post(getEndpoint())
                .then()
                .statusCode(200);
    }
}
