package e3;
import java.util.List;

public class Network {

    NetworkManager<String> NetworkType; //choice of the implementation
    public Network(NetworkManager<String> manager) { NetworkType = manager; } //constructor that decides the implementation

    //construction of functions
    public void addUser(String user, List<String> topicsOfInterest) { NetworkType.addUser(user, topicsOfInterest); }
    public void removeUser(String user) { NetworkType.removeUser(user); }
    public void addInterest(String user, String topicOfInterest) { NetworkType.addInterest(user, topicOfInterest); }
    public void removeInterest(String user, String topicOfInterest) { NetworkType.removeInterest(user, topicOfInterest); }
    public List<String> getUsers() { return NetworkType.getUsers(); }
    public List<String> getInterests() { return NetworkType.getInterests(); }
    public List<String> getInterestsUser(String user) { return NetworkType.getInterestsUser(user); }
}
