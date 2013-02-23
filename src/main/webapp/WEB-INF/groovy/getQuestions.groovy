import ua.org.gdg.cherkasy.hackathon.askme.*
import ua.org.gdg.cherkasy.hackathon.askme.translation.GoogleTranslator
import ua.org.gdg.cherkasy.hackathon.askme.translation.TextEntry

def translator = new GoogleTranslator()
//def period = params.p
//def json
//def where
//if (period) {
	//where = "created > $period"
//}
//def result = translator.translate(Languages.UK, new TextEntry(Languages.EN, params.text))

def targetLang = params.lang
def questions = []
for (q in Question.findAll()) {
	log.info "Question ${q.text}"
	q.text = translator.translate(targetLang, new TextEntry(q.lang, params.text))
	questions << q
} 

//json = jsonLibBuilderFactory.jsonLibBuilder.json { id = user.deviceId }
response.renderJson questions

