import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;

public class VerificarUsuarioTests {
    public static void testValidarUser() {
        Response response =
        given()
                .header("Accept","application/json")
        .when()
                .get("https://serverest.dev/usuarios/iTnL2flL2MmC6dLi")
        .then()
            .statusCode(Integer.parseInt("200"))
            .extract().response();
            response.path("name", String.valueOf(equalTo("teste teste")));
            response.path("email", String.valueOf(equalTo("teste@byorby.com")));
            response.path("password", String.valueOf(equalTo("teste@byorby.com")));
            response.path("administrador", String.valueOf(equalTo("true")));
            System.out.println("Usuario verificado!");
    }
    @Test
    public void testRodarVerificarUsuario(){
        VerificarUsuarioTests.testValidarUser();
    }

}
