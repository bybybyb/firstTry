package controller;


import model.jobs.JobSite;
import model.jobs.SuperJob;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class pageController {
    private static String[] jobsaits;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allFilms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView allFilmss(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        List<String> resultLinks = new ArrayList<>();
        try {
        int id = 0;
        jobsaits = request.getParameterValues("websait");
        JobSite[] saits = new JobSite[jobsaits.length];
        for (JobSite sait: saits) {
            Class nameOfSait = Class.forName("model.jobs." + jobsaits[id++]);
            sait = (JobSite) nameOfSait.newInstance();
            sait.setProf(request.getParameter("profession"));
            sait.setEducation(request.getParameter("education"));
            try { sait.setKeySkills(request.getParameterValues("skill"));
            } catch (NullPointerException e) { }
            sait.setExperience(request.getParameter("experience"));
            resultLinks.addAll(sait.organizationLinks());
        }

        modelAndView.addObject("resultList", resultLinks);
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    /*@RequestMapping(value = "/postUser", method = RequestMethod.POST)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("postuser");
        return modelAndView;
    }*/


}
