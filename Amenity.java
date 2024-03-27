package Town.Sport.Signups.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Amenity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long AmenityId;
	
  private String amenity;
  
  @ManyToMany(mappedBy = "amenities")
  private Set<TownSportSignup> town_Sports_signups = new HashSet<>();
}
