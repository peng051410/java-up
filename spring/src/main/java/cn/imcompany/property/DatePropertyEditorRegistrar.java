package cn.imcompany.property;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/23
 */
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {
    
    private PropertyEditor propertyEditor;
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(java.util.Date.class, getPropertyEditor());
    }

    public PropertyEditor getPropertyEditor() {
        return propertyEditor;
    }

    public DatePropertyEditorRegistrar setPropertyEditor(PropertyEditor propertyEditor) {
        this.propertyEditor = propertyEditor;
        return this;
    }
}
