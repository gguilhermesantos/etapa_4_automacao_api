import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class CriarProdutoTests {
    public static void testCriarProduto() {
        String token = AutenticarTests.autenticandoUsuario();
        HashMap<String, Object> jsonBody = new HashMap<String, Object>();
        jsonBody.put("nome", "Teste teste");
        jsonBody.put("preco", "110");
        jsonBody.put("descricao", "primeiro Teste");
        jsonBody.put("quantidade", "55");
        Response response =
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(jsonBody)
        .when()
                .post("https://serverest.dev/produtos")
        .then()
                .statusCode(Integer.parseInt("201"))
                .extract().response();
                response.path("message", String.valueOf(equalTo("Cadastro realizado com sucesso")));
                String id_produto = response.path("_id");
                System.out.println(id_produto);
    }
    @Test
    public void testRodarCriarProdutos(){
        CriarProdutoTests.testCriarProduto();
    }
}
