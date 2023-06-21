import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;

public class CriarUsuarioTests {
    public static void testCriarUser() {

        HashMap<String, Object> jsonBody = new HashMap<String, Object>();
        jsonBody.put("nome", "teste teste");
        jsonBody.put("email", "teste@byorby.com");
        jsonBody.put("password", "teste@byorby.com");
        jsonBody.put("administrador", "true");
        Response response =
        given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
        .when()
                .post("https://serverest.dev/usuarios")
        .then()
                .statusCode(Integer.parseInt("201"))
                .extract().response();
                response.path("message", String.valueOf(equalTo("Cadastro realizado com sucesso")));
                String id_user = response.path("_id");
                System.out.println(id_user);
    }
    @Test
    public void testRodarCriarUsuario(){
        CriarUsuarioTests.testCriarUser();
    }
}
