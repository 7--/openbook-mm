package com.mmorrell.strategies;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class Strategy {

    @Value("${solana.wallet.keypair.json.path}")
    public String SOLANA_WALLET_KEYPAIR_JSON_PATH;

    public abstract void start();

    @PostConstruct
    public void startupComplete() {
        log.info(this.getClass().getSimpleName() + " strategy instantiated.");
    }

}
