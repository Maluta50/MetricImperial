package za.co.ayo.metricimperial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.ayo.metricimperial.web.MetricsController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTests {

    @Autowired
    private MetricsController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}