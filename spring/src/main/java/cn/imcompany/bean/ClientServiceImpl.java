/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

/**
 * @author tomyli
 * @date 2024/12/13
 * enjoy
 */
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }
}