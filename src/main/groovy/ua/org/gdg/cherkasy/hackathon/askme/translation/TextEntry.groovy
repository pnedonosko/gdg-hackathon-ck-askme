package ua.org.gdg.cherkasy.hackathon.askme.translation

public class TextEntry {
	
	private final String sourceLang;
	
	private final String targetLang;
	
	private final String original;
	
	private final String translate;
	
	private final String translit;
	
	public TextEntry(String lang, String text)
	{
		this.targetLang = lang;
		this.translate = text;
		
		this.sourceLang = null;
		this.original = null;
		this.translit = null;
	}

	public TextEntry(String sourceLang, String targetLang, String original, String translate, String translit)
	{
		this.sourceLang = sourceLang;
		this.targetLang = targetLang;
		this.original = original;
		this.translate = translate;
		this.translit = translit;
	}
	
	public String getSourceLanguage()
	{
	    return sourceLang;
	}
	
	public String getTargetLanguage()
	{
	    return targetLang;
	}
	
	public String getOriginal()
	{
	    return original;
	}

	public String getTranslate()
	{
	    return translate;
	}

	public String getTranslit()
	{
	    return translit;
	}
	
	public String getLanguage()
	{
		return targetLang;
	}
	
	public String getText()
	{
		return translate;
	}
	
}
