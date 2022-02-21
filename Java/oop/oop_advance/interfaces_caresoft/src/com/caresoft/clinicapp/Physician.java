package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends Usuario implements UsuarioCompatibleConHIPAA {
	
    private ArrayList<String> patientNotes = new ArrayList<String>();
    
    // PARA HACER: Constructor que tome un ID
    public Physician(Integer newId) {
    	super(newId);
    }
    
    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
	public boolean assignPin(int newPin) {
		if ( String.valueOf(newPin).length() == 4 ) {
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
			return false;
		}
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }

    // PARA HACER: Setters y Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}
