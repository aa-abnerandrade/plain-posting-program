package com.application;


import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApplicationTest {

//    @Value(value = "${local.server.port}")
//    private int port;
//
//    @ParameterizedTest
//    @ValueSource(strings = {"", "/", "/home"})
//    void shouldDisplayDefaultHelloPage(String path) throws IOException {
//        try (WebClient webClient = new WebClient()) {
//            HtmlPage page = webClient.getPage(getLocalUrl(path));
//
//            assertEquals("Welcome to Spring Boot 3 Web Application.", page.getBody().asNormalizedText());
//        }
//    }
//
//    private String getLocalUrl(String path) {
//        return "http://localhost:%d%s".formatted(port, path);
//    }
}
