# SOAPPP Demo Project - Educación IT 2023 (Curso dictado por mi autoría)

Proporciona servicios web SOAP, el cual nos otorga información del país ingresado. Construido con Spring Boot WS.

## Tecnologías Utilizadas

- **Java 17**
- **Maven**
- **Dockerfile**
- **Deploy en Render.com**
- **Spring Boot Versión 3.2.0**
- **Spring Boot Starter Web**
- **Spring Boot Starter Web Services**
- **wsdl4j:** Biblioteca para procesar WSDL.
- **Marshalling**
- **Spring Boot Starter Test:** Se implementaron tests de integración

## Construcción y Ejecución

Utiliza el siguiente comando Maven:

```bash
mvn clean install
```

## Configuración de XSD (XML Schema Definition)

El proyecto utiliza el plugin jaxb2-maven-plugin para generar clases Java a partir de un archivo XSD.

```xml
<plugins>
    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>jaxb2-maven-plugin</artifactId>
        <version>3.1.0</version>
        <executions>
            <execution>
                <id>xjc</id>
                <goals>
                    <goal>xjc</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <sources>
                <source>${project.basedir}/src/main/resources/paises.xsd</source>
            </sources>
        </configuration>
    </plugin>
</plugins>
```

## Pruebas

```bash
curl --header "content-type: text/xml" -d @request.xml http://localhost:8081/ws
```

## Ejemplo de Response

```xml
<ns2:obtenerPaisResponse xmlns:ns2="http://localhost:8081/ws">
    <ns2:pais>
        <ns2:nombre>argentina</ns2:nombre>
        <ns2:capital>Cuidad Autonoma de Buenos Aires</ns2:capital>
        <ns2:moneda>ARS</ns2:moneda>
        <ns2:poblacion>46234830</ns2:poblacion>
        <ns2:bandera>https://flagcdn.com/w2560/ar.png</ns2:bandera>
    </ns2:pais>
</ns2:obtenerPaisResponse>
```

## Live Demo

[onrender.com](https://soap-paises.onrender.com/ws/paises.wsdl)

## Información Adicional
Para cualquier información adicional o consultas: <maxisandoval98@gmail.com>

Muchas gracias!
