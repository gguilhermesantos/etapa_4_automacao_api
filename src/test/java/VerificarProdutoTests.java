import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class VerificarProdutoTests {
    public static void testValidarProduto() {
        Response response =
                given()
                .when()
                        .get("https://serverest.dev/produtos/BeeJh5lz3k6kSIzA")// Utilizar _id criado
                .then()
                        .statusCode(Integer.parseInt("200"))
                        .extract().response();
                        response.path("name", String.valueOf(equalTo("Teste teste")));
                        response.path("preco", String.valueOf(equalTo("110")));
                        response.path("descricao", String.valueOf(equalTo("primeiro Teste")));
                        response.path("quantidade", String.valueOf(equalTo("55")));
                        System.out.println("Produto verificado!");
    }
    @Test
    public void testRodarVerificarProduto(){
        VerificarProdutoTests.testValidarProduto();
    }
}
