package pro.learnup.api.endpoints;

import pro.learnup.api.dto.PhoneDto;

import java.util.List;

import static io.restassured.RestAssured.given;

@Endpoint("/api/catalog")
public class ApiCatalogEndpoint extends BaseEndpoint{
    public List<PhoneDto> getAllPhones() {
        return List.of(given()
                .get(getEndpoint())
                .then()
                .statusCode(200)
                .extract()
                .as(PhoneDto[].class));
    }
}
