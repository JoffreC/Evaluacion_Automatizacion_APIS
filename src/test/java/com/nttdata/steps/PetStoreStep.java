package com.nttdata.steps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreStep {
    private Response response;
    private String URL_BASE;
    private ValidatableResponse validatable;

    public void defirnirUrl(String url){
        URL_BASE = url;
    }

    public void consultarOrden(String orden){
        response = given()
                .baseUri(URL_BASE)
                .get("/" + orden)
                .then()
                .log().all()
                .extract().response();

        validatable = response.then();
        validatable.log().all();
    }
    public void crearOrden(String id, String petId, String quantity, String shipDate, String status, String complete) {
        response = SerenityRest.given()
                .contentType("application/json")
                .baseUri(URL_BASE)
                .body(
                        "{\n" +
                                "  \"id\": \"" + id + "\",\n" +
                                "  \"petId\": \"" + petId + "\",\n" +
                                "  \"quantity\": \"" + quantity + "\",\n" +
                                "  \"shipDate\": \"" + shipDate + "\",\n" +
                                "  \"status\": \"" + status + "\",\n" +
                                "  \"complete\": \"" + complete + "\"\n" +
                                "}"
                )
                .log().all()
                .post();
        validatable = response.then();
        validatable.log().all();
    }

    public void validarCodigo(int codigo){
        validatable.statusCode(codigo);
    }

    public void validarId(int id){
        validatable.body("id", equalTo(id));
    }

    public void validarPetId(int petId){
        validatable.body("petId", equalTo(petId));
    }

    public void validarQuantity(int quantity){
        validatable.body("quantity", equalTo(quantity));
    }

    public void validarStatus(String status){
        validatable.body("status", equalTo(status));
    }

    public void validarComplete(boolean complete){
        validatable.body("complete", equalTo(complete));
    }
}
