package com.mmorrell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = "com.mmorrell")
public class OpenBookMarketMakerApplication {

    final StrategyManager strategyManager;

    @Autowired
    public OpenBookMarketMakerApplication(StrategyManager strategyManager) {
        this.strategyManager = strategyManager;
    }

    // @RequestMapping("/")
//    Map<String, Object> home() {
//        return Map.of(
//                "email", "contact@mmorrell.com",
//                "status", "building",
//                "solana", Map.of(
//                        "bid", String.format("%.3f", strategyManager.getOpenBookSolUsdc().getBestBidPrice()),
//                        "ask", String.format("%.3f", strategyManager.getOpenBookSolUsdc().getBestAskPrice())
//                )
//        );
//    }

    public static void main(String[] args) {
        SpringApplication.run(OpenBookMarketMakerApplication.class, args);
    }

}