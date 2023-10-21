package mx.com.cuamatziinc.reservasalas.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ResponseErrorCustom implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sourceMessage;
	private String message;
	private String url;
	private String method;
	private LocalDateTime timestamp;
	
	
	
	public String getSourceMessage() {
		return sourceMessage;
	}
	public void setSourceMessage(String sourceMessage) {
		this.sourceMessage = sourceMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	

}
