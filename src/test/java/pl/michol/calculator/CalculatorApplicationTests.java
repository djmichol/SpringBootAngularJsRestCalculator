package pl.michol.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import pl.michol.calculator.api.CalculatorApi;
import pl.michol.calculator.api.model.CalculatorRequest;
import pl.michol.calculator.api.model.CalculatorResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {

	@Autowired
	private CalculatorApi calculatorApi;

	private WebTestClient webClient;

	@Test
	public void postasd(){
		webClient = WebTestClient.bindToController(calculatorApi).build();
		CalculatorRequest calculatorRequest = new CalculatorRequest();
		calculatorRequest.setOperation("((2+7)/3+(14-3)*4)/2");
		CalculatorResponse response = webClient.post().uri("/api/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(calculatorRequest))
				.exchange()
				.expectStatus().isOk()
				.expectBody(CalculatorResponse.class)
				.returnResult().getResponseBody();
		Assert.assertEquals(new Double(23.5), response.getResult());
	}

}
