package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.constants.CommonConstants;
import com.adobe.aem.guides.wknd.core.services.ServiceResolver;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.crx.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/info/post"}
)
public class PostServlet extends SlingAllMethodsServlet {

    public static final Logger LOG = LoggerFactory.getLogger(PostServlet.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Reference
    private ServiceResolver serviceResolver;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String requestPath = request.getParameter("path");
        String pathWithoutExtension = requestPath.substring(0, requestPath.lastIndexOf("."));
        try {
            ResourceResolver rr = serviceResolver.getServiceResourceResolver();
            Resource resource = rr.getResource(pathWithoutExtension + CommonConstants.SLASH + JcrConstants.JCR_CONTENT);
            Node node = resource.adaptTo(Node.class);
            node.setProperty("jcr:title", "last chance to change");
            rr.commit();
        } catch (LoginException | RepositoryException e) {
            throw new RuntimeException(e);
        }


    }
}