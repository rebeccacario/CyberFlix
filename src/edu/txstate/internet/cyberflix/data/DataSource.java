package edu.txstate.internet.cyberflix.data;
import java.util.List;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.Film.FilmRating;
import edu.txstate.internet.cyberflix.data.film.FilmCategory;
import edu.txstate.internet.cyberflix.data.FilmDAO;
import edu.txstate.internet.cyberflix.data.CustomerDAO;

public class DataSource {
	
	FilmDAO filmDAO = new FilmDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	
	public List <Film> findFilmsByTitle(String title, String description, int runtime, FilmRating rating) {
		return filmDAO.findFilmsByAttributes(title, description, runtime, rating);
	}
	
	public List <Film> findNewestFilms(int maxFilms) {
		return filmDAO.findNewestFilms(maxFilms);
	}
	
	public List <Film> findFilmsByCategory(FilmCategory filmCategory) {
		return filmDAO.findFilmsByCategory(filmCategory);
	}
	
	public List <Film> findFilmsAlphabetically(String firstCharacter) {
		return filmDAO.findFilmsAlphabetically(firstCharacter);
	}
	
	public Film getFilmDetail(Film film) {
		return filmDAO.getFilmDetail(film);
	}
	
	public Customer findCustomer(String email) {
		return customerDAO.findCustomer(email);
	}

//	final static String FILM_FILE             = "films.csv";
//	final static String ACTORS_FILE           = "actors.csv";
//	final static String FILM_ACTORS_LINK_FILE = "film_actors.csv";
//	
//	public static void init () {
//		String realPath = ServletUtils.getProjectInputFilesPath();
//		FilmReader aReader = new FilmReader ();
//		List <Film> films   = aReader.readFilmFile(realPath, FILM_FILE);
//        FilmCatalog filmInventory = FilmCatalog.getInstance();
//        filmInventory.addAll (films);
//        
//		ActorReader actorReader = new ActorReader ();
//		List <Actor> actors = actorReader.readActorFile(realPath, ACTORS_FILE);
//		ActorInventory actorInventory = ActorInventory.getInstance();
//		actorInventory.addAll(actors);
//		
//		FilmActorReader filmActorReader = new FilmActorReader ();
//		List <SimpleEntry <Integer, Integer>> pairs = filmActorReader.readFilmActorFile(realPath, FILM_ACTORS_LINK_FILE);
//		
//		FilmActorBuilder builder = new FilmActorBuilder ();
//		builder.build(filmInventory, actorInventory, pairs);
//	}
//	
//	public static List <Film> findFilmByTitle (String title) {
//		StrategyFindFilmByTitle titleSearch = new StrategyFindFilmByTitle(title);
//		List <Film> foundFilms = findFilmByStrategy(titleSearch);
//		return foundFilms;
//	}
//	
//	private static List <Film> findFilmByStrategy (SelectorStrategy strategy) {
//		List <Film>foundFilms = FilmCatalog.getInstance().findFilmByStrategy(strategy);
//		return foundFilms;
//	}
	
	
}
