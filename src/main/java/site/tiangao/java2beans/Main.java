package site.tiangao.java2beans;

import com.sun.net.httpserver.HttpServer;
import org.beetl.core.Template;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Created by shitiangao on 2017/5/2.
 */
public class Main {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            System.out.println("listen at 8000");
            server.createContext("/", (exchange) -> {
                String response = "Hello World!";
                exchange.sendResponseHeaders(200, response.length());

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            });
            server.createContext("/test", e -> {
                Template template = BeetlFactory.ins.getTemplate("test.btl");
                template.binding("name", "tom");

                e.getResponseHeaders().set("Content-Length", "100");
                e.sendResponseHeaders(200, 9);


                template.renderTo(e.getResponseBody());
            });
            server.setExecutor(null); // creates a default executor
            server.start();
            System.out.println("started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
