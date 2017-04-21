package com.lzh.demo.thrift.server;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lizhuohang on 17/4/19.
 */
public class AdditionServiceHandler implements AdditionService.Iface {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdditionServiceHandler.class);

    @Override
    public int add(int n1, int n2) throws TException {
        LOGGER.warn("add {} and {}", n1, n2);
        return n1 + n2;
    }
}
