# SOAPPP Demo Project - Educación IT 2023 (Curso dictado por mi autoría)

Proporciona servicios web SOAP. Construido con Spring Boot para facilitar el desarrollo y prueba de aplicaciones basadas en este protocolo.

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

## Live Demo

[onrender.com](https://soap-paises.onrender.com/ws/paises.wsdl)

## Información Adicional
Para cualquier información adicional o consultas: <maxisandoval98@gmail.com>

Muchas gracias!
