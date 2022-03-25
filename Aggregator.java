import networking.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author Tatek Ahmed on 3/23/2022
 **/

public class Aggregator {
    private WebClient webClient;

    public Aggregator(){
        this.webClient = new WebClient();
    }

    public List<String> sendTaskToWorkers(List <String> workersAddresses, List<String> tasks){
        CompletableFuture<String>[] futures = new CompletableFuture[workersAddresses.size()];

        for (int i = 0; i < workersAddresses.size(); i++) {
            String workerAddress = workersAddresses.get(i);
            String task = tasks.get(i);

            byte[] requestPayload = task.getBytes();
            futures[i] = webClient.sendTask(workerAddress,requestPayload);
        }

        List<String> results = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            results.add(futures[i].join());
        }

        return results;
    }
}
