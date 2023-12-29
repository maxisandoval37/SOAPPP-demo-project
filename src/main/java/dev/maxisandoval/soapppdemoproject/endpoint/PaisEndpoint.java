package dev.maxisandoval.soapppdemoproject.endpoint;

import dev.maxisandoval.soapppdemoproject.repository.PaisRepository;
import localhost._8081.ws.ObtenerPaisRequest;
import localhost._8081.ws.ObtenerPaisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaisEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8081/ws";
    @Autowired//*
    private PaisRepository paisRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerPaisRequest")
    @ResponsePayload
    public ObtenerPaisResponse obtenerPais(@RequestPayload ObtenerPaisRequest request) {
        ObtenerPaisResponse response = new ObtenerPaisResponse();
        response.setPais(paisRepository.encontrarPais(request.getName()));

        return response;
    }
}