import java.util.Arrays;
import java.util.List;

/**
 * @author Tatek Ahmed on 3/23/2022
 **/

public class Application {
    private static final String WORKER_ADDRESS_1 = "http://localhost:8080/task";
    private static final String WORKER_ADDRESS_2 = "http://localhost:8081/task";

    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator();

        String task1 = "10,200";
        String task2 = "123456789,10000000,200000000000000001231";

        List<String> results = aggregator.sendTaskToWorkers(
                Arrays.asList(WORKER_ADDRESS_1,WORKER_ADDRESS_2),Arrays.asList(task1,task2));

        for (String result: results) {
            System.out.println(result);
        }
    }
}
