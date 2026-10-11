package com.example.graphql.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.Character;
import com.example.graphql.Droid;
import com.example.graphql.Human;
import com.example.graphql.Starship;

@Controller
public class StarWarsControler {

	private final AtomicLong nextId = new AtomicLong(1);
	private final Map<Long, Character> characters = new LinkedHashMap<>();
	private final Map<Long, Starship> starships = new LinkedHashMap<>();

	@QueryMapping
	public Droid droid(@Argument String id) {
		Character character = characters.get(parseId(id));
		return character instanceof Droid droid ? droid : null;
	}

	@QueryMapping
	public Human human(@Argument String id) {
		Character character = characters.get(parseId(id));
		return character instanceof Human human ? human : null;
	}

	@QueryMapping
	public Starship starship(@Argument String id) {
		return starships.get(parseId(id));
	}

	@QueryMapping
	public Object search(@Argument String id) {
		long numericId = parseId(id);
		Character character = characters.get(numericId);
		return character != null ? character : starships.get(numericId);
	}

	@MutationMapping
	public Human createHuman(@Argument HumanInput input) {
		Human human = new Human(nextId.getAndIncrement(), input.name(), input.height(), normalizedEpisodes(input.appearsIn()));
		characters.put(human.getId(), human);
		return human;
	}

	@MutationMapping
	public Droid createDroid(@Argument DroidInput input) {
		Droid droid = new Droid(nextId.getAndIncrement(), input.name(),
				normalizedEpisodes(input.appearsIn()), input.primaryFunction());
		characters.put(droid.getId(), droid);
		return droid;
	}

	@MutationMapping
	public Starship createStarship(@Argument StarshipInput input) {
		Starship starship = new Starship(nextId.getAndIncrement(), input.name(), input.length());
		starships.put(starship.getId(), starship);
		return starship;
	}

	@MutationMapping
	public Character addFriend(@Argument String characterId, @Argument String friendId) {
		Character character = characters.get(parseId(characterId));
		Character friend = characters.get(parseId(friendId));
		if (character == null || friend == null) {
			return null;
		}
		if (!character.getFriends().contains(friend)) {
			character.getFriends().add(friend);
		}
		return character;
	}

	private long parseId(String id) {
		try {
			return Long.parseLong(id);
		} catch (NumberFormatException exception) {
			return -1;
		}
	}

	private List<String> normalizedEpisodes(List<String> episodes) {
		return episodes == null ? List.of() : new ArrayList<>(episodes);
	}

	public record HumanInput(String name, Float height, List<String> appearsIn) {
	}

	public record DroidInput(String name, String primaryFunction, List<String> appearsIn) {
	}

	public record StarshipInput(String name, Float length) {
	}
}