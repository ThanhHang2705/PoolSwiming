package bacdaibang.poolswiming;

/**
 * Created by VietBac on 12/4/2016.
 */
public class Pool {
    int id;
    String name;
    String location;
    int cost;
    float rating;
    String image;

    public Pool(int id,String name,String location, String image, int cost, float rating){
        this.id = id;
        this.name = name;
        this.location = location;
        this.image = image;
        this.cost = cost;
        this.rating = rating;
    }

}
