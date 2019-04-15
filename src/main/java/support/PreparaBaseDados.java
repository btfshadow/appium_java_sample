package support;


import static com.jayway.restassured.RestAssured.given;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class PreparaBaseDados {

    private static String endPoint = "";
    private static String bearerToken = "bearer token";

    public static void setBearerToken(String ambiente) {
        if(ambiente.equals("hom")) {
            endPoint = "";
            bearerToken = "bearer ".concat(exemploGetToken());

        }if(ambiente.equals("dev")){
            endPoint = "http://mobile-viamais-concrete.ocp.dc.nova/";
            bearerToken = "bearer ".concat(exemploGetToken());
        }
    }


    public static String exemploGetToken(){

        String urlAutenticar = endPoint.concat("autenticacao/autenticar");

        JSONObject jsonObj = new JSONObject()
                .put("matricula","")
                .put("senha","")
                .put("codigoEmpresaFuncionario","")
                .put("codigoFilial","")
                .put("codigoBandeira","");

        String resposta = given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when()
                .post(urlAutenticar)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().body().print();

        JsonParser parser = new JsonParser();
        JsonObject obj = (JsonObject) parser.parse( resposta );

        String token = obj.get("access_token").getAsString();

        return token;
    }

    public static String ExemploGet(String cpfCliente, String codCliente, String nome, String tipoPessoa){
        setBearerToken("hom");
        JSONObject objetoAtendimento = new JSONObject()
                .put("codigo",codCliente)
                .put("documento",cpfCliente)
                .put("nomeCompleto",nome)
                .put("tipoPessoa",tipoPessoa);
        String resposta = given()
                .contentType("application/json")
                .header(HttpHeaders.AUTHORIZATION, bearerToken)
                .body(objetoAtendimento.toString())
                .when()
                .post(endPoint.concat("atendimentos/obter-atendimento"))
                .then()
                .statusCode(201)
                .extract().response().body().print();
        JsonParser pars = new JsonParser();
        JsonObject obj = (JsonObject) pars.parse(resposta);

        String codigo = obj.get("codigo").getAsString();

        return codigo;
    }
}
