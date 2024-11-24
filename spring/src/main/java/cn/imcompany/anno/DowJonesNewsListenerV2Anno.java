/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.anno;

import cn.imcompany.DowJonesNewsListenerV2;
import cn.imcompany.PasswordDecodable;
import org.springframework.stereotype.Component;

/**
 * @author tomyli
 * @date 2024/11/19
 * enjoy
 */
@Component
public class DowJonesNewsListenerV2Anno extends DowJonesNewsListenerV2 implements PasswordDecodable {

    private String password;

    @Override
    public void doJob() {
        System.out.println("DowJonesNewsListenerV2Anno");
    }

    @Override
    public String getEncodePassword() {
        return password;
    }

    @Override
    public void setDecodePassword(String password) {
        this.password = password;
    }
}
