package com.ktamr.util;

import java.util.List;

/***
 * 定义一个菜单类
 *
 */
public class Menu {


    private String id;
    private String pId;
    private String LevelType;
    private String name;
    private String iconSkin;
    private Boolean open;
    private boolean isParent;
    private List<Menu> children;

    public String getLevelType() {
        return LevelType;
    }

    public void setLevelType(String levelType) {
        this.LevelType = levelType;
    }

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

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
