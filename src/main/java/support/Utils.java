package support;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import helper.AppiumDriverHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Allure;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static File takeScreenshot(AppiumDriver driver) {
        try {
            return driver
                    .getScreenshotAs( OutputType.FILE );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void embedScreenshot(File file, String description) {
        Path content = Paths.get( file.getPath() );
        try (InputStream is = Files.newInputStream( content )) {
            Allure.addAttachment( description != null ? description : "", is );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Vendedores retornaVendedor(int indexVendedor) {

        JsonParser parser = new JsonParser();

        try {
            Object obj = parser.parse( new FileReader
                    ( "../vv-viamais-qa/login.json" ) );

            JsonObject jsonObject = (JsonObject) obj;

            JsonArray vendedores = jsonObject.getAsJsonArray( "vendedores" );

            List<Vendedores> vendedoresList = new ArrayList<>();

            for (int i = 0; i < vendedores.size(); i++) {
                Vendedores vendedor = new Vendedores();
                vendedor.setFilial( vendedores.get( i ).getAsJsonObject().get( "filial" ).getAsString() );
                vendedor.setEmpresaMatricula( vendedores.get( i ).getAsJsonObject().get( "empresaMatricula" ).getAsString() );
                vendedor.setSenha( vendedores.get( i ).getAsJsonObject().get( "senha" ).getAsString() );
                vendedoresList.add( vendedor );
            }

            return vendedoresList.get( indexVendedor );


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Clientes retornaClientes(String tipocliente) {
        JsonParser parser = new JsonParser();

        try {

            Object obj = parser.parse( new FileReader( "../vv-viamais-qa/clientes.json" ) );
            JsonObject jsonObject = (JsonObject) obj;
            JsonArray clientesJson = jsonObject.getAsJsonArray( "clientes" );
            Map<String, Object> clientes = new HashMap<String, Object>();

            for (JsonElement cliente : clientesJson) {
                Clientes objClientes = new Clientes();
                JsonElement nome = cliente.getAsJsonObject().get( "nomeCompleto" );
                if (nome != null)
                    objClientes.setNomeCompleto( nome.getAsString() );
                objClientes.setDataNascimento(cliente.getAsJsonObject().get("dataNascimento").getAsString());
                objClientes.setCelular(cliente.getAsJsonObject().get( "celular" ).getAsString() );
                objClientes.setEmail(cliente.getAsJsonObject().get( "email" ).getAsString() );
                objClientes.setCpf(cliente.getAsJsonObject().get( "cpf" ).getAsString() );
                objClientes.setDdd(cliente.getAsJsonObject().get( "ddd" ).getAsString() );
                objClientes.setCEP(cliente.getAsJsonObject().get( "cep" ).getAsString() );
                objClientes.setNumero(cliente.getAsJsonObject().get( "numero" ).getAsString() );
                objClientes.setTipoTelefone(cliente.getAsJsonObject().get( "tipoTelefone" ).getAsString() );
                clientes.put( cliente.getAsJsonObject().get( "tipo" ).getAsString(), objClientes );
            }
            return (Clientes) clientes.get( tipocliente );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    private static String calcDigVerif(String num) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt( num.substring( i, i + 1 ) ) * peso--;
        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = new Integer( 0 );
        else
            primDig = new Integer( 11 - (soma % 11) );
        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt( num.substring( i, i + 1 ) ) * peso--;
        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = new Integer( 0 );
        else
            segDig = new Integer( 11 - (soma % 11) );
        return primDig.toString() + segDig.toString();
    }

    public static String geraCPF() {
        String iniciais = "";
        Integer numero;

        for (int i = 0; i < 9; i++) {
            numero = new Integer( (int) (Math.random() * 10) );
            iniciais += numero.toString();
        }
        return iniciais + calcDigVerif( iniciais );
    }

}

