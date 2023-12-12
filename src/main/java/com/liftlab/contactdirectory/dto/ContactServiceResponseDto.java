package com.liftlab.contactdirectory.dto;

import io.swagger.annotations.ApiModel;

/**
 * @author hemanthjamili
 *
 */
@ApiModel(description = "This is reponse dto object return by all APIs present in ContactControllerV1")
public class ContactServiceResponseDto {

	private Object payload;

	private String message;

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ContactServiceResponseDto(Object payload, String message) {
		super();
		this.payload = payload;
		this.message = message;
	}

	public ContactServiceResponseDto() {
		super();
	}
}
