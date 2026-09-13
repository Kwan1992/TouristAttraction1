package org.example.turistguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private final String name;
    private final String description;
    private final String city;
    private final ArrayList <String> tags;

    public TouristAttraction(String name, String description, String city) {
        this(name, description, city, List.of());
    }

    public TouristAttraction(String name, String description, String city, List<String> tags) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = new ArrayList<>(tags);
    }
    public List<String> getTags() {
        return tags;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addTag(String tag){
                tags.add(tag);
    }
}
