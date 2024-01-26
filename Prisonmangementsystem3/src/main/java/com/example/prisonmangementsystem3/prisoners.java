package com.example.prisonmangementsystem3;

public class prisoners {
    protected String tasktile;
    protected String taskdesc;
    protected double taskpay;
    protected int prisoncell;
    protected int prisonertemp;
    protected String prisonerintakedate;
    protected String prisonerrelasedata;
    protected String crimedesc;
    protected String crimejuriction;
    protected boolean parole;
    protected int prisonsentence;
    protected String prisonerDoB;
    protected String prisonerartifact;
    protected double prisonermoney;
    protected String prisonerfname;
    protected String prisonerlname;
    protected String prisonermname;
    protected int prisonerheight;
    protected int prisonerwieght;
    public prisoners(){
        prisonerfname = "first";
        prisonermname = "middle";
        prisonerlname = "Last";
        prisonerwieght = 0;
        prisonerheight = 0;
    }
    public void setTaskdesc(String tdesc){
        taskdesc = tdesc;

    }
    public String getTasktile(){
        return taskdesc;
    }

    public void setTasktile(String tasktile) {
        this.tasktile = tasktile;
    }

    public void setPrisonerDoB(String doB){
        prisonerDoB = doB;
    }
    public String getPrisonerDoB(){
        return prisonerDoB;
    }
    public int getPrisonerheight(){
        return prisonerheight;
    }

    public void setPrisonerlname(String prisonerlname) {
        this.prisonerlname = prisonerlname;
    }
    public String getPrisonerlname(){
        return prisonerlname;
    }

    public void setPrisonerintakedate(String prisonerintakedate) {
        this.prisonerintakedate = prisonerintakedate;
    }

    public void setPrisonertemp(int prisonertemp) {
        this.prisonertemp = prisonertemp;
    }

    public void setPrisonermname(String prisonermname) {
        this.prisonermname = prisonermname;
    }

    public String getPrisonermname() {
        return prisonermname;
    }

    public void setPrisonerrelasedata(String prisonerrelasedata) {
        this.prisonerrelasedata = prisonerrelasedata;
    }

    public String getPrisonerintakedate() {
        return prisonerintakedate;
    }

    public String getPrisonerrelasedata() {
        return prisonerrelasedata;
    }

    public String getPrisonerartifact() {
        return prisonerartifact;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setPrisonerartifact(String prisonerartifact) {
        this.prisonerartifact = prisonerartifact;
    }

    public void setPrisonerwieght(int prisonerwieght) {
        this.prisonerwieght = prisonerwieght;
    }

    public void setPrisonerfname(String prisonerfname) {
        this.prisonerfname = prisonerfname;
    }
    public void setPrisoncell(int prisoncell) {
        this.prisoncell = prisoncell;
    }
    public void setPrisonerheight(int height){
        prisonerheight = height;
    }
    public int getPrisonertemp(){
     return prisonertemp;
    }
    public int getPrisoncell(){
        return prisoncell;
    }
    public int getPrisonsentencee(){
        return prisonsentence;
    }
    public void setPrisonsentence(int prisonsentence) {
        this.prisonsentence = prisonsentence;
    }
    public boolean getisParole() {
        return parole;
    }
    public String getPrisonerfname(){
        return prisonerfname;
    }
    public void setParole(boolean parole) {
        this.parole = parole;
    }
    public double getTaskpay(){
        return taskpay;
    }

    public void setTaskpay(double taskpay) {
        this.taskpay = taskpay;
    }

    public double getPrisonermoney(){
        return  prisonermoney;
    }

    public void setPrisonermoney(double prisonermoney) {
        this.prisonermoney = prisonermoney;
    }

    public String getCrimedesc() {
        return crimedesc;
    }
    public String getCrimejuriction(){
        return crimejuriction;

    }
    public void setCrimejuriction(String crimejuriction) {
        this.crimejuriction = crimejuriction;
    }

    public void setCrimedesc(String crimedesc) {
        this.crimedesc = crimedesc;
    }

}
