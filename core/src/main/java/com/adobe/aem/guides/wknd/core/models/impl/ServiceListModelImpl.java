package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.ServiceListModel;
import com.adobe.aem.guides.wknd.core.services.configfactory.ConfigurationFactoryDemoService;
import com.adobe.aem.guides.wknd.core.services.multiimpl.MultipleImplementationDemoService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceListModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceListModelImpl implements ServiceListModel {

    @OSGiService
    private List<MultipleImplementationDemoService> services;

    @OSGiService(filter = "(component.name=com.adobe.aem.guides.wknd.core.services.multiimpl.impl.GeneralXmlConfigService")
    private MultipleImplementationDemoService generalXmlConfigService;

    @OSGiService(filter = "(serviceName=config two")
    private ConfigurationFactoryDemoService configFactoryTwo;

    @OSGiService
    private List<ConfigurationFactoryDemoService> configurationFactoryList;

    @PostConstruct
    protected void init() {
    }

    @Override
    public List<MultipleImplementationDemoService> getServices() {
        return services;
    }

    @Override
    public List<ConfigurationFactoryDemoService> getConfigurationFactoryList() {
        return configurationFactoryList;
    }

    public MultipleImplementationDemoService getGeneralXmlConfigService() {
        return generalXmlConfigService;
    }
}
