package com.tacsg4;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;

import com.tacsg4.domain.MarvelHero;
import com.tacsg4.response.MarvelHeroResponse;

@Path("api")
public class Main {

	@GET
	@Produces("application/json")
	public Response get(
			@QueryParam("nombre") String nombre,
			@QueryParam("peso") Integer peso) throws JSONException {

		MarvelHeroResponse response = new MarvelHeroResponse();

		List<MarvelHero> filteredHeroes = new ArrayList<MarvelHero>();
		
		for( MarvelHero h : getHeroesList() ){
			boolean include = true;
			include = include && ( nombre == null || nombre.equals(h.getNombre()) );
			include = include && ( peso   == null || peso == h.getPeso() );
			
			if ( include )
				filteredHeroes.add(h);
		}
		
		response.setHeroes(filteredHeroes);

		return Response.status(200).entity(response).build();
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response post(MarvelHero hero) throws JSONException {

		/*
		 * JSONObject jsonObject = new JSONObject(); jsonObject.put("name",
		 * req.getName());
		 */

		MarvelHeroResponse response = new MarvelHeroResponse();

		List<MarvelHero> heroes = getHeroesList();
		heroes.add(hero);
		
		response.setHeroes(heroes);
		
		return Response.status(200).entity(response).build();
	}

	private List<MarvelHero> getHeroesList(){
		
		List<MarvelHero> heroes = new ArrayList<MarvelHero>();
		
		MarvelHero spiderman = new MarvelHero();
		spiderman.setNombre("spiderman");
		spiderman.setPeso(55);
		
		MarvelHero batman = new MarvelHero();
		batman.setNombre("batman");
		batman.setPeso(85);
		
		heroes.add(spiderman);
		heroes.add(batman);
		
		return heroes;
	}

}
