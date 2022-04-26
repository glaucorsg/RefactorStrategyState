package br.edu.ifpb.foodstore.service.log;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
public class LogServiceTest {

    @MockBean
    private LogHandler logHandler;

    @SpyBean
    private LogService logService;

    @BeforeEach
    public void init() {
    }

    @SneakyThrows
    @Test
    void debugTest() {
        logService.debug("debug message");
        InOrder orderVerifier = Mockito.inOrder(logHandler);
        orderVerifier.verify(logHandler).log("debug");
        orderVerifier.verify(logHandler).log("debug message");
    }

    @SneakyThrows
    @Test
    void infoTest() {
        logService.debug("info message");
        InOrder orderVerifier = Mockito.inOrder(logHandler);
        orderVerifier.verify(logHandler).log("info message");
    }

    @SneakyThrows
    @Test
    void errorTest() {
        logService.error("error message");
        InOrder orderVerifier = Mockito.inOrder(logHandler);
        orderVerifier.verify(logHandler).log("error");
        orderVerifier.verify(logHandler).log("error message");
    }

}
