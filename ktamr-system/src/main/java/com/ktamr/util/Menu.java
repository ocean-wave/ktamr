package com.ktamr.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * 定义一个菜单类 B用
 *
 */
public class Menu {


    private String id;
    private String pId;
    private String LevelType;
    private String name;
    private String iconSkin;
    private boolean isParent;
    private List<Menu> children;

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

    @JsonProperty("LevelType")
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

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
