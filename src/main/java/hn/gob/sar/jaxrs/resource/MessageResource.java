/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.gob.sar.jaxrs.resource;

/**
 *
 * @author csuazo
 */
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import hn.gob.sar.model.Message;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
@Api(value = "/message", description = "Operaciones con Mensajes")
public class MessageResource {

    @GET
    @Path("ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'MessageService' is running ==> ping");
        return "received ping on " + new Date().toString();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as well (don't forget @XmlRootElement)
    @ApiOperation(
            value = "Devuelve todos los mensajes",
            notes = "Devuelve todos los mensajes del sistema"
    )
    public List<Message> getAllMessages() throws Exception {

        List<Message> messages = new ArrayList<>();

        Message m = new Message();
        m.setDate(new Date());
        m.setFirstName("Nabi");
        m.setLastName("Zamani");
        m.setText("Hello World!");
        messages.add(m);

        System.out.println("getAllMessages(): found " + messages.size() + " message(s) on DB");

        return messages; //do not use Response object because this causes issues when generating XML automatically
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/post")
    @ApiOperation(
            value = "Ingresa un mensaje al sistema",
            notes = "Devuelve el status del ingreso"
    )
    public String postMessage(Message msg) throws Exception {

        System.out.println("First Name = " + msg.getFirstName());
        System.out.println("Last Name  = " + msg.getLastName());

        return "ok";
    }
}
