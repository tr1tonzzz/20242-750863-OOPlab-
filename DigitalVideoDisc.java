public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0; // Track total DVDs
    private int id;  // Unique ID for each DVD
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor with title, category, director, and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Constructor with title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor with title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Constructor with only title
    public DigitalVideoDisc(String title) {
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
        this.title = title;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
}
