package e3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")

public class NetworkMaps implements NetworkManager<String> {

    Map <String, List<String>> network = new HashMap<>();

    @Override
    public void addUser(String user, List<String> topicsOfInterest) {
        List<String> topics = new ArrayList<>(topicsOfInterest);
        network.putIfAbsent(user, topics);
    }

    @Override
    public void removeUser(String user) {
        network.remove(user);
    }

    @Override
    public void addInterest(String user, String topicOfInterest) {
        network.get(user).add(topicOfInterest);
    }

    @Override
    public void removeInterest(String user, String topicOfInterest) {
        network.get(user).remove(topicOfInterest);
    }

    @Override
    public List<String> getUsers() {
        return new ArrayList<>(network.keySet());
    }

    @Override
    public List<String> getInterests() {

        List<String> output = new ArrayList<>();

        for(List<String> list : network.values()) {
            for (int i = 0; i != list.size(); i++) {
                if (!output.contains(list.get(i)))
                    output.add(list.get(i));
            }
        }
        return output;
    }

    @Override
    public List<String> getInterestsUser(String user) {
        return network.get(user);
    }
}
