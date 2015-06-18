#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application;

import ${package}.spring.ProductionSpringConfig;

import org.eclipse.jetty.${artifactId}.Server;

import static ${package}.application.ServletContextHandlerFactory.createServletContext;

public class AppRunner {

  public static void main(String[] args) {
    Server ${artifactId} = createServer(8080, ProductionSpringConfig.class.getName());
    try {
      ${artifactId}.start();
      ${artifactId}.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Server createServer(int port, String springContextLocation) {
    Server ${artifactId} = new Server(port);
    ${artifactId}.setHandler(createServletContext(springContextLocation));

    return ${artifactId};
  }
}
