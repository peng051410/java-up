/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import org.springframework.expression.EvaluationException;
import org.springframework.expression.Operation;
import org.springframework.expression.OperatorOverloader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tomyli
 * @date 2025/1/7
 * enjoy
 */
public class ListConcatenation implements OperatorOverloader {

    @Override
    public boolean overridesOperation(Operation operation, Object leftOperand, Object rightOperand) throws EvaluationException {
        return (operation == Operation.ADD && leftOperand instanceof List<?> && rightOperand instanceof List<?>);
    }

    @Override
    public Object operate(Operation operation, Object leftOperand, Object rightOperand) throws EvaluationException {
        if (operation == Operation.ADD && leftOperand instanceof List<?> list1 && rightOperand instanceof List<?> list2) {
            List resultList = new ArrayList<>(list1);
            resultList.addAll(list2);
            return resultList;
        }
        throw new EvaluationException("Unexpected operation: " + operation);
    }
}
