package pl.michol.calculator.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michol.calculator.api.model.ConverterResponse;
import pl.michol.calculator.engine.algorithms.implementation.SortAlgorithmFactory;
import pl.michol.calculator.engine.algorithms.model.SortRequest;
import pl.michol.calculator.engine.algorithms.model.SortResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sort")
public class AlgorithmsApi {

    private final SortAlgorithmFactory sortAlgorithmFactory;

    @Autowired
    public AlgorithmsApi(SortAlgorithmFactory sortAlgorithmFactory) {
        this.sortAlgorithmFactory = sortAlgorithmFactory;
    }

    @PostMapping(value = "/bubble")
    public Mono<SortResponse> sort(@RequestBody SortRequest sortRequest) {
        return Mono.just(sortAlgorithmFactory.getAlgorithm("bubble").sort(sortRequest.getArray()));
    }

    @PostMapping(value = "/quick")
    public Mono<SortResponse> quick(@RequestBody SortRequest sortRequest) {
        return Mono.just(sortAlgorithmFactory.getAlgorithm("quick").sort(sortRequest.getArray()));
    }

    @PostMapping(value = "/insertion")
    public Mono<SortResponse> insertion(@RequestBody SortRequest sortRequest) {
        return Mono.just(sortAlgorithmFactory.getAlgorithm("insertion").sort(sortRequest.getArray()));
    }

}
