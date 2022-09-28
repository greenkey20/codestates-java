package com.codestates.section2.unit2.tree;

import java.util.ArrayList;

// 2022.9.26(월) 11h
public class TreeImplementationDraft {
    private String value;
    private ArrayList<TreeImplementationDraft> children;

    public TreeImplementationDraft() {    //전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }

    public TreeImplementationDraft(String data) {    //전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = "FILL_ME_IN";
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return "FILL_ME_IN";
    }

    public void addChildNode(TreeImplementationDraft node) {
//        if ("FILL_ME_IN") children = new ArrayList<>();
//        children.add("FILL_ME_IN");
    }

    public void removeChildNode(TreeImplementationDraft node) {
        String data = node.getValue();

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if (children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<TreeImplementationDraft> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if (value.equals(data)) return true;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                return children.get(i).contains("FILL_ME_IN");
            }
        }
        return false;
    }
}
