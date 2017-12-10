package org.kolokolov.springtuttorial.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping
    public String hello() {
        logger.debug("Hello controller starts");
        return "Hello!";
    }
}
