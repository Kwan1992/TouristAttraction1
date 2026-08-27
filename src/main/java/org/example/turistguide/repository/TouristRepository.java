package org.example.turistguide.repository;

import org.example.turistguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Opret et par TouristAttraction objekter, som tilføjes til denne ArrayList.
//Tilføj en ArrayList til opbevaring af data (om ikke så længe skal I arbejde med en
//rigtig database).

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        touristAttractions.add(new TouristAttraction("Tivoli Gardens", "19th-century amusement park with antique roller coaster & live entertainment program."));
        touristAttractions.add(new TouristAttraction("Rosenborg Castle", "Dutch Renaissance palace & gardens, including a museum housing the crown jewels, with guided tours."));
        touristAttractions.add(new TouristAttraction("Nyhavn", "Copenhagen's Nyhaven, or \"New Harbor,\" is actually steeped in a long heritage. Colorful buildings line the canal and hint at a history of small-vessel traffic. "));
    }

    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }

    public TouristAttraction findTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (Objects.equals(touristAttraction.getName(), name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public ArrayList<TouristAttraction> findTouristAttractionsByDescription(String description) {
        ArrayList<TouristAttraction> touristAttraction = new ArrayList<>();
        for (TouristAttraction touristAttraction1 : touristAttractions) {
            if (touristAttraction1.getDescription().contains(description)) {
                touristAttractions.add(touristAttraction1);
            }
        }
        return touristAttraction;
    }

}
