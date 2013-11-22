package edu.ycp.cs481.linkup.model;

public class LookingFor {

	
	//private String inUser;
	private int userid;
	private int ageLow;
	private int ageHigh;
	private int gender;
	private int religion_weight;
	private int seriousness_weight;
	private int state;
	private int childern;
	private int married;
	private int pets;
	private int race;
	private int income;
	private int income_weight;
	
	public LookingFor(int userid, int ageLow, int ageHigh, int gender, int religion_weight, int seriousness_weight, int state, int children, int married, int pets, int race, int income, int income_weight)
	{
		this.userid = userid;
		this.ageLow = ageLow;
		this.ageHigh = ageHigh;
		this.gender = gender;
		this.religion_weight = religion_weight;
		this.seriousness_weight = seriousness_weight;
		this.setState(state);
		this.setChildern(children);
		this.setMarried(married);
		this.setPets(pets);
		this.setRace(race);
		this.setIncome(income);
		this.setIncome_weight(income_weight);
	}
	
	public void setUserid(int inUserid)
	{
		this.userid = inUserid;
	}
	
	public void setAgeLow(int inAgeLow)
	{
		this.ageLow = inAgeLow;
	}
	
	public void setAgeHigh(int inAgeHigh)
	{
		this.ageHigh = inAgeHigh;
	}
	
	public void setGender(int inGender)
	{
		this.gender = inGender;
	}
	
	
	public void setReligionWeight(int inReligionWeight)
	{
		this.religion_weight = inReligionWeight;
	}
	
	public void setseriousnessWeight(int inseriousnessWeight)
	{
		this.seriousness_weight = inseriousnessWeight;
	}
	
	public int getUserid()
	{
		return userid;
	}
	
	public int getAgeLow()
	{
		return ageLow;
	}
	
	public int getAgeHigh()
	{
		return ageHigh;
	}
	
	public int getGender()
	{
		return gender;
	}
	

	public int getReligionWeight()
	{
		return religion_weight;
	}

	
	public int getseriousnessWeight()
	{
		return seriousness_weight;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getChildern() {
		return childern;
	}

	public void setChildern(int childern) {
		this.childern = childern;
	}

	public int getMarried() {
		return married;
	}

	public void setMarried(int married) {
		this.married = married;
	}

	public int getPets() {
		return pets;
	}

	public void setPets(int pets) {
		this.pets = pets;
	}

	public int getRace() {
		return race;
	}

	public void setRace(int race) {
		this.race = race;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getIncome_weight() {
		return income_weight;
	}

	public void setIncome_weight(int income_weight) {
		this.income_weight = income_weight;
	}

	
}