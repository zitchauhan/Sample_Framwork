/*
 * package utilities;
 * 
 * import com.microsoft.aad.msal4j.*;
 * 
 * import java.net.URI; import java.util.Collections; import
 * java.util.concurrent.CompletableFuture;
 * 
 * public class MicrosoftAuthExample {
 * 
 * private static final String CLIENT_ID = "your_client_id"; private static
 * final String TENANT_ID = "your_tenant_id"; private static final String
 * CLIENT_SECRET = "your_client_secret"; private static final String AUTHORITY =
 * "https://login.microsoftonline.com/" + TENANT_ID;
 * 
 * public static void main(String[] args) { try { ConfidentialClientApplication
 * app = ConfidentialClientApplication.builder( CLIENT_ID,
 * ClientCredentialFactory.createFromSecret(CLIENT_SECRET))
 * .authority(AUTHORITY) .build();
 * 
 * ClientCredentialParameters parameters = ClientCredentialParameters.builder(
 * Collections.singleton("https://graph.microsoft.com/.default")) .build();
 * 
 * CompletableFuture<IAuthenticationResult> future =
 * app.acquireToken(parameters); IAuthenticationResult result = future.join();
 * System.out.println("Access Token: " + result.accessToken()); } catch
 * (Exception e) { e.printStackTrace(); } } }
 */