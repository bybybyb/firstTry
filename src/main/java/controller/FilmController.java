package controller;

import model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.FilmService;
import service.FilmServiceImpl;

import java.util.List;

@Controller
public class FilmController {


     private FilmService filmService = new FilmServiceImpl();


    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView allFilms() {
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }



    // метод для получения страницы редактирования,
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Film film = filmService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("film", film);
        return modelAndView;
    }


    // метод для самого редактирования
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.edit(film);
        return modelAndView;
    }


    // добавление новых элементов в список
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.add(film);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Film film = filmService.getById(id);
        filmService.delete(film);
        return modelAndView;
    }

}