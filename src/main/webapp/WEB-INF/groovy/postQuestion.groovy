import ua.org.gdg.cherkasy.hackathon.askme.*

def json
def lang = params.lang
def text = params.text
if (text) {
	def qid = System.currentTimeMillis() + '-' + text.hashCode()
	def q = new Question(qid : qid, text : text, lang : lang, created : Calendar.getInstance().getTime(),
			status : 0)
	q.save()
	json = jsonLibBuilderFactory.jsonLibBuilder.json { qid = q.qid }
} else {
	json = jsonLibBuilderFactory.jsonLibBuilder.json { error = "Text expected" }
}
response.renderJson json






