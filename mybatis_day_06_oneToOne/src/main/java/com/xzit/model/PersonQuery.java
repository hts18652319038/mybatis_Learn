package com.xzit.model;

import lombok.Data;

@Data
public class PersonQuery extends Person{
    /*private int pid;
    private String pname;
    private int page;*/
    private int did;
    private String dtype;

    public String toString(){
        StringBuffer sbf = new StringBuffer();
        sbf.append(this.getClass().getSimpleName())
                .append("(")
                .append("pid=").append(getPid()).append(", ")
                .append("page=").append(getPage()).append(", ")
                .append("pname=").append(getPname()).append(", ")
                .append("did=").append(did).append(", ")
                .append("dtype=").append(dtype).append(", ")
                .append(")");
        return sbf.toString();
    }
    /*public String toString(){
        return this.getClass().getName()+"("+getPid()+","+getPname()+","
                +getPage()+","+did+","+dtype+")";
    }*/
}
