package org.springframework.samples.petclinic.vets;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

public class VetApiTest {

    private RestTemplate restTemplate;
    private WireMockServer wireMockServer;

    @BeforeEach
    void configureSystemUnderTest() {
        this.wireMockServer = new WireMockServer(options().port(8099));
        this.wireMockServer.start();
    }

    @AfterEach
    void stopWireMockServer() {
        this.wireMockServer.stop();
    }

    @Test
    void shouldReturnConfiguredHttpResponse() {
        //Identify the HTTP request
        givenThat(get(urlEqualTo("/vets")).willReturn(aResponse()
                .withStatus(200)
        ));

        String serverUrl = buildApiMethodUrl();
        ResponseEntity<String> response = restTemplate.getForEntity(serverUrl, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private String buildApiMethodUrl() {
        return String.format("http://localhost:%d/vets", this.wireMockServer.port());
    }
}
