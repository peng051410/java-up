package cn.imcompany.property;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/23
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private String datePattern = "yyyy/MM/dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(datePattern);
        final LocalDate localDate = LocalDate.parse(text, timeFormatter);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        setValue(date);
    }

}


