package pl.michol.calculator.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michol.calculator.api.model.CalculatorRequest;
import pl.michol.calculator.api.model.ConverterResponse;
import pl.michol.calculator.engine.InfixToOnpConverter;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/converter")
public class ConverterApi {

    private InfixToOnpConverter infixToOnpConverter;

    @Autowired
    public ConverterApi(InfixToOnpConverter infixToOnpConverter) {
        this.infixToOnpConverter = infixToOnpConverter;
    }

    @PostMapping
    public Mono<ConverterResponse> calculate(@RequestBody CalculatorRequest calculatorRequest) {
        String insertSpaces = calculatorRequest.getOperation().replaceAll("[/*\\-+%^()]", " $0 ").replaceAll("\\s+", " ");
        String onpInput = infixToOnpConverter.convert(insertSpaces);
        ConverterResponse converterResponse = new ConverterResponse(onpInput);
        return Mono.just(converterResponse);
    }
}
