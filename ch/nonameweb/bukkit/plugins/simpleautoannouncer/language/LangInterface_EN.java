package ch.nonameweb.bukkit.plugins.simpleautoannouncer.language;

public class LangInterface_EN {

	public String getString(String s){
		return parseString(s);
	}

	private String parseString(String s){
		 
		if(s.equalsIgnoreCase("You have not the Permissions")){
			return "Du hast nicht die nötigen Rechte";
		} else if ( s.equalsIgnoreCase("How to use It:") ) {
			return "So benutzt du den Befehl:";
		}  else if ( s.equalsIgnoreCase("This is a Message.") ) {
			return "Dies ist eine Nachricht.";
		} else if ( s.equalsIgnoreCase("The Message was added.") ) {
			return "Die Nachricht wurde hinzugefügt.";
		} else if ( s.equalsIgnoreCase("Error : There was no Message found with this Id.") ) {
			return "Fehler : Es ist keine Nachricht mit dieser Id gefunden worden.";
		} else if ( s.equalsIgnoreCase("The Messages is Deletet.") ) {
			return "Die Nachricht wurde gelöscht";
		} else if ( s.equalsIgnoreCase("Message") ) {
			return "Nachricht";
		} else if ( s.equalsIgnoreCase("Set de Debug Mode") ) {
			return "Debug Modus einschalten";
		} else if ( s.equalsIgnoreCase("Change de Announce Name") ) {
			return "Den Announcement Namen ändern";
		} else if ( s.equalsIgnoreCase("Change the Announce Time") ) {
			return "Die Zeit zwischen den Announcen ändern";
		} else if ( s.equalsIgnoreCase("Change the Language") ) {
			return "Sprache ändern";
		} else if ( s.equalsIgnoreCase("Add a new Message") ) {
			return "Neue Nachricht hinzufügen";
		} else if ( s.equalsIgnoreCase("Delete a Message on his Id") ) {
			return "Löschen einer Nachricht";
		} else if ( s.equalsIgnoreCase("List all Messages") ) {
			return "Alle Nachrichten auflisten";
		} else if ( s.equalsIgnoreCase("Change the Settings InGame") ) {
			return "Ändern der Einstellungen im Spiel";
		} else if ( s.equalsIgnoreCase("The Debug Mode is now ON") ) {
			return "Der Debug Modus ist nun eingeschalten";
		} else if ( s.equalsIgnoreCase("The Debug Mode is now OFF") ) {
			return "Der Debug Modus ist nun ausgeschaltet";
		} else if ( s.equalsIgnoreCase("The Announce will be now ") ) {
			return "Der Announce Titel ist nun ";
		} else if ( s.equalsIgnoreCase("The Language has change to ") ) {
			return "Die Sprache ist nun ";
		} else if ( s.equalsIgnoreCase("The Time will be now ") ) {
			return "Die Zeit zwischen den Announcen ist nun ";
		} else if ( s.equalsIgnoreCase(" Minutes.") ) {
			return " Minuten";
		} else if ( s.equalsIgnoreCase("The Spout Notification is ON") ) {
			return "Die Spout Benachrichtigung ist eingeschaltet";
		} else if ( s.equalsIgnoreCase("The Spout Notification is OFF") ) {
			return "Die Spout Benachrichtigung ist ausgeschaltet";
		} else if ( s.equalsIgnoreCase("Change the SpoutNotification") ) {
			return "Ändern der Spout Benachrichtigung";
		} else {
			return "keine übersetzung vorhanden";
		}
		
	}
	
}
