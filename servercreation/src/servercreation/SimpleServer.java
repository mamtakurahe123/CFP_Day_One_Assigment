package servercreation;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleServer {
	
	public static int DEFAULT_PORT = 3031;
	public static int port;
	private HttpServer httpServer;
	
	private void start(int port) {
		this.port=port;
		try {
			httpServer = HttpServer.create(new InetSocketAddress(port),backlog 0);
			System.out.println("Server Started at prot Number" + port);
			httpServer.createContext(path:"/", new Handlers.RootHandler());
			httpServer.createContext(path:"/echoHerder", new Handlers.EchoHeaderHandler());
			httpServer.createContext(path:"/echoGet", new Handlers.EchoGetHandler());
			httpServer.createContext(path:"/echoPost", new Handlers.EchoPostHandler());
			httpServer.setExecutor(null);
			httpServer.start();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SimpleServer httpServer = new SimpleServer();
		httpServer.start(DEFAULT_PORT);
	}

}

