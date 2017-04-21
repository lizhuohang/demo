package com.lzh.demo.thrift.service;

import com.lzh.demo.thrift.server.AdditionService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by lizhuohang on 17/4/20.
 */
@Service
public class RequestServiceImpl implements RequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestServiceImpl.class);

    @Override
    public int add(String host, int port, int n1, int n2) {
        LOGGER.warn("ip:{} , port:{} , num1:{} , num2:{}", host, port, n1, n2);
        int sum = 0;
        try {
            TTransport transport;
            transport = new TSocket(host, port);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            AdditionService.Client client = new AdditionService.Client(protocol);

            sum = client.add(n1, n2);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
