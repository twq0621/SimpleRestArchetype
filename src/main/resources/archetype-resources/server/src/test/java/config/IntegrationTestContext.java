#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import ${package}.spring.ProductionSpringConfig;

import org.eclipse.jetty.${artifactId}.Server;
import org.junit.After;
import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static ${package}.application.AppRunner.createServer;

public class IntegrationTestContext {

    private Server ${artifactId};

    @Before
    public void initServer() throws Exception {
        ${artifactId} = createServer(0, ProductionSpringConfig.class.getName());
        ${artifactId}.start();
    }

    @After
    public void stopServer() throws Exception {
        ${artifactId}.stop();
    }

    public final WebTarget target(final String path) {
        Client client = ClientBuilder.newClient();
        return client.target(${artifactId}.getURI()).path(path);
    }


}
