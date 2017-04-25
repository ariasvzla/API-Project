/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankface;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import entity.Customer;
import org.json.JSONObject;

/**
 *
 * @author Alzn-
 */
public class conection {
    
    
      public static Customer signIn(String email, String password) {
          
          
        String url = "http://localhost:8080/BankServer/api/customer/";
        Client client = Client.create();
        WebResource target = client.resource(url);
        ClientResponse response = target.queryParam("email", email)
                .queryParam("password", password)
                .accept("application/json")
                .get(ClientResponse.class);
        
        String entity = response.getEntity(String.class);
          switch (response.getStatus()) {
              case 200:
                  JSONObject json = new JSONObject(entity);
                  
                  Customer c = new Customer(
                          json.getInt("custid"), json.getString("firstname"),json.getString("lastname"),
                          json.getString("address"), json.getString("email"),
                          json.getString("password"));
                  
                  return c;
              case 204:
                  return null;
              default:
                  return null;
          }
    }

    /* POST REQUEST METHOD 
     */
    public static boolean sendPostRequest(Object object, String apiPath) {
        Client client = Client.create();
        WebResource target = client.resource(apiPath);

        String param = new JSONObject(object).toString();
        /*Check parameters */
        System.out.println( param);

        
         ClientResponse  response = target.accept("application/json;charset=utf-8")
                  .type("application/json;charset=utf-8")
                  .post(ClientResponse.class, param);

        if (response.getStatus() == 204) {
            return true;
        } else {
            return false;

        }
    }

    public static boolean sendPutRegister(Object object, String apiPath, Integer id) {
        Client client = Client.create();
        WebResource target = client.resource(apiPath + "/!" + id);

        String param;
          param = new JSONObject(object).toString();
        ClientResponse response = target.accept("application/json")
                .type("application/json")
                .put(ClientResponse.class, param);

        if (response.getStatus() == 204) {
            return true;

        } else {
            return false;

        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
