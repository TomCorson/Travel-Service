package travel.travel_API.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel.travel_API.Models.Lodging;

@Repository
public interface LodgingRepo extends JpaRepository<Lodging,Long>{
}
