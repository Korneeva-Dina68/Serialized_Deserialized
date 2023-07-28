package pro.learnup.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pro.learnup.api.dto.CartDto;
import pro.learnup.api.dto.PhoneDto;
import pro.learnup.api.dto.UserDto;
import pro.learnup.api.endpoints.ApiAddPhoneToCartEndpoint;
import pro.learnup.api.endpoints.ApiAuthRegisterEndpoint;
import pro.learnup.api.endpoints.ApiCatalogEndpoint;
import pro.learnup.api.ext.ApiTestExtension;

import static io.restassured.RestAssured.given;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/cart")
public class ApiAddPhoneToCartTest {

    UserDto userDto;
    PhoneDto phoneDto;

    @BeforeEach
    void setUp() {
        userDto = new ApiAuthRegisterEndpoint().registerNewUser(ApiAuthRegisterTest.successfulCreateUserRequests().findFirst().orElseThrow());
        phoneDto = new ApiCatalogEndpoint().getAllPhones().get(0);
    }

    @Test()
    @DisplayName("/api/cart: 200: добавление телефона в корзину")
    void addPhoneTest() {

        new ApiAddPhoneToCartEndpoint().addPhone(userDto, phoneDto);
    }
}
