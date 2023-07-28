package pro.learnup.api;

import com.github.javafaker.Faker;
import io.restassured.http.Header;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pro.learnup.api.dto.*;
import pro.learnup.api.endpoints.*;
import pro.learnup.api.ext.ApiTestExtension;

import static io.restassured.RestAssured.given;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/cart")
public class ApiDeletePhoneFromTheCartTest {
    PhoneDto phoneDto;
    UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new ApiAuthRegisterEndpoint().registerNewUser(ApiAuthRegisterTest.successfulCreateUserRequests().findFirst().orElseThrow());
        phoneDto = new ApiCatalogEndpoint().getAllPhones().get(0);
    }

    @Test()
    @DisplayName("/api/cart: 200: удаление телефона из корзины")
    void deletePhone() {

        new ApiAddPhoneToCartEndpoint().addPhone(userDto, phoneDto);

        new ApiGetPhonesInTheCartEndpoint().getPhones(userDto, phoneDto);

        new ApiDeletePhoneFromTheCartEndpoint().deletePhones(userDto, phoneDto);

    }
}