/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;

import java.time.LocalDate;

/**
 * @author tomyli
 * @date 2024/11/20
 * enjoy
 */
public class NextDayDateDisplayer {

    private LocalDate dateOfNextDay;

    public void setDateOfNextDay(LocalDate dateOfNextDay) {
        this.dateOfNextDay = dateOfNextDay;
    }

    public void display() {
        System.out.println(dateOfNextDay);
    }
}
