package e3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NetworkTables implements NetworkManager<String> {

    String[] Network = new String[100]; //1D array that stores the names of the registered users
    int last = 0; //index of the last added element of the Network list
    ArrayList<List<String>> Users = new ArrayList<>(); //stores the lists of topics of interest of all the users

    @Override
    public void addUser(String user, List<String> topicsOfInterest) { //adds user to the list if user doesn't exist
        for (String n : Network) if (Objects.equals(n, user)) throw new IllegalArgumentException();

        Network[last] = user; //adds the name to the list of usernames
        last ++;
        List<String> topics = new ArrayList<>(topicsOfInterest);

        Users.add(topics); //adds the given topics of interest list to the new user
    }

    @Override
    public void removeUser(String user) { //removes user from list if user exists
        int in = Arrays.asList(Network).indexOf(user);
        if (in == -1) throw new IllegalArgumentException();

        for (int i = 0; i < last+1; i++)
            if (i > in)  Network[i-1] = Network[i];

        Users.remove(in);
        last--;
    }

    @Override
    public void addInterest(String user, String topicOfInterest) {
        //adds a non-existent topic (in the topics list) to an existing user's topics of interest list
        int in = Arrays.asList(Network).indexOf(user);

        if (in == -1) throw new IllegalArgumentException();

        if (!Users.get(in).contains(topicOfInterest))
            Users.get(in).add(topicOfInterest); //only adds the topic if it wasn't in the list before
    }

    @Override
    public void removeInterest(String user, String topicOfInterest) { //removes an existent topic from an existent user
        int in = Arrays.asList(Network).indexOf(user);
        if (in == -1 || !Users.get(in).remove(topicOfInterest))
            throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() { //gets the list of registered users
        List<String> output = new ArrayList<>(Arrays.asList(Network));

        List<String> NULL = new ArrayList<>();
        NULL.add(null);
        output.removeAll(NULL); //removes all null values (all values entries that are not registered users)

        return output;
    }

    @Override
    public List<String> getInterests() { //gets all the different topics of interest from the different users

        List<String> output = new ArrayList<>();

        for (int i = 0; i < last; i++) {
            for (int j = 0; Users.get(i).size() != j; j++) {
                String get = Users.get(i).get(j);
                if (!output.contains(get)) //only adds the topic to the output list if the topic isn't already in it
                    output.add(get);
            }
        }
        return output;
    }

    @Override
    public List<String> getInterestsUser(String user) { //gets all the topics of interest from an existent user
        int in = Arrays.asList(Network).indexOf(user);
        if (in == -1) throw new IllegalArgumentException();

        return Users.get(in);
    }
}