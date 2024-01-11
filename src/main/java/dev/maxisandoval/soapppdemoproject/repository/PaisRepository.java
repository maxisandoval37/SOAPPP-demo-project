package dev.maxisandoval.soapppdemoproject.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import localhost._8081.ws.Pais;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaisRepository {

    private static final Map<String, Pais> paises = new HashMap<>();

    @PostConstruct
    public void initData() {
        cargarPaisesDelJson();
    }

    public Pais encontrarPais (String name) {
        Assert.notNull(name, "El nombre del pais no puede estar vacio");
        return paises.get(name.toLowerCase());
    }

    private void cargarPaisesDelJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Pais>> typeReference = new TypeReference<>() {};

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("paises.json")){
            List<Pais> paisesList = objectMapper.readValue(inputStream, typeReference);

            for (Pais pais: paisesList) {
                Assert.notNull(pais.getNombre(), "El valor del nombre del pais no puede estar vacio");
                paises.put(pais.getNombre(), pais);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
