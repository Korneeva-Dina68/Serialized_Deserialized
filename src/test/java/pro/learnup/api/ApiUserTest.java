package pro.learnup.api;

import com.github.javafaker.Faker;
import io.restassured.http.Header;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pro.learnup.api.dto.UserDto;
import pro.learnup.api.endpoints.ApiAuthRegisterEndpoint;
import pro.learnup.api.endpoints.ApiUserEndpoint;
import pro.learnup.api.ext.ApiTestExtension;
import static org.assertj.core.api.Assertions.assertThat;

import static io.restassured.RestAssured.given;


@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/user")
public class ApiUserTest {

    UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new ApiAuthRegisterEndpoint().registerNewUser(ApiAuthRegisterTest.successfulCreateUserRequests().findFirst().orElseThrow());
    }

    @Test()
    @DisplayName("/api/user: 200: получение информации о юзере авторизованным пользователем")
    void successfulGetUserTest() {
        assertThat(new ApiUserEndpoint().getUser(userDto))
                .usingRecursiveComparison()
                .isEqualTo(userDto);
    }
}
