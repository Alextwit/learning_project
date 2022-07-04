package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.osgi.annotation.versioning.ConsumerType;


@ConsumerType
public interface Options extends Field {

    enum Type {
        CHECKBOX("checkbox"),
        RADIO("radio"),
        DROP_DOWN("drop-down"),
        MULTI_DROP_DOWN("multi-drop-down");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public static Type fromString(String value) {
            for (Type type : Type.values()) {
                if (StringUtils.equals(value, type.value)) {
                    return type;
                }
            }
            return CHECKBOX;
        }

        public String getValue() {
            return value;
        }
    }

    default List<OptionItem> getItems() {
        return null;
    }

    default Type getType() {
        return null;
    }

}
