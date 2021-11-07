package e3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkTest {

    List<String> topicsOfInterest = new ArrayList<>();

    @Test
    void TestTables() {
        Network test = new Network(new NetworkTables());

        test.addUser("user1", topicsOfInterest);
        test.addUser("user2", topicsOfInterest);
        test.addUser("user3", topicsOfInterest);

        assertEquals(test.getInterests(), topicsOfInterest);


    }

    @Test
    void TestMaps() {

        Network test = new Network(new NetworkMaps());

    }
}
