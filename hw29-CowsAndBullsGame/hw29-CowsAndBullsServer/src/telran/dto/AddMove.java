package telran.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AddMove implements Serializable{
	
	Long id;
	String moveRes;
	
	public AddMove(long id, String moveRes) {
		super();
		this.id = id;
		this.moveRes = moveRes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMoveRes() {
		return moveRes;
	}
	public void setMoveRes(String moveRes) {
		this.moveRes = moveRes;
	}
	

}
