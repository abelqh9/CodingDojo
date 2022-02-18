import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // No necesitas codificar aquí, este es un método de ejemplo
        return "Hola, encantado de verte. ¿Cómo estás?";
    }
    
    public String guestGreeting(String name) {
        // TU CÓDIGO AQUI
        return "Hola, " + name + ". Encantado de verte.";
    }

    // BONUS NINJA
    public String guestGreeting(String name, String dayPeriod) {
        // TU CÓDIGO AQUI
        return "Buenas " + dayPeriod + ", " + name + ". Encantado de verte.";
    }
    
    public String dateAnnouncement() {
        // TU CÓDIGO AQUI
        Date date = new Date();
        return "Actualmente es " + date + ".";
    }
    
    public String respondBeforeAlexis(String conversation) {
        // TU CÓDIGO AQUI
        if ( conversation.indexOf("Alexis") > 0 ){
            return "De inmediato, señor. Ciertamente no es lo suficientemente sofisticada para eso.";
        }else if ( conversation.indexOf("Alfred") > 0 ){
            return "A su servicio. Como desee, naturalmente.";
        }else{
            return "Bien. Y con eso, me retiraré.";
        }
    }
    
	// BONUS NINJA
	// Ver las especificaciones para sobrecargar el método guessGreeting
    // ="comment from-rainbow">// BONUS SENSEI
    // ¡Escribe tu propio método AlfredQuotes usando cualquiera de los métodos String que has aprendido!
}