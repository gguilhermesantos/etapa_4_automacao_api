import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AutenticarTests {
    public static String autenticandoUsuario() {
        HashMap<String, Object> jsonBody = new HashMap<String, Object>();
        jsonBody.put("email", "teste@byorby.com");
        jsonBody.put("password", "teste@byorby.com");
        Response response =
                given()
                        .baseUri("https://serverest.dev")
                        .basePath("/login")
                        .contentType(ContentType.JSON)
                        .body(jsonBody)
                .when()
                        .post()
                .then()
                        .statusCode(Integer.parseInt("200"))
                        .extract().response();
                        response.path("message", String.valueOf(equalTo("Login realizado com sucesso")));
                        String token = response.path("authorization");
        return token;
    }

    @Test
    public void testRodarAutenticacao(){
        String token = AutenticarTests.autenticandoUsuario();
        System.out.println(token);
    }
}
