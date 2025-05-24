package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    // Equals method: compare by title and cost
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;

        // Null checks
        if (this.title == null || other.title == null) {
            return false;
        }

        return this.title.equals(other.title) && this.cost == other.cost;
    }

    // CompareTo method: compare by title, then cost
    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Compared media is null");

        int titleComparison = 0;
        if (this.title != null && other.title != null) {
            titleComparison = this.title.compareTo(other.title);
        } else if (this.title == null) {
            return -1;
        } else {
            return 1;
        }

        if (titleComparison != 0) {
            return titleComparison;
        }

        return Float.compare(this.cost, other.cost);
    }

    @Override
    public String toString() {
        return String.format("Media[ID=%d, Title=%s, Category=%s, Cost=%.2f]", id, title, category, cost);
    }
}
