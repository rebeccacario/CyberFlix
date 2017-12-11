package edu.txstate.internet.cyberflix.data.film;

import java.util.ArrayList;
import java.util.List;

import edu.txstate.internet.cyberflix.data.actor.Actor;

public class Film {
	public enum FilmRating {
		G, PG, PG_13, R, NC_17, X, UR
	}
	
	private int filmID;
	private String title;
	private String description;
	private String releaseYear;
	private int length;
	private FilmRating rating;
	private List <Actor> actors;
	private String category;
	private int posterImage;

	public Film(int filmID, String title, String description,
			String releaseYear, int length, FilmRating rating) {
		super();
		this.filmID = filmID;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.length = length;
		this.rating = rating;
		this.actors = new ArrayList <Actor> ();
		this.posterImage = filmID % 10;
	}
	
	public void addActor (Actor anActor) {
		if (!actors.contains(anActor)) actors.add(anActor);
	}
	
	public List <Actor>getActors () {
		return actors;
	}

	public String getDescription() {
		return description;
	}

	public int getFilmID() {
		return filmID;
	}

	public int getLength() {
		return length;
	}

	public FilmRating getRating() {
		return rating;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setRating(FilmRating rating) {
		this.rating = rating;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Film [filmID=" + filmID + ", title=" + title + ", description="
				+ description + ", releaseYear=" + releaseYear + ", length="
				+ length + ", rating=" + rating + "]";
	}

	public int getPosterImage() {
		return posterImage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(int _category) {
		switch(_category) {
		case 1: this.category = "Action";
			break;
		case 2: this.category = "Animation";
			break;
		case 3: this.category = "Children";
			break;
		case 4: this.category = "Classics";
			break;
		case 5: this.category = "Comedy";
			break;
		case 6: this.category = "Documentary";
			break;
		case 7: this.category = "Drama";
			break;
		case 8: this.category = "Family";
			break;
		case 9: this.category = "Foreign";
			break;
		case 10: this.category = "Games";
			break;
		case 11: this.category = "Horror";
			break;
		case 12: this.category = "Music";
			break;
		case 13: this.category = "New";
			break;
		case 14: this.category = "Sci-Fi";
			break;
		case 15: this.category = "Sports";
			break;
		case 16: this.category = "Travel";
			break;
		default: this.category = "None";
		}
	}
	
	public static FilmRating getRatingFromString(String rating) {
		switch(rating) {
			case "G": return FilmRating.G;
			case "PG": return FilmRating.PG;
			case "PG_13": return FilmRating.PG_13;
			case "R": return FilmRating.R;
			case "NC_17": return FilmRating.NC_17;
			case "X": return FilmRating.X;
			default: return FilmRating.UR;
		}
	}
	
	public static FilmCategory getCategoryFromString(String _category) {
		switch(_category) {
			case "action": return FilmCategory.ACTION;
			case "animation": return FilmCategory.ANIMATION;
			case "children": return FilmCategory.CHILDREN;
			case "classics": return FilmCategory.CLASSICS;
			case "comedy": return FilmCategory.COMEDY;
			case "documentary": return FilmCategory.DOCUMENTARY;
			case "drama": return FilmCategory.DRAMA;
			case "family": return FilmCategory.FAMILY;
			case "foreign": return FilmCategory.FOREIGN;
			case "games": return FilmCategory.GAMES;
			case "horror": return FilmCategory.HORROR;
			case "music": return FilmCategory.MUSIC;
			case "new": return FilmCategory.NEW;
			case "scifi": return FilmCategory.SCI_FI;
			case "sports": return FilmCategory.SPORTS;
			case "travel": return FilmCategory.TRAVEL;
			default: return FilmCategory.NONE;
		}
}
}
