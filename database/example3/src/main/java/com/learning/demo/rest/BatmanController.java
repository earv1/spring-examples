package com.learning.demo.rest;

import com.learning.demo.libraries.Batman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BatmanController {

    private final Batman batman;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public BatmanController(Batman batman) {
        this.batman = batman;
    }

    // curl localhost:8080/fightcrime?broodlevel=Happy
    @RequestMapping("/fightcrime")
    public BatmanResponse fightCrime(@RequestParam(value="broodlevel", defaultValue="High") Batman.BroodLevel broodLevel) {

        return new BatmanResponse(
                String.valueOf(counter.incrementAndGet()),
                            batman.fightCrime(broodLevel));
    }
}
