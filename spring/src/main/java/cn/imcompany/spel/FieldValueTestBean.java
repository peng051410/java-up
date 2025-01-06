/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tomyli
 * @date 2025/1/6
 * enjoy
 */
@Data
@Component
public class FieldValueTestBean {

    @Value("#{systemProperties['user.region']}")
    private String defaultLocale;

}
