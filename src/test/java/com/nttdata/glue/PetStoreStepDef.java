package com.nttdata.glue;

import com.nttdata.steps.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDef {

    @Steps
    PetStoreStep petStep;

    @Given("la url {string}")
    public void laUrl(String url) {
        petStep.defirnirUrl(url);
    }

    @When("consulto la orden con id {string}")
    public void consultoLaOrdenConId(String idOrden) {
        petStep.consultarOrden(idOrden);
    }

    @When("creo la orden con id {string}, petId {string}, quantity {string}, shipdate {string}, status {string}, complete {string}")
    public void creoLaOrdenConIdPetIdQuantityShipdateStatusComplete(String id, String petId, String quantity, String shipdate, String status, String complete) {
        petStep.crearOrden(id, petId, quantity, shipdate, status, complete);
    }


    @Then("valido que el codigo de respuesta sea {string}")
    public void validoQueElCodigoDeRespuestaSea(String codigo) {
        petStep.validarCodigo(Integer.parseInt(codigo));
    }

    @And("valido que la orden tenga el id {string}")
    public void validoQueLaOrdenTengaElId(String id) {
        petStep.validarId(Integer.parseInt(id));
    }

    @And("valido que la orden tenga el petId {string}")
    public void validoQueLaOrdenTengaElPetId(String petId) {
        petStep.validarPetId(Integer.parseInt(petId));
    }

    @And("valido que la orden tenga la cantidad {string}")
    public void validoQueLaOrdenTengaLaCantidad(String quantity) {
        petStep.validarQuantity(Integer.parseInt(quantity));
    }

    @And("valido que la orden tenga el status {string}")
    public void validoQueLaOrdenTengaElStatus(String status) {
        petStep.validarStatus(status);
    }

    @And("valido que la orden tenga complete {string}")
    public void validoQueLaOrdenTengaComplete(String complete) {
        petStep.validarComplete(complete.equals("true"));
    }
}
