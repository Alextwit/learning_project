package com.adobe.aem.guides.wknd.core.models;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface OptionItem {

    default boolean isSelected() {
        return false;
    }

    default boolean isDisabled() {
        return false;
    }

    default String getValue() {
        return null;
    }

    default String getText() {
        return null;
    }
}
