import javax.ws.rs.GET
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.DELETE
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.*

@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])

@Path('/api/hello')
class AppInfoResource {

    def grailsApplication

    @GET
    @Path('/world1')
    Response get() {
       def info = new ArrayList<String>() 
       info.add("environment": grails.util.Environment.getCurrent().getName())
       def version = grailsApplication.metadata['app.version']
       info.add("version": version)
       ok info 
    }
}
