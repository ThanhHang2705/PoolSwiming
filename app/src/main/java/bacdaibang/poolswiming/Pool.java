package bacdaibang.poolswiming;

/**
 * Created by VietBac on 12/4/2016.
 */
public class Pool {
    private int id;
    private String name;
    private String location;
    private int cost;
    private float rating;
    String image;

    public Pool(int id,String name,String location, String image, int cost, float rating){
        this.id = id;
        this.name = name;
        this.location = location;
        this.image = image;
        this.cost = cost;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
