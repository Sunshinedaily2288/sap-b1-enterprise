package com.enterprise.integration.mock;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class MockBackendService {
    public static void main(String[] args) throws IOException {
        // Set local port to 8081 matching our Cloud Connector internal configuration mapping
        int port = 8081;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Whitelist resource path endpoint pattern matching our JSON access rules
        server.createContext("/api/v1/erp/inventory/status", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String responseJson = "{\"status\":\"CONNECTED\",\"source\":\"Local_OnPremise_Mock_ERP\",\"data\":{\"stock_integrity\":\"VALID\",\"available_units\":450}}";

                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, responseJson.getBytes().length);

                OutputStream os = exchange.getResponseBody();
                os.write(responseJson.getBytes());
                os.close();
            }
        });

        System.out.println("🚀 Mock Enterprise On-Premise ERP listening safely on local port: " + port);
        server.setExecutor(null);
        server.start();
    }
}
