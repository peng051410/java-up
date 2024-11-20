/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.anno;

import cn.imcompany.DowJonesNewsListenerV2;
import org.springframework.stereotype.Component;

/**
 *
 * @author tomyli
 * @date 2024/11/19
 * enjoy
 */
@Component
public class DowJonesNewsListenerV2Anno extends DowJonesNewsListenerV2 {

        @Override
        public void doJob() {
            System.out.println("DowJonesNewsListenerV2Anno");
        }
}
