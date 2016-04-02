package com.tacsg4.response;

import java.util.ArrayList;
import java.util.List;

import com.tacsg4.domain.MarvelHero;

public class MarvelHeroResponse {

	private List<MarvelHero> heroes;

	public List<MarvelHero> getHeroes() {
		
		if ( heroes == null )
			heroes = new ArrayList<MarvelHero>();
		return heroes;
	}

	public void setHeroes(List<MarvelHero> heroes) {
		this.heroes = heroes;
	}

}
