package giit.java.spring.webapp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService service;

    HelloServlet(HelloService service) { this.service = service; }

    @GetMapping("/api")
    String welcome() {
        logger.info("Got request");
        return welcome(null, null);
    }

    @GetMapping(value = "/api", params = {"name", "lang"})
    String welcome(@RequestParam String name, @RequestParam("lang") Integer langId) {
        logger.info("Got request");
        return service.prepareGreeting(name, langId);
    }

}
