package com.adobe.aem.guides.wknd.core.services.multiimpl.impl;

import com.adobe.aem.guides.wknd.core.services.multiimpl.MultipleImplementationDemoService;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = MultipleImplementationDemoService.class, immediate = true)
@Designate(ocd = SeparateRunModesXmlConfigService.SeparateConfigFour.class)
public class SeparateRunModesXmlConfigService implements MultipleImplementationDemoService {

    private SeparateConfigFour separateConfigFour;

    @Activate
    @Modified
    public void activate(final SeparateConfigFour separateConfigFour) {
        this.separateConfigFour = separateConfigFour;
    }

    @Deactivate
    public void deactivate() {
    }

    @Override
    public String getName() {
        return separateConfigFour.serviceName();
    }

    @ObjectClassDefinition(name = "Alex fourth config",
            description = "Alex config demo")
    @interface SeparateConfigFour {

        @AttributeDefinition(
                name = "Service name",
                description = "Enter service name",
                type = AttributeType.STRING)
        public String serviceName();
    }
}
