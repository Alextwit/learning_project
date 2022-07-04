package com.adobe.aem.guides.wknd.core.services.multiimpl.impl;

import com.adobe.aem.guides.wknd.core.config.AlexOsgiConfig;
import com.adobe.aem.guides.wknd.core.services.multiimpl.MultipleImplementationDemoService;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = MultipleImplementationDemoService.class, immediate = true)
@Designate(ocd = AlexOsgiConfig.class)
public class SeparateConfigService implements MultipleImplementationDemoService {

    private String serviceName;

    @Activate
    public void activate(AlexOsgiConfig alexOsgiConfig) {
        serviceName = alexOsgiConfig.serviceName();
    }

    @Deactivate
    public void deactivate() {
    }

    @Override
    public String getName() {
        return serviceName;
    }

}
