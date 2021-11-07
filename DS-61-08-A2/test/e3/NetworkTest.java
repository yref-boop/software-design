package e3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NetworkTest {

    List<String> topicsOfInterest = new ArrayList<>();

    @Test
    void TestTables() {

        Network test = new Network(new NetworkTables());

        test.addUser("user1", topicsOfInterest);
        assertThrows(IllegalArgumentException.class, () -> test.addUser("user1", topicsOfInterest));
        test.addUser("user2", topicsOfInterest);
        test.addUser("user3", topicsOfInterest);

        assertEquals("[]", test.getInterests().toString());

        test.addInterest("user1", "interest2");
        test.addInterest("user1", "interest1");

        assertEquals("[interest2, interest1]", test.getInterestsUser("user1").toString());
        assertEquals("[user1, user2, user3]", test.getUsers().toString());

        test.addInterest("user2", "interest1");
        test.addInterest("user2", "interest1");
        test.addInterest("user2", "interest2");

        assertEquals("[interest1, interest2]", test.getInterestsUser("user2").toString());

        test.removeInterest("user2", "interest1");
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user2", "interest1"));
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user3", "interest1"));
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user4", "interest1"));

        test.removeUser("user2");
        test.removeUser("user3");
        assertThrows(IllegalArgumentException.class, () -> test.removeUser("user4"));

        assertEquals("[user1]", test.getUsers().toString());
        assertEquals("[interest2, interest1]", test.getInterests().toString());

        test.addUser("user100", topicsOfInterest);
        test.addUser("user101", topicsOfInterest);
        test.addUser("user102", topicsOfInterest);

        test.addInterest("user100", "interest1");
        test.addInterest("user101", "interest1");
        test.addInterest("user101", "interest3");
        test.addInterest("user101", "interest4");
        test.addInterest("user102", "interest4");
        test.addInterest("user102", "interest5");
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user103", "interest1"));

        assertEquals("[interest2, interest1, interest3, interest4, interest5]", test.getInterests().toString());
        assertEquals("[interest1, interest3, interest4]", test.getInterestsUser("user101").toString());
    }

    @Test
    void TestMaps() {

        Network test = new Network(new NetworkMaps());

        test.addUser("user1", topicsOfInterest);
        assertThrows(IllegalArgumentException.class, () -> test.addUser("user1", topicsOfInterest));
        test.addUser("user2", topicsOfInterest);
        test.addUser("user3", topicsOfInterest);

        assertEquals("[]", test.getInterests().toString());

        test.addInterest("user1", "interest2");
        test.addInterest("user1", "interest1");

        assertEquals("[interest2, interest1]", test.getInterestsUser("user1").toString());
        assertEquals("[user1, user2, user3]", test.getUsers().toString());

        test.addInterest("user2", "interest1");
        test.addInterest("user2", "interest1");
        test.addInterest("user2", "interest2");

        assertEquals("[interest1, interest2]", test.getInterestsUser("user2").toString());

        test.removeInterest("user2", "interest1");
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user2", "interest1"));
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user3", "interest1"));
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user4", "interest1"));

        test.removeUser("user2");
        test.removeUser("user3");
        assertThrows(IllegalArgumentException.class, () -> test.removeUser("user4"));

        assertEquals("[user1]", test.getUsers().toString());
        assertEquals("[interest2, interest1]", test.getInterests().toString());

        test.addUser("user100", topicsOfInterest);
        test.addUser("user101", topicsOfInterest);
        test.addUser("user102", topicsOfInterest);

        test.addInterest("user100", "interest1");
        test.addInterest("user101", "interest1");
        test.addInterest("user101", "interest3");
        test.addInterest("user101", "interest4");
        test.addInterest("user102", "interest4");
        test.addInterest("user102", "interest5");
        assertThrows(IllegalArgumentException.class, () -> test.removeInterest("user103", "interest1"));

        assertEquals("[interest2, interest1, interest3, interest4, interest5]", test.getInterests().toString());
        assertEquals("[interest1, interest3, interest4]", test.getInterestsUser("user101").toString());
    }
}
