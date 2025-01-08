/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel.inventor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tomyli
 * @date 2025/1/8
 * enjoy
 */
public class Society {

    private String name;

    public static String Advisors = "advisors";
    public static String President = "president";

    private List<InventorV2> members = new ArrayList<>();

    private Map officers = new HashMap();

    public List getMembers() {
        return members;
    }

    public Map getOfficers() {
        return officers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Society setMembers(List<InventorV2> members) {
        this.members = members;
        return this;
    }

    public boolean isMember(String name) {
        for (InventorV2 inventor : members) {
            if (inventor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
