package com.ktamr.util;

import java.util.List;

public class Menus {

    private String id;
    private String pId;
    private String LevelType;
    private String name;
    private String iconSkin;
    private Boolean open;
    private Boolean isParent;
    private List<Menus> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getLevelType() {
        return LevelType;
    }

    public void setLevelType(String levelType) {
        LevelType = levelType;
    }

    public String getName() {
        if(name==null|| name.length()==0){
            return " ";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconSkin() {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public List<Menus> getChildren() {
        return children;
    }

    public void setChildren(List<Menus> children) {
        this.children = children;
    }
}
