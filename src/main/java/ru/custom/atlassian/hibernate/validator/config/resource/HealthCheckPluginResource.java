package ru.custom.atlassian.hibernate.validator.config.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/healthcheck")
public class HealthCheckPluginResource {

    @GET
    public String healthcheck() {
        return "Plugin enabled";
    }
}
