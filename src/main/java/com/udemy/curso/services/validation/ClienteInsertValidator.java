package com.udemy.curso.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.udemy.curso.domain.dto.ClienteNewDTO;
import com.udemy.curso.domain.enums.TipoCliente;
import com.udemy.curso.resources.exception.FieldMessage;
import com.udemy.curso.utils.ValidarCPForCNPJ;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Override
	public void initialize(ClienteInsert ann) {
		
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !ValidarCPForCNPJ.isValidCPF(objDto.getCpfOrCnpf())) {
			list.add(new FieldMessage("cpfOrCnpf", "CPF inválido!!"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !ValidarCPForCNPJ.isValidCNPJ(objDto.getCpfOrCnpf())) {
			list.add(new FieldMessage("cpfOrCnpf", "CNPJ inválido!!"));
		}
		
		
		for (FieldMessage e : list) {
			
			context.disableDefaultConstraintViolation();
			
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();
	}


}
