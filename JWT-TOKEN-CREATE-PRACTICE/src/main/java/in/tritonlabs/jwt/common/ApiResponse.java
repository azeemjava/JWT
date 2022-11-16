package in.tritonlabs.jwt.common;

public class ApiResponse {

	private int ststus;
	private Object data;
	private Object error;

	
	public ApiResponse() {
		super();
	}

	
	
	public int getStstus() {
		return ststus;
	}

	public void setStstus(int ststus) {
		this.ststus = ststus;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

}
