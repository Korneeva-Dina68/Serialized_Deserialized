package pro.learnup.api;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pro.learnup.api.dto.UserDto;
import pro.learnup.api.endpoints.ApiAuthRegisterEndpoint;
import pro.learnup.api.ext.ApiTestExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/auth/register")
public class ApiAuthRegisterTest {
    static Faker faker = new Faker();
    public static Stream<UserDto> successfulCreateUserRequests() {

        return Stream.of(UserDto.builder()
                        .username(faker.name().fullName())
                        .password(faker.internet().password())
                        .build(),
                UserDto.builder()
                        .address(faker.address().fullAddress())
                        .phone(faker.phoneNumber().phoneNumber())
                        .email(faker.internet().emailAddress())
                        .username(faker.name().fullName())
                        .password(faker.internet().password())
                        .build());
    }

    @ParameterizedTest()
    @DisplayName("/api/auth/register: 201: успешное создание юзера")
    @MethodSource("successfulCreateUserRequests")
    void createUserTest(UserDto userDto){

        UserDto actualUser = new ApiAuthRegisterEndpoint().registerNewUser(userDto);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualUser)
                .as("Созданный юзер должен быть равен ожидаемому")
                .usingRecursiveComparison()
                .ignoringFields("id", "orders", "password", "token")
                .isEqualTo(userDto);

        softAssertions.assertThat(actualUser.getId()).isNotEmpty();
        softAssertions.assertThat(actualUser.getPassword()).isNotEmpty();
        softAssertions.assertThat(actualUser.getToken()).isNotEmpty();
        softAssertions.assertThat(actualUser.getOrders()).isEmpty();
        softAssertions.assertAll();
    }
}
