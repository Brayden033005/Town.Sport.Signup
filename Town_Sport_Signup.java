package Town.Sport.Entity;

import java.util.HashSet;
import java.util.Set;

import Town.Sport.Signups.GeoLocation;
import Town.Sport.Signups.entity.Amenity;
import Town.Sport.Signups.entity.Contributor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Town_Sport_Signup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long TownsportId;
  private String sportName;
  private String stateOrProvince;
  private String sport;
  
  @Embedded
  private GeoLocation geolocation;
  
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name= "contributor_id", nullable = false)
  private Contributor contributor;
  
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name= "town_sport_amenity",
      joinColumns = @JoinColumn(name = "town_sports_id"),
      inverseJoinColumns = @JoinColumn(name = "amenity_id"))
  private Set<Amenity> amenities = new HashSet<>();
  
  
  
  
  
  
}
