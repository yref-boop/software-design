package e3;

import java.util.*;

public class NetworkMaps implements NetworkManager<String> {

    Map <String, List<String>> Network = new LinkedHashMap<>(); //Map that stores users

    @Override
    public void addUser(String user, List<String> topicsOfInterest) { //adds user to the map if user doesn't exist
        if (Network.containsKey(user)) throw new IllegalArgumentException();

        List<String> topics = new ArrayList<>(topicsOfInterest);
        Network.put(user, topics);
    }

    @Override
    public void removeUser(String user) { //removes user from map if user exists
        if (!Network.containsKey(user)) throw new IllegalArgumentException();
        Network.remove(user);
    }

    @Override
    public void addInterest(String user, String topicOfInterest) {
        //adds a non-existent topic (in the topics list) to an existing user's topics of interest list
        if (!Network.containsKey(user)) throw new IllegalArgumentException();
        if (!Network.get(user).contains(topicOfInterest))
            Network.get(user).add(topicOfInterest);
    }

    @Override
    public void removeInterest(String user, String topicOfInterest) { //removes an existent topic from an existent user
        if (!Network.containsKey(user) || !Network.get(user).contains(topicOfInterest)) throw new IllegalArgumentException();
        Network.get(user).remove(topicOfInterest);
    }

    @Override
    public List<String> getUsers() { //gets the list of registered users
        return new ArrayList<>(Network.keySet());
    }

    @Override
    public List<String> getInterests() { //gets all the different topics of interest from the different users

        List<String> output = new ArrayList<>();

        for(List<String> list : Network.values()) {
            for (int i = 0; i != list.size(); i++) {
                if (!output.contains(list.get(i))) //only adds the topic to the output list if the topic isn't already in it
                    output.add(list.get(i));
            }
        }
        return output;
    }

    @Override
    public List<String> getInterestsUser(String user) { //gets all the topics of interest from an existent user
        if (!Network.containsKey(user)) throw new IllegalArgumentException();
        return Network.get(user);
    }
}
