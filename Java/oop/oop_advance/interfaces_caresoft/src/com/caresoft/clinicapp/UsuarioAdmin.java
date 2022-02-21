package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioAdmin extends Usuario implements UsuarioCompatibleConHIPAA, AdminCompatibleConHIPAA {

    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // PARA HACER: Implementar un constructor que tome un ID y un rol
    public UsuarioAdmin(Integer newId, String newRole) {
    	super(newId);
    	this.employeeID = newId;
    	this.role = newRole;
    }
    
    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
	public boolean assignPin(int newPin) {
		if ( String.valueOf(newPin).length() >= 6 ) {
			this.setPin(newPin);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean accessAuthorized(Integer idToVerify) {
		if (this.id == idToVerify) {
			return true;
		}else {
			authIncident();
			return false;
		}
	}
    
    // PARA HACER: ¡Implementar AdminCompatibleConHIPAA
	public ArrayList<String> reportSecurityIncidents(){
		return securityIncidents;
	}
	
    
    public void newIncident(String notes) {
        String report = String.format(
            "Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n", 
            new Date(), this.id, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }

    // PARA HACER: Setters y Getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}    
}
