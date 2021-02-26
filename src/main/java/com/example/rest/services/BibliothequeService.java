package com.example.rest.services;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.rest.models.BibliothequeDaoRepositoryJPA;
import com.example.rest.models.Book;
import com.example.rest.models.Livre;

@Path("livres")
public class BibliothequeService {

    BibliothequeDaoRepositoryJPA  bibliothequeDaoRepositoryJPA= new BibliothequeDaoRepositoryJPA() ;

    public BibliothequeService(){

	}
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @Path("books")
    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    public List<Book> getBooks(){
        System.out.println(bibliothequeDaoRepositoryJPA.findAll());
        return bibliothequeDaoRepositoryJPA.getAllBook();
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    public List<Livre> getLivres(){
        System.out.println(bibliothequeDaoRepositoryJPA.findAll());
        return bibliothequeDaoRepositoryJPA.findAll();
    }
	@Path("livres/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Livre getLivre(@PathParam("id") UUID uuid){
    	return bibliothequeDaoRepositoryJPA.findById(uuid);
	}

    @PUT
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public void create(Livre livre ){
       // Livre  livre  = new Livre(nom  , auteur , categorie) ;
        //livre.setCategorie(categorie);
    	bibliothequeDaoRepositoryJPA.save(livre);
	}
}

