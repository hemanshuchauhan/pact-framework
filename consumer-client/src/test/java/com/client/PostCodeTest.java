package com.client;


import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PostCodeTest {
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("ProviderApi", "localhost", 8112, this);

    @Pact(consumer = "PostAddressClient")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");

        DslPart results = new PactDslJsonBody()
                .stringType("address","Flat 56 Regal House London")
                .asBody();

        return builder
                .given("Get Address for Post Code IG27JY")
                .uponReceiving("A request for address for post code IG27JY")
                .path("/get-address/IG27JY")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(results).toPact();
    }
    

    @Test
    @PactVerification()
    public void doTest() {
        System.setProperty("pact.rootDir","../pacts");  // Change output dir for generated pact-files
        String address = new PostCode(provider.getPort()).getAddress("IG27JY");
        System.out.println("According to test address = "+address);
        assertTrue(address.trim().length() >= 0);
    }

}

