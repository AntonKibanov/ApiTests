package tests.api.petstore.pet;

import api.models.pet.AddPetModel;
import api.models.pet.Category;
import api.models.pet.TagsItem;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@DisplayName("Проверка метода добавления питомца /pet")
public class AddPetTests {

    @Test
    @DisplayName("Cтатус код метода /pet равен 200")
    public void checkThatResponseCodeIs200() {
        AddPetModel pet = AddPetModel.builder()
            .id(1)
            .category(
                Category.builder()
                    .id(1)
                    .name("dogs")
                    .build()
            )
            .name("Iroh")
            .tags(List.of(
                TagsItem.builder()
                    .id(1)
                    .name("dogs")
                    .build())
            )
            .status("available")
            .build();

        Response response = given()
            .contentType("application/json")
            .body(pet)
            .post("https://petstore.swagger.io/v2/pet")
            .then()
            .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("Id питомца в ответе не равен null")
    public void checkThatIdDoesNotEqualNullInResponseBody() {
        AddPetModel pet = AddPetModel.builder()
            .id(2)
            .category(
                Category.builder()
                    .id(1)
                    .name("dogs")
                    .build()
            )
            .name("Scooby")
            .tags(List.of(
                TagsItem.builder()
                    .id(1)
                    .name("dogs")
                    .build())
            )
            .status("available")
            .build();

        Response response = given()
            .contentType("application/json")
            .body(pet)
            .post("https://petstore.swagger.io/v2/pet")
            .then()
            .extract().response();

        Assertions.assertNotNull(response.body().path("id"));
    }
}
