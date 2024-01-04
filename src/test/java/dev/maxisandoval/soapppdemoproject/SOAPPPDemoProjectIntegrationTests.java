package dev.maxisandoval.soapppdemoproject;

import localhost._8081.ws.ObtenerPaisRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SOAPPPDemoProjectIntegrationTests {

    @LocalServerPort
    private int port = 0;

    private String baseUrl = "http://localhost:";

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @BeforeEach
    public void init() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(ObtenerPaisRequest.class));
        marshaller.afterPropertiesSet();
    }

    @Test
    public void testSendAndReceive() {
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        ObtenerPaisRequest request = new ObtenerPaisRequest();
        request.setName("argentina");

        assertThat(ws.marshalSendAndReceive(baseUrl + port + "/ws", request) != null);
    }
}
