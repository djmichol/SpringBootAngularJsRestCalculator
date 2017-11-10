package pl.michol.calculator.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.michol.calculator.api.model.CalculatorRequest;
import pl.michol.calculator.api.model.CalculatorResponse;
import pl.michol.calculator.engine.InfixToOnpConverter;
import pl.michol.calculator.engine.ONPCalculator;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorApi {

    private InfixToOnpConverter infixToOnpConverter;
    private ONPCalculator onpCalculator;

    @Autowired
    public CalculatorApi(InfixToOnpConverter infixToOnpConverter, ONPCalculator onpCalculator) {
        this.infixToOnpConverter = infixToOnpConverter;
        this.onpCalculator = onpCalculator;
    }

    @PostMapping
    public Mono<CalculatorResponse> calculate(@RequestBody CalculatorRequest calculatorRequest) {
        String onpInput = infixToOnpConverter.convert(calculatorRequest.getOperation());
        Double result = onpCalculator.calculate(onpInput);
        CalculatorResponse calculatorResponse = new CalculatorResponse(result);
        return Mono.just(calculatorResponse);
    }
}
