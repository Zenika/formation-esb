package com.zenika.resanet.tp5.pipe;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.DisableJmx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/META-INF/spring/camel-context.xml")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@DisableJmx
public class PipeRouteTest {

    private static final String HELLO = "Hello";

    @Produce(uri = "direct:pipeRoute")
    protected ProducerTemplate pipeRoute;

    @Test
    public void shouldCallEndpointSequentialyInOrder() {
        pipeRoute.sendBody(HELLO);
    }

}