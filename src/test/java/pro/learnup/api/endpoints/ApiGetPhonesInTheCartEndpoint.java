package pro.learnup.api.endpoints;

import org.hamcrest.Matchers;
import pro.learnup.api.dto.CartDto;
import pro.learnup.api.dto.PhoneDto;
import pro.learnup.api.dto.UserDto;

import static io.restassured.RestAssured.given;

@Endpoint("/api/cart")
public class ApiGetPhonesInTheCartEndpoint extends BaseEndpoint{
    public void getPhones (UserDto userDto, PhoneDto phoneDto) {
        given()
                .header(userDto.authHeader())
                .get(getEndpoint())
                .then()
                .statusCode(200)
                .body("items.product.info.name", Matchers.hasItem("Apple iPhone 8 Plus"));
    }
}
