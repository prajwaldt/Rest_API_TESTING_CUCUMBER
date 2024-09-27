package testdataresourse;

public enum Enumclass {
	addplaceApi("/maps/api/place/add/json"),
	getplaceApi("/maps/api/place/get/json"),
	deleteplaceApi("/maps/api/place/delete/json");
	
	public String resourse;
	Enumclass(String resourse)
	{
		this.resourse=resourse;
	}
	
	public String getplaceresourse( )
	{
		return resourse;
	}

}
