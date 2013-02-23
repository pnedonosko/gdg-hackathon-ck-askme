
import ua.org.gdg.cherkasy.hackathon.askme.translation.GoogleTranslator
import ua.org.gdg.cherkasy.hackathon.askme.translation.Languages
import ua.org.gdg.cherkasy.hackathon.askme.translation.TextEntry

def translator = new GoogleTranslator()
def result = translator.translate(Languages.UK, new TextEntry(Languages.EN, "Hello, world"))

println result.getText()