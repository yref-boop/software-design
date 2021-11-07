package e3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")

public class NetworkTables implements NetworkManager<String> {

    String[] Network = new String[100];
    int last = 0;
    ArrayList<List<String>> Users = new ArrayList<>();

    @Override
    public void addUser(String user, List<String> topicsOfInterest) {
        Network[last] = user;
        last ++;
        List<String> topics = new ArrayList<>(topicsOfInterest);

        Users.add(topics);
    }

    @Override
    public void removeUser(String user) {
        int in = Arrays.asList(Network).indexOf(user);

        for (int i = 0; i < last+1; i++)
            if (i > in)  Network[i-1] = Network[i];

        Users.remove(in);
        last--;
    }

    @Override
    public void addInterest(String user, String topicOfInterest) {
        Users.get(Arrays.asList(Network).indexOf(user)).add(topicOfInterest);
    }

    @Override
    public void removeInterest(String user, String topicOfInterest) {
        Users.get(Arrays.asList(Network).indexOf(user)).remove(topicOfInterest);
    }

    @Override
    public List<String> getUsers() {
        return Arrays.asList(Network);
    }

    @Override
    public List<String> getInterests() {

        List<String> output = new ArrayList<>();

        for (int i = 0; i < last; i++){
            for (int j = 0; Users.get(i).size() != j; j++) {
                String get = Users.get(i).get(j);
                if (!output.contains(get))
                    output.add(get);
            }
        }
        return output;
    }

    @Override
    public List<String> getInterestsUser(String user) {
        return Users.get(Arrays.asList(Network).indexOf(user));
    }
}