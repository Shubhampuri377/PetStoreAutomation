package api.payload;


public class Pet {
    public String name;
    public String status="available";
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	public String getStatus()
	{
		return status;
	}
	
	public String setStatus(String status)
	{
		status=this.status;
		return status;
	}
    
   
}

