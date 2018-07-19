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
import java.util.HashMap;
import java.util.Map;

import hn.gob.sar.model.Person;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
@Api(value = "/person", description = "Operaciones con Personas")
public class PersonResource {

    @Path("get")
    @GET
    @Produces({MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as well (don't forget @XmlRootElement)
    @ApiOperation(
            value = "Devuelve un usuario",
            notes = "Devuelve un usuario del sistema"
    )
    public Person getPerson() {

        Person p = new Person();
        p.setFirstName("Nabi");
        p.setLastName("Zamani");
        //p.setDateOfBirth("01.01.2012");

        p.setCitizenships(new String[]{"German", "Persian"});

        Map<String, Object> creditCards = new HashMap<String, Object>();
        creditCards.put("MasterCard", "1234 1234 1234 1234");
        creditCards.put("Visa", "1234 1234 1234 1234");
        creditCards.put("dummy", true);
        p.setCreditCards(creditCards);

        System.out.println("REST call...");

        //return Response.ok().entity(p).build();
        return p;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/post")
    @ApiOperation(
            value = "Ingresa un usuario",
            notes = "Ingresa un usuario al sistema"
    )
    public String postPerson(Person pers) throws Exception {

        System.out.println("First Name = " + pers.getFirstName());
        System.out.println("Last Name  = " + pers.getLastName());

        return "ok";
    }
}
