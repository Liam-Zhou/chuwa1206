package Multi_Threading.Q3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FetchDataFromAPIs {

    private static final Logger logger = Logger.getLogger(FetchDataFromAPIs.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> postsFuture = fetchDataFromApi("posts");
        CompletableFuture<String> commentsFuture = fetchDataFromApi("comments");
        CompletableFuture<String> usersFuture = fetchDataFromApi("users");

        // Combine the results when all futures are completed
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(postsFuture, commentsFuture, usersFuture);

        // Handle exceptions and log information
        combinedFuture.exceptionally(ex -> {
            logger.log(Level.SEVERE, "An exception occurred during API calls", ex);
            return null; // Return a default value or handle as needed
        });

        // Wait for all futures to complete and merge the data
        combinedFuture.thenRun(() -> {
            try {
                String postsData = postsFuture.get();
                String commentsData = commentsFuture.get();
                String usersData = usersFuture.get();

                // Merge the data for further processing
                String mergedData = mergeData(postsData, commentsData, usersData);

                // Perform further processing with mergedData
                System.out.println("Merged Data: " + mergedData);

            } catch (InterruptedException | ExecutionException e) {
                logger.log(Level.SEVERE, "An exception occurred while processing the merged data", e);
            }
        });

        // Ensure the program waits for completion of the futures
        combinedFuture.join();
    }

    private static CompletableFuture<String> fetchDataFromApi(String api) {
        // Simulate fetching data from the API
        return CompletableFuture.supplyAsync(() -> {
            try {
                String apiUrl = "https://jsonplaceholder.typicode.com/" + api;
                return HttpClientMock.get(apiUrl);

            } catch (Exception e) {
                // Log exception and return a default value
                logger.log(Level.SEVERE, "An exception occurred during API call for " + api, e);
                return "Default Data for " + api;
            }
        });
    }

    private static String mergeData(String postsData, String commentsData, String usersData) {
        // Simulate merging data
        return "Merged Data: \n" +
                "Posts: " + postsData + "\n" +
                "Comments: " + commentsData + "\n" +
                "Users: " + usersData;
    }

    // Mock HttpClient class for simulating API calls
    static class HttpClientMock {
        static String get(String url) throws Exception {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
    }
}

