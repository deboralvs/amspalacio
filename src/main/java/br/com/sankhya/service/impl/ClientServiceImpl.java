package br.com.sankhya.service.impl;

import br.com.sankhya.entity.Client;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ClientServiceImpl {

    private String urlApi = "";

    @Value("${bearer.token}")
    private String bearer;

    public ResponseEntity registerClient(Client client){

        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JsonObject jsonClient = createJsonClient(client);
            System.out.println(jsonClient);
            HttpEntity<String> request = new HttpEntity<>(jsonClient.toString(), headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    urlApi,
                    HttpMethod.POST,
                    request,
                    String.class
            );
            if (response.getStatusCodeValue() != 201) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return response;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    private JsonObject createJsonClient(Client client){
        JsonObject jsonClient = new JsonObject();
        jsonClient.addProperty("TIPPESSOA", client.getTipPessoa());
        jsonClient.addProperty("NOMEPARC", client.getNomeParc());
        jsonClient.addProperty("CODCID", client.getCodCid());
        jsonClient.addProperty("ATIVO", client.getAtivo());
        jsonClient.addProperty("CLIENTE", client.getCliente());
        jsonClient.addProperty("CLASSIFICMS", client.getClassificMS());
        return jsonClient;
    }

    public ResponseEntity<String> getClient(){
        try{
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.exchange(
                    urlApi,
                    HttpMethod.GET,
                    null,
                    String.class
            );

            if (response.getStatusCodeValue() != 201) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return response;
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }


}
