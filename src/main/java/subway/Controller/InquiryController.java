package subway.Controller;

import subway.Controller.exceptions.SameStationPathRequestException;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TimeGraph;
import subway.dto.PathDTO;
import subway.view.InputView;

public class InquiryController {

    public static void inquiryByTime() {
        Station departureStation = StationRepository.searchByName(InputView.getDepartureStationName());
        Station arrivalStation = StationRepository.searchByName(InputView.getArrivalStationName());

        if (departureStation.equals(arrivalStation)) {
            throw new SameStationPathRequestException();
        }
        PathDTO pathDTO = TimeGraph.getShortestPath(departureStation, arrivalStation);

        // pathDTO 출력 로직

    }

}
