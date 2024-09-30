package cat.tecnocampus.fgcstations.application;

import cat.tecnocampus.fgcstations.application.DTOs.StationDTO;
import cat.tecnocampus.fgcstations.application.DTOs.StationTopFavoriteJourney;
import cat.tecnocampus.fgcstations.application.exception.StationDoesNotExistsException;
import cat.tecnocampus.fgcstations.application.mapper.MapperHelper;
import cat.tecnocampus.fgcstations.domain.Station;
import cat.tecnocampus.fgcstations.persistence.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FgcStationService {
    private final StationRepository stationRepository;

    public FgcStationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<StationDTO> getStationsDTO() {
        List<StationDTO> stations = stationRepository.findALlDTO(); // Example call to repository
        return stations;
    }

    public List<Station> getStationsDomain() {
        List<Station> stations = stationRepository.findAll();
        return stations;
    }

    public Station getStation(String name) {
        // TODO 3: get a station by name (see the returned type). If the station does not exist, throw a StationDoesNotExistsException
        //  you won't need to write any sql (jpql) query
        return stationRepository.findByName(name).orElseThrow(()-> new StationDoesNotExistsException(name));
    }

    public StationDTO getStationDTO(String name) {
        // TODO 4: get a station by name (see the returned type). If the station does not exist, throw a StationDoesNotExistsException
        return stationRepository.findByNameDTO(name).orElseThrow(()-> new StationDoesNotExistsException(name));
    }

    public List<StationTopFavoriteJourney> getStationsOrderedByFavoriteJourneysAsEitherOriginOrDestination() {
        // TODO 5: this is an optional exercise because is quite tricky. You need to use a native query because is no possible to
        //  have a derived table (subquery).
        //  You first need to use a 'UNION' to get the stations either as origin or destination of a Journey. Then you need to group and count
        return null;
    }
}
