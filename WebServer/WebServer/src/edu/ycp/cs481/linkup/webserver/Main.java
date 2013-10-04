package edu.ycp.cs481.linkup.webserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
	public static void main(String[] args) throws Exception {
		// Create an embedded Jetty server on port 8080
		Server server = new Server(new QueuedThreadPool(20));
		
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(8080);
		
		server.addConnector(connector);

		// Create a handler for processing our GWT app
		/*
		WebAppContext handler = new WebAppContext();
		handler.setContextPath("/");
		handler.setWar("./apps/GwtApplication.war");
		*/

		// If your app isn't packaged into a WAR, you can do this instead
		WebAppContext altHandler = new WebAppContext();
		altHandler.setResourceBase("../../UI/UI/war");
		altHandler.setDescriptor("../../UI/UI/war/WEB-INF/web.xml");
		altHandler.setContextPath("/");
		altHandler.setParentLoaderPriority(true);

		// Add it to the server
		server.setHandler(altHandler);

		// And start it up
		server.start();
		server.join();
	}
}
