package ua.org.gdg.cherkasy.hackathon.askme.translation

public interface Translator {
	
	public TextEntry translate(String toLanguage, TextEntry origin);

}
