package com.mmorrell.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmorrell.pyth.manager.PythManager;
import com.mmorrell.serum.manager.SerumManager;
import okhttp3.OkHttpClient;
import org.p2p.solanaj.rpc.RpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableScheduling
@EnableAsync
public class BeanConfig {

    public static final String MEMO = "mmorrell.com / @skynetcap";
    @Autowired
    private OpenBookConfig openBookConfig;

    @Bean
    public RpcClient rpcClient() {
        int readTimeoutMs = 0;
        int connectTimeoutMs = 0;
        int writeTimeoutMs = 0;
        return new RpcClient(
                openBookConfig.getRPC_URL(),
                readTimeoutMs,
                connectTimeoutMs,
                writeTimeoutMs
        );
    }

    @Bean(name = "data")
    public RpcClient dataRpcClient() {
        int readTimeoutMs = 0;
        int connectTimeoutMs = 0;
        int writeTimeoutMs = 0;
        return new RpcClient(
                openBookConfig.getRPC_URL(),
                readTimeoutMs,
                connectTimeoutMs,
                writeTimeoutMs
        );
    }

    @Bean
    public SerumManager serumManager() {
        return new SerumManager(rpcClient());
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public PythManager pythManager() {
        return new PythManager(dataRpcClient());
    }

    @Bean
    public OpenBookConfig openBookConfigBean() {
        return openBookConfig;
    }


}
