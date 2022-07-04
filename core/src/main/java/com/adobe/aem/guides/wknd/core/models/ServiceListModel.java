package com.adobe.aem.guides.wknd.core.models;

import com.adobe.aem.guides.wknd.core.services.configfactory.ConfigurationFactoryDemoService;
import com.adobe.aem.guides.wknd.core.services.multiimpl.MultipleImplementationDemoService;

import java.util.List;

public interface ServiceListModel {
    List<MultipleImplementationDemoService> getServices();
    List<ConfigurationFactoryDemoService> getConfigurationFactoryList();
}
