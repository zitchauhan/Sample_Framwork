package stepDefinitions;


import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;

public class SampleSteps {

    private static int attempt = 0;

    @Then("I want to test retry logic")
    public void i_want_to_test_retry_logic() 
    {
        attempt++;
        System.out.println("Attempt: " + attempt);
        // Fail test on the first two attempts
        assertTrue(attempt >= 3, "Test failed on purpose for retry logic test");
    }
}
