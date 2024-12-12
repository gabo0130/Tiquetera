package com.group.tiquetera.infrastructure.config;

import com.group.tiquetera.domain.dto.DefaultErrorResponse;
import com.group.tiquetera.domain.dto.ErrorDataBasic;
import com.group.tiquetera.domain.dto.PathRoutesControllersEnum;
import com.group.tiquetera.infrastructure.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Optional;

@Component("validationErrorBuilder")
public class ValidationErrorBuilder {
	
	@Autowired
	private MessageUtil messageUtil;

	public DefaultErrorResponse fromBindingErrors(Errors errors) {

		DefaultErrorResponse error = new DefaultErrorResponse();
		error.setMessage("Validation failed. " + errors.getErrorCount() + " error(s)");
		PathRoutesControllersEnum pathInfo = PathRoutesControllersEnum.getByObjectName(errors.getObjectName());
		Optional.ofNullable(pathInfo).ifPresent(path -> error.setPath(pathInfo.getRuta()));
		
		for (ObjectError objectError : errors.getAllErrors()) {
			if(FieldError.class.isAssignableFrom(objectError.getClass())) {
				FieldError fieldError = (FieldError) objectError;
				ErrorDataBasic errorField = new ErrorDataBasic();
				errorField.setField(fieldError.getField());
				errorField.setMessage(fieldError.getDefaultMessage());
				error.addError(errorField);
			}
			else {
				ErrorDataBasic errorField = new ErrorDataBasic();
				errorField.setMessage(messageUtil.getMessage(objectError.getDefaultMessage()));
				error.addError(errorField);
			}
			
		}

		return error;
	}

}
