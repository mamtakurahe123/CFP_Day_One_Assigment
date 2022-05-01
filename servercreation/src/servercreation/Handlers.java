package servercreation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Handlers {
	

	public static class RootHandler implements HttpHandler{
		@Override
		public void handle(HttpExchange exchange)throws IOException{
			String response = "<h1> Server start sucess if you see this message </h1>" +
		    "<h1> Port: </h1>" + SimpleServer.port + "</h1>";
			exchange.sendResponseHeaders(rCode 200, response.length());
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
			
		}
		
	}



	
	public static class EchoHeaderHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException{
			Headers headers = exchange.getRequestHeaders();
			Set<Map.Entry<String, List<String>>> entries=header.entrySet();
			String response="";
			for(Map.Entry<String, List<String>>entry :entries)
				response += entry.toString() + "\n";
			exchange.sendResposeHeader(rCode: 200, response.length());
		   OutputStream os = exchange.getResponseBody();
		   os.write(response.getBytes());
		   os.close();
		   
		}

	}
	
	public class EchoGetHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException{
			Map<String, Object> parameters = new HashMap<~>();
			URI requestedUri = exchange.getRequestURI();
			String query =requestedUri.getRawQuery();
			parseQuery(query, parameters);
			String response="";
			for(String key : parameters.keySet())
				response += key + "=" + parameters.get(key) + "\n";
			exchange.sendResposeHeader(rCode: 200, response.length());
		   OutputStream os = exchange.getResponseBody();
		   os.write(response.getBytes());
		   os.close();
		   
		}

	}

	public class EchoPostHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException{
			Map<String, Object> parameters = new HashMap<~>();
			InputStreamReader isr = new InputStreamReader(exchange.getRequestHeaders(), charsetName:"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String query = br.readLine();
			parseQuery(query, parameters);
			String response="";
			for(String key : parameters.keySet())
				response += key + "=" + parameters.get(key) + "\n";
			exchange.sendResposeHeader(rCode: 200, response.length());
		   OutputStream os = exchange.getResponseBody();
		   os.write(response.getBytes());
		   os.close();

	  }

		

	}

	
	private void parseQuery(String query, Map<String, Object> parameters, String regex) {
		// TODO Auto-generated method stub
		
		if(query != null) {
			String pairs[] = query.split(regex:"[&]");
			for (String pair : pairs) {
				String param[] = query.split(regex:"[=]");
				String key = null;
				String value = null;
				if(param.length >0) {
					key = URLDecode.decode(param[0],System.getProperty("file.encoding"));
				}
				if(param.length > 1) {
					value = URLDecode.decode(param[0],System.getProperty("file.encoding"));
				}
				parameters.put(key, value);
			}
		}
		
	}

}


