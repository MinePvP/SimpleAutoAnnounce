package ch.nonameweb.bukkit.plugins.simpleautoannouncer.language;

public class LangInterface_EN {

	public String getString(String s){
		return parseString(s);
	}

	private String parseString(String s){
		 
		if(s.equalsIgnoreCase("You have not the Permissions")){
			return "You have not the Permissions";
		} else if ( s.equalsIgnoreCase("How to use It:") ) {
			return "How to use It:";
		}  else if ( s.equalsIgnoreCase("This is a Message.") ) {
			return "This is a Message.";
		} else if ( s.equalsIgnoreCase("The Message was added.") ) {
			return "The Message was added.";
		} else if ( s.equalsIgnoreCase("Error : There was no Message found with this Id.") ) {
			return "Error : There was no Message found with this Id.";
		} else if ( s.equalsIgnoreCase("The Messages is Deletet.") ) {
			return "The Messages is Deletet.";
		} else if ( s.equalsIgnoreCase("Message") ) {
			return "Message";
		} else if ( s.equalsIgnoreCase("Set de Debug Mode") ) {
			return "Set de Debug Mode";
		} else if ( s.equalsIgnoreCase("Change de Announce Name") ) {
			return "Change de Announce Name";
		} else if ( s.equalsIgnoreCase("Change the Announce Time") ) {
			return "Change the Announce Time";
		} else if ( s.equalsIgnoreCase("Change the Language") ) {
			return "Change the Language";
		} else if ( s.equalsIgnoreCase("Add a new Message") ) {
			return "Add a new Message";
		} else if ( s.equalsIgnoreCase("Delete a Message on his Id") ) {
			return "Delete a Message on his Id";
		} else if ( s.equalsIgnoreCase("List all Messages") ) {
			return "List all Messages";
		} else if ( s.equalsIgnoreCase("Change the Settings InGame") ) {
			return "Change the Settings InGame";
		} else if ( s.equalsIgnoreCase("The Debug Mode is now ON") ) {
			return "The Debug Mode is now ON";
		} else if ( s.equalsIgnoreCase("The Debug Mode is now ON") ) {
			return "The Debug Mode is now OFF";
		} else if ( s.equalsIgnoreCase("The Announce will be now ") ) {
			return "The Announce will be now ";
		} else if ( s.equalsIgnoreCase("The Language has change to ") ) {
			return "The Language has change to ";
		} else if ( s.equalsIgnoreCase("The Time will be now ") ) {
			return "The Time will be now ";
		} else if ( s.equalsIgnoreCase(" Minutes.") ) {
			return " Minutes.";
		} else if ( s.equalsIgnoreCase("The Spout Notification is ON") ) {
			return "The Spout Notification is ON";
		} else if ( s.equalsIgnoreCase("The Spout Notification is OFF") ) {
			return "The Spout Notification is OFF";
		} else if ( s.equalsIgnoreCase("Change the SpoutNotification") ) {
			return "Change the SpoutNotification";
		} else {
			return "no translation";
		}
		
	}
	
}
