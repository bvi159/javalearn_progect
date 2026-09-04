package com.javarush.examples.Lesson_10_7;

import java.io.Serializable;

public class SavedGame implements Serializable {

//    private static final long serialVersionUID = 1L;

    private transient TerritoriesInfo territoriesInfo;
    private ResourcesInfo resourcesInfo;
    private DiplomacyInfo diplomacyInfo;

    public SavedGame(TerritoriesInfo territoriesInfo, ResourcesInfo resourcesInfo, DiplomacyInfo diplomacyInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public TerritoriesInfo getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(TerritoriesInfo territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public ResourcesInfo getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(ResourcesInfo resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public DiplomacyInfo getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(DiplomacyInfo diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "com.javarush.examples.Lesson_10_7.SavedGame{" +
                "territoriesInfo=" + territoriesInfo +
                ", resourcesInfo=" + resourcesInfo +
                ", diplomacyInfo=" + diplomacyInfo +
                '}';
    }
}
