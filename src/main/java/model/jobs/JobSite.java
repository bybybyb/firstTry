package model.jobs;

import java.util.List;

public abstract class JobSite {
    abstract protected String getBasicURL();

    public String buildURL() {
        return getBasicURL() + getEducation() + getProf() + getKeySkills()  + getExperience();
    }

    abstract public List<String> organizationLinks();

    /* getters and setters
    * */
    abstract public void setKeySkills(String[] skills);

    abstract public void setProf(String prof);

    abstract public void setExperience(String experience);

    abstract public void setEducation(String education);


    abstract public String getEducation();

    abstract public String getKeySkills();

    abstract public String getProf();

    abstract public String getExperience();
    //
}
