package com.example.prisonmangementsystem3;

public class vistors {
    protected  String vistorname;
    protected String vistoraddress;
    protected String vistorphone;
    public String getVistorname(){
        return vistorname;
    }
    public String getVistoraddress(){
        return vistoraddress;
    }
    public String getVistorphone(){
        return vistorphone;
    }
    public void setVistorname(String name){
        vistorname = name;
    }

    public void setVistoraddress(String vistoraddress) {
        this.vistoraddress = vistoraddress;
    }

    public void setVistorphone(String vistorphone) {
        this.vistorphone = vistorphone;
    }

}
