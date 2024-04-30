package com.ianua.api.gateway.routing.factory;

import com.ianua.api.gateway.routing.model.RequestInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerMapping;
import com.ianua.api.gateway.routing.exception.RouteMatcherException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestInfoFactory {
    public static RequestInfo build(HttpServletRequest request) throws RouteMatcherException {
        Pattern pattern;
        Matcher matcher;
        String fullPath;
        String project;
        String version;
        String path;

        fullPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

        pattern = Pattern.compile("/gateway/(\\w+)/(\\w+)/(.*)");
        matcher = pattern.matcher(fullPath);

        if (!matcher.find()) {
            throw new RouteMatcherException();
        }

        project = matcher.group(1);
        version = matcher.group(2);
        path = matcher.group(3);

        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setProject(project);
        requestInfo.setVersion(version);
        requestInfo.setPath(path);
        requestInfo.setHeaders(convertHeadersToMap(request));
        requestInfo.setMethod(HttpMethod.valueOf(request.getMethod()));

        return requestInfo;
    }

    private static Map<String, String> convertHeadersToMap(HttpServletRequest request) {
        Map<String, String> headersMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);

            headersMap.put(headerName, headerValue);
        }

        return headersMap;
    }
}
