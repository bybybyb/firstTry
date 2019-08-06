package model.jobs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

public class HHRU extends JobSite {
    static private String basicUrl = "https://hh.ru";
    static private final String basicURL = "https://hh.ru/search/resume?";

    private  TreeMap<String, String> educationMap;
    private  TreeMap<String, String> experienceMap;

    private  String keySkills = "";
    private  String profession = "";
    private  String experience = "";
    private  String education = "";

    public HHRU() {

        educationMap = new TreeMap<>();
        educationMap.put("высшее", "higher");
        educationMap.put("среднее", "secondary");
        educationMap.put("не имеет значения", "none");

        experienceMap = new TreeMap<>();
        experienceMap.put("нет опыта", "noExperience");
        experienceMap.put("От 1 года до 3 лет", "between1And3");
        experienceMap.put("От 3 до 6 лет", "between3And6");
        experienceMap.put("Более 6 лет", "moreThan6");
        experienceMap.put("не имеет значения", "");
    }



    public List<String> organizationLinks() {
        String url = buildURL();
        List<String> resultLinks = new LinkedList<>();
        int countResume = 0;
        boolean flag = true;
        do {
            try {
                Document document = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .get();
                Elements element = document.select("body > div.HH-MainContent.HH-Supernova-MainContent > div > div > div.bloko-columns-wrapper > div > div > div.bloko-gap.bloko-gap_top > div > div > div.bloko-column.bloko-column_l-13.bloko-column_m-9 > div:nth-child(2)");

                for (Element elem : element.select("a")) {
                    if (!elem.text().equals("")) {
                        resultLinks.add(basicUrl + elem.attr("href"));
                    }
                    countResume++;
                }

                try {
                    url = basicUrl + document.selectFirst("body > div.HH-MainContent.HH-Supernova-MainContent > div > div > div.bloko-columns-wrapper > div > div > div.bloko-gap.bloko-gap_top > div > div > div.bloko-column.bloko-column_l-13.bloko-column_m-9 > div.bloko-gap.bloko-gap_top > div > a").attr("href");
                }catch (NullPointerException e) {
                    flag = false;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (flag && countResume < 20);
        return resultLinks;
    }


    @Override
    public String getBasicURL() {
        return basicURL;
    }


    static private String convertStringText(String text) {
        String plusSign = "\\u002B";
        String resultText = text.replaceAll(plusSign, "%2B");
        resultText = resultText.replaceAll(" ", "+");
        return resultText.replaceAll("/", "%2F");
    }


    /*
        * getters and setters */
    @Override
    public void setProf(String prof) {
        if (!prof.equals("")) {
            this.profession = "&text=" + convertStringText(prof) + "&logic=normal&pos=position&exp_period=all_time";
        }
    }


    @Override
    public void setEducation(String education) {
        this.education = "&education=" + educationMap.get(education);
    }


    @Override
    public void setExperience(String experience) {
        this.experience = "&experience=" + experienceMap.get(experience);
    }



    @Override
    public void setKeySkills(String[] skills) {
        if (skills != null) {
            StringBuilder builderSkills = new StringBuilder();
            for (String skill: skills) {
                builderSkills.append("&text=" + skill + "&logic=normal&pos=keywords&exp_period=all_time");
            }
            this.keySkills = builderSkills.toString();
        }
    }


    @Override
    public String getProf() {
        return this.profession;
    }


    @Override
    public String getEducation() {
        return this.education;
    }

    @Override
    public String getExperience() {
        return this.experience;
    }

    @Override
    public String getKeySkills() {
        return this.keySkills;
    }

}
