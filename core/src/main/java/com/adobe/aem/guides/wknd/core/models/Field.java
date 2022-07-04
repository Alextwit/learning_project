package com.adobe.aem.guides.wknd.core.models;

import javax.annotation.Nonnull;
import org.osgi.annotation.versioning.ConsumerType;
import com.adobe.cq.export.json.ComponentExporter;

@ConsumerType
public interface Field extends ComponentExporter {

    String PN_NAME = "name";

    default String getId() {
        return null;
    }

    default String getName() {
        return null;
    }

    default String getValue() {
        return null;
    }

    default String getTitle() {
        return null;
    }


    default String getHelpMessage() {
        return null;
    }


    @Nonnull
    @Override
    default String getExportedType() {
        return "";
    }
}
