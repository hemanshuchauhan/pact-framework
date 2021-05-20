package com.runner;


import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("ProviderApi") // Set up name of tested provider
@PactFolder("../pacts") // Point where to find pacts (See also section Pacts source in documentation)

public class PostCodeContractTest {


    @State("Get Address for Post Code IG27JY") // Method will be run before testing interactions that require "with-data" state
    public void IG27JY() {
        System.out.println("A request for address for post code IG27JY" );
    }

    
    @State("Get Address for Post Code IG27MN") // Method will be run before testing interactions that require "with-data" state
    public void IG27MN() {
        System.out.println("A request for address for post code IG27MN" );
    }
    
    @State("Get Address for Post Code IG27XX") // Method will be run before testing interactions that require "with-data" state
    public void IG27XX() {
        System.out.println("A request for address for post code IG27XX" );
    }


    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target1 = new HttpTarget(8111); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)


}
