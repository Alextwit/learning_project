package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.services.multiimpl.MultipleImplementationDemoService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/info/multiimpl"}
)

public class MultipleImplementationServlet extends SlingSafeMethodsServlet {

    @Reference
    private List<MultipleImplementationDemoService> services;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        for (MultipleImplementationDemoService list : services) {
            writer.println(list.getName() + ",");
        }
    }
}
