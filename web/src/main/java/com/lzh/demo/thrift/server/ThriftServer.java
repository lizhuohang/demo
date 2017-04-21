package com.lzh.demo.thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by lizhuohang on 17/4/21.
 */
public class ThriftServer implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftServer.class);

    private static final int port = 12116;

    private ThriftThread thriftThread = null;

    public ThriftServer() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (thriftThread == null) {
            thriftThread = new ThriftThread();
        }
        thriftThread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    class ThriftThread extends Thread {
        public void run() {
            AdditionService.Processor<AdditionServiceHandler> processor = new AdditionService.Processor<>(
                    new AdditionServiceHandler());
            try {
                TServerTransport serverTransport = new TServerSocket(port);
                TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
                LOGGER.warn("Starting the simple server...");
                server.serve();
            } catch (TTransportException e) {
                e.printStackTrace();
            }
        }
    }
}
