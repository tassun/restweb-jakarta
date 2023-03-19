package com.test.restweb;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("server")
public class ServerResource {
	
	//curl http://localhost:8080/restweb/webapi/server/info
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHi(@Context HttpServletRequest request) {
    	System.out.println("real path = "+request.getServletContext().getRealPath(""));
    	Map<String,String> map = new HashMap<>();
    	map.put("path",request.getServletContext().getRealPath(""));
    	map.put("name",request.getServerName());
    	map.put("address",request.getLocalAddr());
        return JSONObject.toJSONString(map);    	
    }

}
