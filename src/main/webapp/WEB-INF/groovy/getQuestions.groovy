import ua.org.gdg.cherkasy.hackathon.askme.*
import ua.org.gdg.cherkasy.hackathon.askme.translation.GoogleTranslator
import ua.org.gdg.cherkasy.hackathon.askme.translation.TextEntry

import com.google.appengine.labs.repackaged.org.json.JSONArray

def translator = new GoogleTranslator()

def targetLang = params.lang
def questions = [:]
for (q in Question.findAll()) {
	q.text = translator.translate(targetLang, new TextEntry(q.lang, q.text)).text
	log.info "Question ${q.text} $targetLang ${q.lang}"
	questions.put(q.qid, q)
	//new Question(qid : q.qid, text :  q.text, lang :  q.lang, created : null, status : 0))
}

response.renderJson questions

