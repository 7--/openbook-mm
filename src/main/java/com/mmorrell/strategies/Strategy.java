package com.mmorrell.strategies;

import com.mmorrell.config.OpenBookConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class Strategy {

    public abstract void start();

    @PostConstruct
    public void startupComplete() {
        log.info(this.getClass().getSimpleName() + " strategy instantiated.");
    }

}
